package com.mk.jvm;

public class Demo3 {

    // 一个有意思的Java编译器问题
    public static void main(String[] args) {
        String a = "hello";
        // \u000d a = "word";
        System.out.println(a);
        // \u000d a = "hello word";
        System.out.println(a);

    }

}
