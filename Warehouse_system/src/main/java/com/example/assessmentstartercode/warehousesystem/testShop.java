package com.example.assessmentstartercode.warehousesystem;

import java.util.Date;

public class testShop {
    public static void main(String[] args) throws InputValidationException {
        Shop shop1 = new Shop(5);
        shop1.addPackage(new Item("123", "Qwe", 3, 5, 5, 4), 5);
        System.out.println(shop1);
        shop1.addPackage(new Item("124", "Asd", 4, 5, 5, 4), 5);
        shop1.addPackage(new Item("125", "Zxc", 5, 5, 5, 4), 5);
        shop1.addPackage(new Item("126", "Qaz", 6, 5, 5, 4), 5);
        shop1.addPackage(new Item("127", "Wer", 7, 5, 5, 4), 5);
        System.out.println(shop1);

        Shop shop2 = new Shop(5000000);
        long start = (new Date()).getTime();

        for (int i = 0; i < 100000; i++) {
            shop2.addPackage(new Item("128" + i, "Name" + i, 5, 5, 5, 3), 1);
        }

        double end = (double) ((new Date()).getTime() - start) / 1000.0;
        System.out.println("Time taken to add: " + end + " secs");

        start = (new Date()).getTime();

        for (int i = 0; i < 1000000; i++) {
            shop2.getItemsMap();

        }

        end = (double) ((new Date()).getTime() - start) / 1000.0;
        System.out.println("Time taken to get: " + end + " secs");

        shop1.show();
    }
}
