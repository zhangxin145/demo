package com.example.nio.bio;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author xin.z
 * @date 2020/12/18 3:00 下午
 */
public class TimeServer {
    public static void main(String[] args) throws IOException {
        int port = 8080;
        if (args != null && args.length > 0) {
            try {
                port = Integer.valueOf(args[0]);
            } catch (Exception e) {

            }
        }
        ServerSocket server = null;
        try {
            server = new ServerSocket(port);
            System.out.println("serversocket port :"+port);
            Socket socket = null;

            while (true){
                socket = server.accept();
                new Thread(new TimeServerHandler(socket)).start();

            }
        } finally {
            if(server !=null){
                System.out.println("server close");
                server.close();
                server = null;

            }
        }
        }
}
