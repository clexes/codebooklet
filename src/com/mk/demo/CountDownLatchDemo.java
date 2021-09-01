package com.mk.demo;

import java.util.concurrent.CountDownLatch;

/*
* CountDownLatch的熟悉，类似于一种定时器，假设前面有4个任务，前面4个任务必须全部执行完成，才能执行最后的指令
* */
public class CountDownLatchDemo {
    public static void main(String[] args) throws InterruptedException {

        CountDownLatch latch = new CountDownLatch(4);
        for (int i = 1; i < 5; i++) {
            new Thread(()->{
                System.out.println(Thread.currentThread().getName()+" "+"离开教室");
                latch.countDown();
            },CountryNum.forEach_CountryNum(i).getName()).start();
        }
        latch.await();
        System.out.println(Thread.currentThread().getName()+" "+"班长最后离开教室，并锁门");




       /* CountDownLatch latch = new CountDownLatch(6);
        for (int i = 0; i < 6; i++) {
            new Thread(()->{
                System.out.println(Thread.currentThread().getName()+" "+"离开教室");
                latch.countDown();
            },String.valueOf(i)).start();
        }
        latch.await();
        System.out.println(Thread.currentThread().getName()+" "+"班长最后离开教室，并锁门");
*/

    }
}
