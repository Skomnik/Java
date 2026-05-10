package com.example.assessmentstartercode.warehousesystem;

import java.io.*;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Buffer implements Serializable {
    private final int capacity;
    public Map<Item, Integer> stock = new HashMap<>();
    public Map<Item, Integer> ordertosup = new HashMap<>();

    private static final long serialVersionUID = 1L;

    public void moveToShop(Item item, Shop shop) {  //not in use (for console version)
        int current = stock.getOrDefault(item, 0);
        if (current <= 0) {
            System.out.println("Out of stock! Ordering from supplier");
            orderToSupplier(item);
            return;
        }
        stock.put(item, current - item.getPcsInPackage());
        shop.addPackage(item);

        if (stock.get(item) <= item.getReorderPoint()) {
            System.out.println("Requesting restock from warehouse");
            ordertosup.put(item, item.getPackagesInPallet());
        }
    }


    public Buffer(int capacity) { //setting max size for buffer
        this.capacity = capacity;

    }

    public double getCurrentTotalPallets() { // check current used space in pallets
        double totalPallets = 0;
        for (Map.Entry<Item, Integer> entry : stock.entrySet()) {
            Item item = entry.getKey();
            int units = entry.getValue();
            int unitsInOnePallet = item.getPcsInPackage() * item.getPackagesInPallet();
            totalPallets += (double) units / unitsInOnePallet;
        }
        return totalPallets;
    }

    public void orderToSupplier(Item item) { //making orders to supplier

        if (getCurrentTotalPallets() + 1 > capacity) {
            System.out.println("No Space in the buffer for " + item.getItemName());
            return;
        }
        int unitsInPallet = item.getPcsInPackage() * item.getPackagesInPallet();
        ordertosup.put(item, unitsInPallet);
        System.out.println("Pallet " + item.getItemName() + " ordered");
        //stock.put(item, stock.getOrDefault(item, 0) + unitsInPallet);
    }


    public Map<Item, Integer> getItemsMap() { //used to show items in the buffer
        return stock;
    }

    public Map<Item, Integer> getOrdersMap() { // used to show ordered items
        return ordertosup;
    }


    public boolean fulfillShopOrder(Item item, Shop shop) { // used for filling shop from buffer
        Integer requestedQty = shop.getOrdersMap().get(item);
        if (requestedQty == null) return false;
        int currentStock = stock.getOrDefault(item, 0);
        if (currentStock >= requestedQty) {
            stock.put(item, currentStock - requestedQty);
            shop.addPackage(item, requestedQty);
            shop.getOrdersMap().remove(item);
            checkSupplierNeed(item);
            return true;

        } else if (currentStock > 0 && currentStock < requestedQty) {
            stock.put(item, 0);
            shop.addPackage(item, currentStock);
            shop.getOrdersMap().remove(item);
            checkSupplierNeed(item);
            System.out.println("Sent partial order: only " + currentStock + " available");
            return true;
        }
        return false;
    }

    public void checkSupplierNeed(Item item) {  // checking amount of specific item to make order if needed
        int currentStock = stock.getOrDefault(item, 0);
        int palletSize = item.getPcsInPackage() * item.getPackagesInPallet();
        if (currentStock < palletSize * 0.35) {
            ordertosup.put(item, palletSize);
        }
    }

    public void checkoToOrder() { // checking amount of all item to make order if needed
        for (Map.Entry<Item, Integer> entry : ordertosup.entrySet()) {
            Item p = entry.getKey();
            Integer q = entry.getValue();
            if (q <= (p.getPcsInPackage() * p.getPackagesInPallet()) * 0.35) {
                ordertosup.put(p, p.getPcsInPackage() * p.getPackagesInPallet());
            }
        }
    }

    public boolean fulfillSupplierOrder(Item item) throws IOException { // making order to supplier by adding to file (some kind of invoice)
        Integer qty = ordertosup.get(item);
        if (qty == null) return false;
        LocalDate date = LocalDate.now();
        String datestring = String.valueOf(date);
        String filename = "OrdertoSupplier_" + datestring + ".txt";
        FileWriter writer = new FileWriter(filename, true);
        writer.write("Id: " + item.getItemId() + " Name: " + item.getItemName() + " : " + qty + " Qty \n");
        writer.close();
        System.out.println("Added to orderfile");
        ordertosup.remove(item);
        return true;
    }


    public void fillItems(Item item, int quantity) { //adding items to buffer
        if (quantity >= 0) {
            stock.put(item, quantity);
        } else {
            System.out.println("Wrong quantity");
        }

    }

    public void addPackage(Item item) { //not in use yet. in case if you need manually add items from potential return
        int current = stock.getOrDefault(item, 0);
        stock.replace(item, current + item.getPcsInPackage());
    }

    public void add(Item item, int qty) { //not in use yet. in case if you need manually add items from potential return
        stock.put(item, qty);
    }

    public void deleteItem(Item item) { //not in use yet. in case if you need manually add items from potential return
        stock.remove(item);
    }


    public void writeToFile(String filename) throws Exception { //save data to file
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filename))) {
            out.writeObject(this);
        } catch (IOException e) {
            throw new Exception("Error writing Buffer to file", e);
        }
    }

    public static Buffer readFromFile(String filename) throws Exception { // load data from file
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename))) {
            return (Buffer) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            throw new Exception("Error reading Buffer from file", e);
        }
    }

    public void show() { // not in use (used in console version)
        for (Map.Entry<Item, Integer> entry : stock.entrySet()) {
            Item p = entry.getKey();
            Integer q = entry.getValue();
            System.out.println(p + " " + q);
        }
    }


    @Override
    public String toString() {
        return "Buffer{" +
                "capacity=" + capacity +
                ", stock=" + stock +
                ", ordertosup=" + ordertosup +
                '}';
    }
}

