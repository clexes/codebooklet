package com.mk.reflection;

public class Demo3 {

    // 一个有意思的Java编译器，\u000d 为换行符，编译器在识别时直接进行换行
    public static void main(String[] args) {
        String a = "hello";
        // \u000d a = "word";
        System.out.println(a);
        // \u000d a = "hello word";
        System.out.println(a);

    }

}
