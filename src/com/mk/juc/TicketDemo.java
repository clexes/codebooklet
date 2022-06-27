package com.mk.juc;

class Ticket{

    int num = 50;

    public synchronized void sale(){
        if (num > 0){
            System.out.println(Thread.currentThread().getName()+"当前："+num+" 卖出后： "+--num);
        }
    }

}

//简单一个卖票 demo，三个人卖出 50 张票
public class TicketDemo {

    public static void main(String[] args) {

        Ticket ticket = new Ticket();

        /*new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 51; i++) {
                    ticket.sale();
                }
            }
        },"a").start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 51; i++) {
                    ticket.sale();
                }
            }
        },"b").start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 51; i++) {
                    ticket.sale();
                }
            }
        },"c").start();*/

        //lambda表达式写法
        //       将new Runnable() {
        //            @Override
        //            public void run() {
        //                for (int i = 0; i < 51; i++) {
        //                    ticket.sale();
        //                }
        //            }
        //        }
        //        简写为()->{}
        new Thread(()->{
            for (int i = 0; i < 51; i++) {
                ticket.sale();
            }
        },"a").start();
        new Thread(()->{
            for (int i = 0; i < 51; i++) {
                ticket.sale();
            }
        },"b").start();
        new Thread(()->{
            for (int i = 0; i < 51; i++) {
                ticket.sale();
            }
        },"c").start();
    }

}
