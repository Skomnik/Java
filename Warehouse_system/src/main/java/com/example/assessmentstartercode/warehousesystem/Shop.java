package com.example.assessmentstartercode.warehousesystem;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Shop implements Serializable {
    private int capacity;
    private Map<Item, Integer> items = new HashMap<>();
    private Map<Item, Integer> ordertobuff = new HashMap<>();
    private Map<Item, Integer> allsales = new HashMap<>();

    private static final long serialVersionUID = 1L;

    public Shop(int capacity) {
        this.capacity = capacity;
    }

    public int getItemQuantity(Item item) { // getter (used from form to check can we sell item)
        return items.getOrDefault(item, 0);
    }

    public void sellItem(Item item, int quantity) { //selling item from shop
        int itemQuantity = items.getOrDefault(item, 0);
        if (itemQuantity < quantity) {
            System.out.println("Not enough stock!");
            return;
        }

        items.replace(item, itemQuantity - quantity);
        // counting all sales

        if (allsales.containsKey(item)) {
            int currentquantity = allsales.getOrDefault(item, 0);
            allsales.replace(item, currentquantity + quantity);
        } else {
            allsales.put(item, quantity);
        }

        if (items.get(item) <= item.getReorderPoint()) {
            System.out.println("Requesting restock from buffer");
            ordertobuff.put(item, item.getPcsInPackage());
            // System.out.println();
            //System.out.println(ordertobuff);
            // System.out.println();
        }
    }


    public void fillItems(Item item, int quantity) { //used for prefilling shop
        if (quantity >= 0) {
            items.put(item, quantity);
        } else {
            System.out.println("Wrong quantity");
        }
    }

    public void addPackage(Item item) { // adding items to shop by default package
        int packageSize = item.getPcsInPackage();

        if (getCurrentTotalUnits() + packageSize > capacity) {
            System.out.println("No space in the store " + item.getItemName());
            return;
        }

        int current = items.getOrDefault(item, 0);
        items.put(item, current + packageSize);
        System.out.println("Accepted " + packageSize + " pcs. Availability: " + (capacity - getCurrentTotalUnits()));
    }

    public void addPackage(Item item, int qty) { //adding items to shop with qty

        if (getCurrentTotalUnits() + qty > capacity) {
            System.out.println("No space in the store " + item.getItemName());
            return;
        }

        int current = items.getOrDefault(item, 0);
        items.put(item, current + qty);
        //System.out.println("got it");

    }

    public int getCurrentTotalUnits() { //to check engaged space in shop
        return items.values().stream().mapToInt(Integer::intValue).sum();
    }


    public Map<Item, Integer> getItemsMap() {  //to show all items in shop
        return items;
    }

    public Map<Item, Integer> getOrdersMap() { // to show ordered items
        return ordertobuff;
    }

    public Map<Item, Integer> getAllsales() { // to show all sales
        return allsales;
    }

    public void writeToFile(String filename) { // save data to file
        try (ObjectOutputStream out = new ObjectOutputStream(
                new FileOutputStream(filename))) {
            out.writeObject(this);
        } catch (IOException e) {
            System.out.println("Error write Shop");
        }
    }

    public static Shop readFromFile(String filename) { //load data from file
        try (ObjectInputStream in = new ObjectInputStream(
                new FileInputStream(filename))) {
            return (Shop) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error read Shop");
            return null;
        }
    }

    public void show() { // not in use (used in console version)
        for (Map.Entry<Item, Integer> entry : items.entrySet()) {
            Item p = entry.getKey();
            Integer q = entry.getValue();
            System.out.println(p + " " + q);
        }
    }

    public void deleteItem(Item item) { //not in use yet. in case if you need manually add items from potential return
        items.remove(item);
    }

    @Override
    public String toString() {
        return "Shop{" +
                "capacity=" + capacity +
                ", items=" + items +
                ", ordertobuff=" + ordertobuff +
                ", allsales=" + allsales +
                '}';
    }
}
