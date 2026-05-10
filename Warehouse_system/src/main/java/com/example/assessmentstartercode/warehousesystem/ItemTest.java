package com.example.assessmentstartercode.warehousesystem;

public class ItemTest {
    public static void main(String[] args) throws InputValidationException {
        Item item = new Item("111", "Stoense", 55, 10, 5, 5);
        Item item1 = new Item("11", "S", 0, 10, 5, 5);

        System.out.println(item);
    }
}
