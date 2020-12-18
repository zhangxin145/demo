package com.example.classLoader;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.stream.Collectors;

/**
 * @author xin.z
 * @date 2020/10/23 9:28 下午
 */
public class StringTest {

    public static void main(String[] args) {
        String s1 = new String("a") + new String("b");
        s1.intern();
        String s22 = "ab";
        System.out.println(s1 == s22);

        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
        ReentrantReadWriteLock.ReadLock readLock = reentrantReadWriteLock.readLock();
        ReentrantReadWriteLock.WriteLock writeLock = reentrantReadWriteLock.writeLock();

        Map<Object, Object> map = Collections.synchronizedMap(new HashMap<>());


    }
}
