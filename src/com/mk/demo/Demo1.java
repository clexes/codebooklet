package com.mk.demo;

public class Demo1 {

    public static void main(String[] args) {
        int a = 10;
        int b = 20;
        test(a,b);
        System.out.println("a "+a+"b "+b);
    }


    public static void test(int a, int b){
        int temp = a;
        a = b;
        b = temp;
        System.out.println("a "+a+"b "+b);
    }

}
