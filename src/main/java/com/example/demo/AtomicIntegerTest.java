package com.example.demo;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author xin.z
 * @date 2020/11/27 8:05 下午
 */
public class AtomicIntegerTest {
    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger(10001);

        for (int i = 0;i<1000;++i){
            new Thread(()->{});

        }
    }
}
