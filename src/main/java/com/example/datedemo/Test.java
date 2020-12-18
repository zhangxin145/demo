package com.example.datedemo;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author xin.z
 * @date 2020/11/24 11:21 上午
 */
public class Test {
    public static void main(String[] args) {
        LocalDate ld = LocalDate.parse("2020-10-02");

        long l = Instant.now().toEpochMilli();
        //LocalDateTime parse = LocalDateTime.parse("2020-10-02 12:34:45", DateTimeFormatter.ofPattern());

    }
}
