package com.example.assessmentstartercode.warehousesystem;

public class testManager {
    public static void main(String[] args) throws InputValidationException {
        Manager manager = new Manager("Jack","manager","Mana","123");
        System.out.println(manager.getEmployeeName());
        Manager manager1 = new Manager("Ja","manager","Mana","123");
        System.out.println(manager1.getEmployeeName());
        Manager manager2 = new Manager("Ji","Manager","Mana","123");
        System.out.println(manager2.getEmployeeName());
    }
}
