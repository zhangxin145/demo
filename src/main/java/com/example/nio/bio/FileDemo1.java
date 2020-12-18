package com.example.nio.bio;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author xin.z
 * @date 2020/12/18 4:12 下午
 */
public class FileDemo1 {
    public static void main(String[] args) throws Exception {
        String a= "sssss";
        ByteBuffer buffer = ByteBuffer.allocate(1024);
       /* FileOutputStream out = new FileOutputStream("/Users/admin/1.txt");
        FileChannel channel = out.getChannel();
        buffer.put(a.getBytes());
        buffer.flip();
        channel.write(buffer);*/


        FileInputStream fileInputStream = new FileInputStream("/Users/admin/1.txt");
        FileChannel channel1 = fileInputStream.getChannel();

        channel1.read(buffer);
        System.out.println(new String(buffer.array()));

    }
}
