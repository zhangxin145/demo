package com.example.threaddemo;

/**
 * @author xin.z
 * @date 2020/11/28 4:26 下午
 */
public class DemoTest {
    public static void main(String[] args) {
        for (int i=0;i<5;++i){}
        new Thread(()->{
            try {
                Thread.sleep(500000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
