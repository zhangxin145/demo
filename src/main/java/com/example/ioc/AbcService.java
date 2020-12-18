package com.example.ioc;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author xin.z
 * @date 2020/11/10 12:05 下午
 */
public class AbcService {

    public Map<Integer, String> listToMapWithDupKey(List<String> users) {
        return users.stream().collect(Collectors.toMap(String::length, Function.identity(),
                (existing, replacement) -> existing));
    }
}
