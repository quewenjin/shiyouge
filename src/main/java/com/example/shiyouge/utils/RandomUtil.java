package com.example.shiyouge.utils;

import java.util.Random;

public class RandomUtil {
    /**
     * 随机得到九位长度的数字ID
     * @return string
     */
    public static String getTheRandomUID(){
        Random random = new Random();
        int theRandom = random.nextInt(900000000) + 100000000;
        String theUID = String.valueOf(theRandom);
        System.out.println(theUID);
        return theUID;
    }

    /**
     * 0到3 随机
     * @return int
     */
    public static int randomZeroToThree(){
        Random random = new Random();
        int theRandom = random.nextInt(4);
        System.out.println(theRandom);
        return theRandom;
    }
}
