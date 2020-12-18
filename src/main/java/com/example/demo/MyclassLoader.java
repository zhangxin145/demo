package com.example.demo;

import sun.jvm.hotspot.ui.action.FindClassesAction;

/**
 * @author xin.z
 * @date 2020/10/23 8:56 下午
 */
public class MyclassLoader extends ClassLoader {

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        MyclassLoader.getSystemClassLoader();
        Thread.currentThread().getContextClassLoader();
        return super.findClass(name);
    }
}
