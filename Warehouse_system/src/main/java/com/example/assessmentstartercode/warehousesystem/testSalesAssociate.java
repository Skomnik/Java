package com.example.assessmentstartercode.warehousesystem;

public class testSalesAssociate {
    public static void main(String[] args) throws InputValidationException {
        SalesAssociate sales = new SalesAssociate("Jack","sales","Mana","123");
        System.out.println(sales.getEmployeeName());
        SalesAssociate sales1 = new SalesAssociate("Ja","Sales","Mana","123");
        System.out.println(sales1.getEmployeeName());
        SalesAssociate sales2 = new SalesAssociate("Ji","Sales","Mana","123");
        System.out.println(sales2.getEmployeeName());
    }
}
