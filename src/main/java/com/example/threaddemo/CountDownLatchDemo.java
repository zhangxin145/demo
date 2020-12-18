package com.example.threaddemo;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * @author xin.z
 * @date 2020/11/20 5:46 下午
 */
public class CountDownLatchDemo {

    public static void main(String[] args) {

        new ThreadLocal<>();
        CountDownLatch end = new CountDownLatch(10);
        Thread test= new Thread(()->{
            try {
                Thread.sleep(10);
                end.countDown();
                System.out.println("check  end");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        });

        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();

        Executors.newFixedThreadPool(10);



        ConcurrentLinkedQueue queue = new ConcurrentLinkedQueue();

        AtomicInteger atomicInteger = new AtomicInteger();
        atomicInteger.incrementAndGet();
        AtomicReference<Integer> ref = new AtomicReference<>();

      //  AtomicStampedReference<Integer> integerAtomicStampedReference = new AtomicStampedReference<Integer>();


    }
}
