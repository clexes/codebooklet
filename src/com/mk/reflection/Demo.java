package com.mk.reflection;

import java.lang.reflect.Field;
import java.lang.reflect.Method;


// 反射了解
public class Demo {

    public static void main(String[] args) throws ClassNotFoundException {

        Class ap = Class.forName("com.mk.reflection.Demo");
        Field[] fields = ap.getDeclaredFields();
        for (Field field : fields) {
            System.out.println(field.getName()+field.getType());
        }

        Method[] methods = ap.getMethods();
        for (Method method : methods) {
            System.out.println(method.getName());
        }


    }

}
