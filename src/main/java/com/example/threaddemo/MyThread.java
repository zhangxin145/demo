package com.example.threaddemo;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;

import java.awt.print.PrinterAbortException;

/**
 * @author xin.z
 * @date 2020/11/28 4:47 下午
 */
public class MyThread extends Thread {
    private int count = 5;

    public MyThread(String name) {
        super();
        this.setName(name);

    }

    public MyThread() {

    }

    public synchronized void run() {
        super.run();
        // while (count > 0) {
        count--;
        System.out.println(currentThread().getName() + "==>:" + count);

        // }
    }

    public static void main(String[] args) {
        // 每个线程有一份
        MyThread a = new MyThread("a");
        MyThread b = new MyThread("b");
        MyThread c = new MyThread("c");
        MyThread d = new MyThread("d");
        a.start();
        b.start();
        c.start();
        d.start();


        // 线程共用一份
     /*   MyThread myThread = new MyThread();

        Thread a = new Thread(myThread, "a");
        Thread b = new Thread(myThread, "b");
        Thread c = new Thread(myThread, "c");
        Thread d = new Thread(myThread, "d");
        a.start();
        b.start();
        c.start();
        d.start();
*/
       /* new Thread(()->{
            MyThread.doPost("a","aa");

        }).start();

        new Thread(()->{
            MyThread.doPost("b","bb");

        }).start();*/

    }

    private static String userNameRef;
    private static String passRef;

    public static  void doPost(String userName,String pass){
        userNameRef = userName;
                if(userName.equals("a")){
                    try {
                        Thread.sleep(5000);
                        passRef =pass;
                        System.out.println(userNameRef+":"+pass);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }


    }


}
