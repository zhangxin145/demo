package com.example.demo;

import java.math.BigDecimal;
import java.sql.Time;
import java.time.*;
import java.time.temporal.TemporalAdjusters;
import java.util.*;
import java.util.concurrent.locks.Condition;
import java.util.stream.Collectors;

/**
 * @author xin.z
 * @date 2020/8/28 11:09 上午
 */
public class

Test {

    public static void main(String[] args) {
        List<Demo> list = initDemoList();
        // 级别分组
        List responseList = list.stream().collect(Collectors.groupingBy(Demo::getLevel)).entrySet().stream()
                // 级别排序
                .sorted(Map.Entry.comparingByKey()).map(integerListEntry -> {
                    // 新数组接收
                    List newList = new ArrayList();
                    newList.add(integerListEntry.getKey());
                    // 档位排序
                    newList.addAll(integerListEntry.getValue().stream().sorted((o1, o2) -> o1.getGrade() - o2.getGrade())
                            // 收集薪资
                            .map(Demo::getSalary).collect(Collectors.toList()));
                    return newList;
                }).collect(Collectors.toList());
        System.out.println(responseList);
    }

    public static List<Demo> initDemoList() {
        List<Demo> list = new ArrayList<>();
        Demo demo1 = new Demo(1, 1, 3, 1003D, "1");
        Demo demo2 = new Demo(2, 1, 1, 1001D, "1");
        Demo demo3 = new Demo(3, 1, 2, 1002D, "1");

        Demo demo4 = new Demo(21, 2, 2, 1002D, "1");
        Demo demo5 = new Demo(22, 2, 1, 1001D, "1");
        Demo demo6 = new Demo(23, 2, 3, 1003D, "1");
        list.add(demo1);
        list.add(demo2);
        list.add(demo3);
        list.add(demo4);
        list.add(demo5);
        list.add(demo6);
        return list;
    }


    static class Demo {
        public Demo(Integer id, Integer level, Integer grade, Double salary, String salaryType) {
            this.id = id;
            this.level = level;
            this.grade = grade;
            this.salary = salary;
            this.salaryType = salaryType;
        }

        /**
         * 级别或者薪级
         */
        private Integer id;

        /**
         * 级别或者薪级
         */
        private Integer level;

        /**
         * 档次
         */
        private Integer grade;

        /**
         * 级别薪级工资标准
         */
        private Double salary;

        /**
         * 类别
         */
        private String salaryType;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public Integer getLevel() {
            return level;
        }

        public void setLevel(Integer level) {
            this.level = level;
        }

        public Integer getGrade() {
            return grade;
        }

        public void setGrade(Integer grade) {
            this.grade = grade;
        }

        public Double getSalary() {
            return salary;
        }

        public void setSalary(Double salary) {
            this.salary = salary;
        }

        public String getSalaryType() {
            return salaryType;
        }

        public void setSalaryType(String salaryType) {
            this.salaryType = salaryType;
        }
    }


    private  void getFirstWeekTime(ArrayList<Integer> list) {

        System.out.println( System.identityHashCode(list));
        list.add(32323);
    }


}
