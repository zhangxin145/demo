package com.example.netty.simple.qwzn;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * @author xin.z
 * @date 2020/12/19 5:04 下午
 */
public class TimeClientHandler extends ChannelInboundHandlerAdapter {
    //private final ByteBuf firstMessage;

    private int counter;

    private byte[] req;

    public TimeClientHandler() {
        req = ("TIME" + System.getProperty("line.separator")).getBytes();

      /*  byte[] req = "TIME".getBytes();
        firstMessage = Unpooled.buffer(req.length);
        firstMessage.writeBytes(req);*/
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        ByteBuf msg = null;
        for (int i = 0; i < 100; i++) {
            Unpooled.buffer(req.length);
            msg.writeBytes(req);
            ctx.writeAndFlush(msg);

        }

    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ByteBuf buf = (ByteBuf) msg;
        byte[] req = new byte[buf.readableBytes()];
        buf.readBytes(req);
        String body = new String(req, "UTF-8");
        System.out.println("now is :" + body + "==counter= " + ++counter);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        ctx.close();
    }
}
