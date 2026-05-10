package com.example.assessmentstartercode.warehousesystem;

import java.util.ArrayList;
import java.util.List;

public class MidLayer {

    public static Shop shop = new Shop(100);
    public static Buffer buffer = new Buffer(500);
    public static List<Employee> salesassoc = new ArrayList<>();
    public static List<Employee> warehouseassoc = new ArrayList<>();
    public static List<Employee> managers = new ArrayList<>();


    static {
        // here is all my staff
        try {
            salesassoc.add(new SalesAssociate("Nikita", "sales", "Nik", "123"));
            warehouseassoc.add(new WarehouseAssociate("Anton", "warehouse", "Ant", "234"));
            managers.add(new Manager("Jim", "manager", "Jim", "456"));

        } catch (InputValidationException e) {
            throw new RuntimeException(e);
        }
        //prefilled items

        Item itemOne = new Item("101", "Stoense", 49, 10, 5, 5);
        Item itemTwo = new Item("102", "Vodskov", 25, 15, 4, 8);
        Item itemThree = new Item("103", "Morum", 69, 20, 2, 10);
        Item itemFour = new Item("104", "Tiphde", 69, 20, 2, 10);


        shop.fillItems(itemOne, 10);
        shop.fillItems(itemTwo, 5);
        shop.fillItems(itemThree, 20);
        shop.fillItems(itemFour, 20);

        buffer.fillItems(itemOne, 10);
        buffer.fillItems(itemTwo, 10);
        buffer.fillItems(itemThree, 1);
        buffer.fillItems(itemFour, 20);


    }
}