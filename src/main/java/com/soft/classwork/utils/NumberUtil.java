package com.soft.classwork.utils;

        import java.util.Random;

/**
 * Created by Yuukiiii
 * on 2018/4/6 17:08
 */


public class NumberUtil {
    public static int[] getRandomIntegerArray(Integer big,Integer size){
        int[] array = new int[big];
        for (int i = 0; i < big; i++) {
            array[i] = i;
        }
        int[] array2 = new int[size];
        int arrange = big;
        for (int i =0;i<size;i++) {
            int max=arrange;
            int min=0;
            Random random = new Random();

            int s = random.nextInt(max)%(max-min+1) + min;
            System.out.println(s);
            array2[i] = array[s];
            int mid = array[array.length - i - 1];
            array[array.length - i - 1] = array[s];
            array[s] = mid;
            arrange--;
        }

        return array2;
    }
}
