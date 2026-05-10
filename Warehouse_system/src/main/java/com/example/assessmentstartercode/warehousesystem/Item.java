package com.example.assessmentstartercode.warehousesystem;

import java.io.Serializable;
import java.util.Objects;

public class Item implements Serializable {

    private String itemId;
    private String itemName;
    private double itemPrice;
    private int pcsInPackage;
    private int packagesInPallet;
    private int reorderPoint;

    private static final long serialVersionUID = 1L;

    public Item(String itemId, String itemName, double itemPrice, int pcsInPackage, int packagesInPallet, int reorderPoint) {
        setItemId(itemId);
        setItemName(itemName);
        setItemPrice(itemPrice);

        setPcsInPackage(pcsInPackage);
        setPackagesInPallet(packagesInPallet);
        setReorderPoint(reorderPoint);

    }

    public void setItemId(String itemId) {
        if (!itemId.matches("(\\p{Digit}){2,25}")) {
            System.out.println("Invalid ID");
        }
        this.itemId = itemId;
    }

    public void setPcsInPackage(int pcsInPackage) {
        if (pcsInPackage <= 0) {
            System.out.println("Invalid");
        }
        this.pcsInPackage = pcsInPackage;
    }

    public void setPackagesInPallet(int packagesInPallet) {
        if (packagesInPallet <= 0) {
            System.out.println("Invalid value");
        }
        this.packagesInPallet = packagesInPallet;
    }

    public void setReorderPoint(int reorderPoint) {
        if (reorderPoint <= 0) {
            System.out.println("Invalid reorder point");
        }
        this.reorderPoint = reorderPoint;
    }

    public void setItemName(String itemName) {
        if (!itemName.matches("(\\p{ASCII}){2,25}")) {
            System.out.println("Invalid name");
            //throw new IllegalArgumentException("Invalid name");
        }
        this.itemName = itemName;
    }

    public void setItemPrice(double itemPrice) {
        if (itemPrice <= 0) {
            System.out.println("Invalid price");
            //throw new IllegalArgumentException("Invalid price");
        }
        this.itemPrice = itemPrice;
    }

    public String getItemId() {
        return itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public double getItemPrice() {
        return itemPrice;
    }

    public int getPcsInPackage() {
        return pcsInPackage;
    }

    public int getPackagesInPallet() {
        return packagesInPallet;
    }

    public int getReorderPoint() {
        return reorderPoint;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Item)) return false;
        Item item = (Item) o;
        return Objects.equals(itemId, item.itemId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(itemId);
    }

    @Override
    public String toString() {
        return "Item{" +
                "itemId='" + itemId + '\'' +
                ", itemName='" + itemName + '\'' +
                ", itemPrice=" + itemPrice +
                ", pcsInPackage=" + pcsInPackage +
                ", packagesInPallet=" + packagesInPallet +
                ", reorderPoint=" + reorderPoint +
                '}';
    }
}

