package com.example.demo;

import java.util.List;
import java.util.function.Predicate;

/**
 * @author xin.z
 * @date 2020/11/19 3:50 下午
 */
public class FunTest {


    public  static <T> void   funtest1(List<T> strings, Predicate<T> predicate){

        strings.forEach(a->{
            if(predicate.test(a)){
                System.out.println("====");
            }
        });
    }
}
