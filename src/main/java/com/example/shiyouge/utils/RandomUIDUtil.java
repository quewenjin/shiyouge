package com.example.shiyouge.utils;

import java.util.Random;

public class RandomUIDUtil {

    public static String getTheRandomUID(){
        Random random = new Random();
        int theRandom = random.nextInt(900000000) + 100000000;
        String theUID = String.valueOf(theRandom);
        System.out.println(theUID);
        return theUID;
    }

}
