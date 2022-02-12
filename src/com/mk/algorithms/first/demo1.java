package com.mk.algorithms.first;

import java.util.Arrays;

public class demo1 {
    public static void main(String[] args) {
        //冒泡排序
        int[] num = {1,19,5,18,29};
        for (int i = 1; i < num.length; i++) {
            for (int j = 0; j < num.length-i; j++) {
                if (num[j]>num[j+1]){
                    int temp = num[j];
                    num[j] = num[j+1];
                    num[j+1] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(num));
    }
}
