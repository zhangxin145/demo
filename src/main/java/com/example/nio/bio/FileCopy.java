package com.example.nio.bio;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;


/**
 * @author xin.z
 * @date 2020/12/18 4:40 下午
 */
public class FileCopy {
    public static void main(String[] args) throws IOException {

        FileInputStream in = new FileInputStream("/Users/admin/1.txt");
        FileOutputStream out = new FileOutputStream("/Users/admin/11213.txt");

        FileChannel channel = in.getChannel();
        FileChannel channel1 = out.getChannel();
        channel1.transferFrom(channel,0,channel.size());
        channel.close();
        channel1.close();
        in.close();
        out.close();

    }
}
