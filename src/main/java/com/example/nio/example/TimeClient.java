package com.example.nio.example;

/**
 * @author xin.z
 * @date 2020/12/18 5:42 下午
 */
public class TimeClient {
    public static void main(String[] args) {

        int port = 8080;
        if (args != null && args.length > 0) {
            try {
                port = Integer.valueOf(args[0]);
            } catch (Exception e) {

            }
        }

    }
}
