package com.example.threaddemo;

import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author xin.z
 * @date 2020/11/21 11:35 上午
 */
public class ExecutorsTest {
    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 0L, TimeUnit.SECONDS,
                new SynchronousQueue<Runnable>());

        for (int i =0;i<5;i++){
            int finalI = i;
            threadPoolExecutor.execute(()->{
                int i1 = 100 / finalI;
                System.out.println(i1);
            });
        }
    }
}
