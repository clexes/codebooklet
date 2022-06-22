package com.mk.juc;

import java.util.Arrays;
import java.util.List;

public class TestString {

    public static void main(String[] args) {

        String me = "222";
        StringBuilder builder = new StringBuilder();

        String[] strings = new String[]{"avc","sdf"};
        List<String> list = Arrays.asList(strings);
//        list.add("2123");
        strings[0] = "222";
        for (String s : list) {
            System.out.println(s);
        }

        int[] myArray = { 1, 2, 3 };
        List myList = Arrays.asList(myArray);
        System.out.println(myList.size());//1
        System.out.println(myList.get(0));//数组地址值
        System.out.println(myList.get(1));//报错：ArrayIndexOutOfBoundsException
        int [] array=(int[]) myList.get(0);
        System.out.println(array[0]);//1


    }

}
