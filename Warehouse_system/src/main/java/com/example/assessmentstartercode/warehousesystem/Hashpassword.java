package com.example.assessmentstartercode.warehousesystem;

public class Hashpassword {   // module for hashing password
    public String hash(String plainText) { // permutation of symbols taken from the college's practical work
        int sides = 3;
        String cipherText = new String();

        for (int i = 0; i < sides; i++) {
            for (int j = i; j < plainText.length(); j = j + sides) {
                cipherText = cipherText + plainText.charAt(j);
            }
        }

        return cipherText;
    }
}
