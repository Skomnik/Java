package com.example.assessmentstartercode.warehousesystem;

import java.util.Date;

public class testBuffer {
    public static void main(String[] args) throws InputValidationException {
        Buffer buffer1 = new Buffer(4);
        buffer1.add(new Item("123", "Qwe", 3, 5, 5, 4), 1);
        System.out.println(buffer1);
        buffer1.add(new Item("124", "Asd", 4, 5, 5, 4), 2);
        buffer1.add(new Item("125", "Zxc", 5, 5, 5, 4), 2);
        buffer1.add(new Item("126", "Qaz", 6, 5, 5, 4), 2);
        buffer1.add(new Item("127", "Wer", 7, 5, 5, 4), 2);
        System.out.println(buffer1);

        Buffer buffer2 = new Buffer(5000000);
        long start = (new Date()).getTime();
        for (int i = 0; i < 100000; i++) {
            buffer2.add(new Item("128" + i, "Name" + i, 5, 5, 5, 3), 1);
        }
        double end = (double) ((new Date()).getTime() - start) / 1000.0;
        System.out.println("Time taken to add: " + end + " secs");
        start = (new Date()).getTime();
        for (int i = 0; i < 1000000; i++) {
            buffer2.getItemsMap();

        }

        end = (double) ((new Date()).getTime() - start) / 1000.0;
        System.out.println("Time taken to get: " + end + " secs");

        buffer2.show();

    }
}
