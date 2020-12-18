package com.example.threaddemo;

import sun.applet.Main;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author xin.z
 * @date 2020/11/21 11:50 上午
 */
public class TraceThreadPoolExecutor extends ThreadPoolExecutor {
    public TraceThreadPoolExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
    }

    public static void main(String[] args) {
        TraceThreadPoolExecutor threadPoolExecutor = new TraceThreadPoolExecutor(0, Integer.MAX_VALUE, 0L, TimeUnit.SECONDS,
                new SynchronousQueue<Runnable>());

        for (int i =0;i<5;i++){
            int finalI = i;
            threadPoolExecutor.execute(()->{
                int i1 = 100 / finalI;
                System.out.println(i1);
            });
        }
    }

    public void execute(Runnable task){
        super.execute(wrap(task,clientTrace(), Thread.currentThread().getName()));
    }

    private Runnable wrap(Runnable task, Exception clientTrace, String name) {
        return ()->{
            try {
                task.run();
            }catch (Exception e){
                clientTrace.printStackTrace();
                throw e;
            }

        };
    }

    private Exception clientTrace(){
        return new Exception("client stack trace");
    }


}
