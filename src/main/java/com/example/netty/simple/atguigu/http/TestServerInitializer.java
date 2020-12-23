package com.example.netty.simple.atguigu.http;

import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpServerCodec;

public class TestServerInitializer extends ChannelInitializer<SocketChannel> {
    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        ChannelPipeline pipeline = ch.pipeline();
        Channel channel = pipeline.channel();
        pipeline.addLast("myHttpServerCodec",new HttpServerCodec());
        pipeline.addLast("myTestHttpServerHandler",new TestHttpServerHandler());


    }
}
