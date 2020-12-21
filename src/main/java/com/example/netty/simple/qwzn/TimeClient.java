package com.example.netty.simple.qwzn;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.LineBasedFrameDecoder;
import io.netty.handler.codec.string.StringDecoder;

/**
 * @author xin.z
 * @date 2020/12/19 4:57 下午
 */
public class TimeClient {
    public void connect(int port, String host) throws Exception {
        EventLoopGroup group = new NioEventLoopGroup();
        try {
            Bootstrap b = new Bootstrap();
            //Channel需要设置为NioSocketChannel，然后为其添加Handler
            b.group(group).channel(NioSocketChannel.class)
                    .option(ChannelOption.TCP_NODELAY, true)
                    .handler(new ChannelInitializer<SocketChannel>() {
                        //为了简单直接创建匿名内部类，实现initChannel方法
                        //其作用是当创建NioSocketChannel成功之后，在进行初始化时，
                        //将它的ChannelHandler设置到ChannelPipeline中，用于处理网络I/O事件
                        @Override
                        public void initChannel(SocketChannel ch) throws Exception {
                            ch.pipeline()
                                    .addLast(new LineBasedFrameDecoder(1024))
                                    .addLast(new StringDecoder())
                                    .addLast(new TimeClientHandler());
                        }
                    });
            //发起异步连接，然后调用同步方法等待连接成功
            ChannelFuture f = b.connect(host, port).sync();
            //当客户端连接关闭之后，客户端主函数退出，退出前释放NIO线程组的资源
            f.channel().closeFuture().sync();
        } finally {

        }
    }

    public static void main(String[] args) throws Exception {
        int port = 8080;
        new TimeClient().connect(port, "127.0.0.1");
    }
}
