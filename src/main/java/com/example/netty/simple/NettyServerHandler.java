package com.example.netty.simple;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.ChannelPipeline;
import io.netty.util.CharsetUtil;

/**
 * @author xin.z
 * @date 2020/12/19 3:15 下午
 */
public class NettyServerHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println("服务器读取线程："+Thread.currentThread().getName());
        System.out.println("server ctx="+ctx);
        Channel channel = ctx.channel();
        ChannelPipeline pipeline = ctx.pipeline();


        ByteBuf buf = (ByteBuf)msg;
        System.out.println("客户端发送的内容是："+buf.toString(CharsetUtil.UTF_8));
        System.out.println("客户端ip是："+channel.remoteAddress());
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {

        ctx.writeAndFlush(Unpooled.copiedBuffer("服务端-->客户端  你好",CharsetUtil.UTF_8));

    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {

        ctx.close();
    }
}
