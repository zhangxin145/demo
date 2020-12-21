package com.example.netty.simple.qwzn;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.util.logging.Logger;

/**
 * @author xin.z
 * @date 2020/12/19 5:04 下午
 */
public class TimeClientHandler extends ChannelInboundHandlerAdapter {
    private static final Logger logger= Logger.getLogger(TimeClientHandler.class.getName());
    private int counter;
    private byte[] req;

    public TimeClientHandler(){
        req=("QUERY TIME ORDER" + System.getProperty("line.separator")).getBytes();
    }
    /**
     * 当客户端和服务器TCP链路建立成功后，NIO线程会调用channelActive方法
     */
    @Override
    public void channelActive(ChannelHandlerContext ctx){
        //发送查询时间的指令给服务端
        ByteBuf message=null;
        //循环发送100条消息，每发送一条就刷新一次
        for(int i=0;i<100;i++){
            message=Unpooled.buffer(req.length);
            message.writeBytes(req);
            ctx.writeAndFlush(message);
        }
    }
    /**
     * 当服务端返回应答消息时调用
     */
    @Override
    public void channelRead(ChannelHandlerContext ctx,Object msg)throws Exception{
        ByteBuf buf=(ByteBuf)msg;
        byte[] req=new byte[buf.readableBytes()];
        buf.readBytes(req);
        String body=new String(req,"UTF-8");
        System.out.println("Now is : " + body + " ; the counter is : " + ++counter);
    }
    /**
     * 当发生异常时
     */
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx,Throwable cause){
        logger.warning("Unexpected exception from downstrea : " + cause.getMessage());
        ctx.close();
    }
}
