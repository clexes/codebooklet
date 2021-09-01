package com.mk.demo;

import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierDemo {

    public static void main(String[] args) {


        CyclicBarrier barrier = new CyclicBarrier(7,()->{
            System.out.println("召唤神龙");
        });
        for (int i = 1; i <= 7; i++) {

            final int  te = i;
            new Thread(()->{
                System.out.println(Thread.currentThread().getName()+" "+"shouji"+te+"龙珠");
                try {
                    barrier.await();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }).start();
        }

    }
}
