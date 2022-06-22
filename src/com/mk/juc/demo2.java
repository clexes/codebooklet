package com.mk.juc;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class demo2 {

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        List<Integer> list = new ArrayList<>();

        list.add(12);
//1.编译期间直接添加会报错
//        list.add("a");
        Class<? extends List> clazz = list.getClass();
        Method add = clazz.getDeclaredMethod("add", Object.class);
//2.运行期间通过反射添加，是可以的
        add.invoke(list, "kl");

        System.out.println(list);
    }

    class Node<T> {

        public T data;

        public Node(T data) { this.data = data; }

        public void setData(T data) {
            System.out.println("Node.setData");
            this.data = data;
        }
    }


    class MyNode extends Node<Integer> {
        public MyNode(Integer data) { super(data); }

        //Node<T> 泛型擦除后为 setData(Object data)，而子类 MyNode 中并没有重写该方法，所以编译器会加入该桥方法保证多态
        /*public void setData(Object data) {
            setData((Integer) data);
        }*/

        public void setData(Integer data) {
            System.out.println("MyNode.setData");
            super.setData(data);
        }
    }



}
