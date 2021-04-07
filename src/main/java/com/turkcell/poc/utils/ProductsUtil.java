package com.turkcell.poc.utils;

import java.util.Random;

public class ProductsUtil {
    private static final String[] USER_NAME_LIST = {"ad_1", "ad_2", "ad_3", "ad_4", "ad_5", "ad_6", "ad_7", "ad_8", "ad_9", "ad_10", "ad_11", "ad_12", "ad_13", "ad_14", "ad_15", "ad_16", "ad_17"};
    private static final String[] SECOND_USER_NAME_LIST= {"s_ad_1", "s_ad_2", "s_ad_3", "s_ad_4", "s_ad_5", "s_ad_6", "s_ad_7", "s_ad_8", "s_ad_9", "s_ad_10", "s_ad_11", "s_ad_12", "s_ad_13", "s_ad_14", "s_ad_15", "s_ad_16" };
    private static final Long DEFAULT_PHONE_NUMBER = 5330000000L;

    /**
     * USER_NAME_LIST ve SECOND_USER_NAME_LIST listeleri içerisnden verileri random alarak ad ve soyad'ı içeren string oluşturur.
     *
     * @return String
     */
    public static String generateRandomName(){
        Integer rndUsername = new Random().nextInt(USER_NAME_LIST.length);
        Integer rndSecondUsername = new Random().nextInt(SECOND_USER_NAME_LIST.length);

        return String.format("%s  %s", USER_NAME_LIST[rndUsername], SECOND_USER_NAME_LIST[rndSecondUsername]);
    }

    /**
     * DEFAULT_PHONE_NUMBER değişkenini count parametresi kadar arttırır.
     *
     * @param count
     * @return String
     */
    public static String generateGsmNumber(Integer count){
        return DEFAULT_PHONE_NUMBER+count+"";
    }

    /**
     * Random sayı oluşturup generateGsmNumber  methodunu çağırır.
     *
     * @return String
     */
    public static String generateRandomGsmNumber(){
        int min = 10000000;
        int max = 1000000;
        Integer rndPhone =  new Random().nextInt(max-min) + min;
        return generateGsmNumber(rndPhone);
    }

    /**
     * 4 karakterli random Kasa numrası oluşturur.
     *
     * @return Integer
     */
    public static Integer generateRandomKasaNo(){
        int min = 1000;
        int max = 9999;
        return new Random().nextInt(max-min) + min;
    }
}
