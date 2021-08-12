package com.mk.demo;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @Description: 类似缓存，写入值、读取值和清除缓存的值
 * @Author mckale
 * @Date 2021/8/12 21:21
 */
class MyCache{
    private volatile Map<String ,Object> map = new HashMap<>();
    //读写锁
    private ReentrantReadWriteLock rwLock = new ReentrantReadWriteLock();

    public void put(String key,Object value){
        rwLock.writeLock().lock();
        try {
            System.out.println(Thread.currentThread().getName()+" "+"写入："+key);
            try {
                TimeUnit.MILLISECONDS.sleep(300);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            map.put(key,value);
            System.out.println(Thread.currentThread().getName()+" "+"写入完成：");
        }catch (Exception e){
            e.printStackTrace();
        }finally {
           rwLock.writeLock().unlock();
        }
    }

    public void get(String key){
        rwLock.readLock().lock();
        try {
            System.out.println(Thread.currentThread().getName()+" "+"正在读取："+key);
            try {
                TimeUnit.MILLISECONDS.sleep(300);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            Object o = map.get(key);
            System.out.println(Thread.currentThread().getName()+" "+"读取完成："+o);
        }catch (Exception e){
            System.out.println(e);
        }finally {
            rwLock.readLock().unlock();
        }
    }

    public void clear(){
        map.clear();
    }
}
public class ReadWriteLockDemo {

    public static void main(String[] args) {
        MyCache myCache = new MyCache();

        for (int i = 0; i < 5; i++) {
            final int ter = i;
            new Thread(()->{
                myCache.put(ter+"",ter+"");
            },String.valueOf(i)).start();
        }

        for (int i = 0; i < 5; i++) {
            final int ter = i;
            new Thread(()->{
                myCache.get(ter+"");
            },String.valueOf(i)).start();
        }

    }
}
