package com.example.threaddemo;

import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * @author xin.z
 * @date 2020/11/21 4:04 下午
 */
public class AtomicStampedReferenceDemo {

    static AtomicStampedReference<Integer> money = new AtomicStampedReference<Integer>(19, 0);

    public static void main(String[] args) {

        for (int i = 0; i < 3; i++) {
            int stamp = money.getStamp();
            new Thread(() -> {
                while (true) {
                    while (true){

                    }


                }

            }).start();
        }


    }

}
