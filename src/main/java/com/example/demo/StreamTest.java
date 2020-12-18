package com.example.demo;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author xin.z
 * @date 2020/11/19 3:56 下午
 */
public class StreamTest {
    public static void main(String[] args) {


        Map<Integer, List<Integer>> map = Stream.of(1, 3, 3, 2).collect(Collectors.groupingBy(Function.identity()));
        System.out.println(map);
        Map<Integer, Integer> map1 = Stream.of(1, 3, 3, 2).collect(Collectors.groupingBy(Function.identity(), HashMap::new, Collectors.summingInt(x -> x)));
        System.out.println(map1);
        HashMap<Integer, List<Integer>> hashMap = Stream.of(1, 3, 3, 2).collect(Collectors.groupingBy(Function.identity(), HashMap::new, Collectors.mapping(x -> x + 1, Collectors.toList())));
        System.out.println(hashMap);


        List<Integer> collect = Stream.of(1, 3, 3, 2).sorted(Integer::compareTo).collect(Collectors.toList());


        new Thread(() -> System.out.println("===")).start();

        // Predicate返回了一个boolean
        ArrayList<Object> list = new ArrayList<>();


        Predicate<String> p = s -> list.add(s);
// Consumer返回了一个void

        new Thread(()->{
            System.out.println("");
        });



        List<String> strings = Arrays.asList("dss","aa", "ccac", "babb","acddff");
        Optional<String> reduce = strings.stream().reduce((a, b) -> a + b);

        Integer a1= 3;
        IntStream.rangeClosed(1, 100)
                .filter(b -> Math.sqrt(a1*a1 + b*b) % 1 == 0)
                .boxed()
                .map(b -> new int[]{a1, b, (int) Math.sqrt(a1 * a1 + b * b)});


        Stream<int[]> pythagoreanTriples =
                IntStream.rangeClosed(1, 100).boxed()
                        .flatMap(a ->
                                IntStream.rangeClosed(a, 100)
                                        .filter(b -> Math.sqrt(a*a + b*b) % 1 == 0)
                                        .mapToObj(b ->
                                                new int[]{a, b, (int)Math.sqrt(a * a + b * b)})
                        );
    }
}
