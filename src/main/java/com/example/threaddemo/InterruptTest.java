package com.example.threaddemo;

/**
 * @author xin.z
 * @date 2020/11/20 11:39 上午
 */
public class InterruptTest {


    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            while (true) {
                if (Thread.currentThread().isInterrupted()) {
                    System.out.println("中断");
                    break;
                }

                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {

                    System.out.println("interrupted when sleep");
                    //设置中断状态
                    Thread.currentThread().interrupt();
                }
                Thread.yield();
            }

        });


        t1.start();
        Thread.sleep(2000);

        t1.interrupt();


    }
}
