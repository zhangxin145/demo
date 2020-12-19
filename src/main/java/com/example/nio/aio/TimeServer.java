package com.example.nio.aio;

import java.util.concurrent.Executors;

public class TimeServer {
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
