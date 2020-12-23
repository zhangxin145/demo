package com.example.netty.simple.atguigu.http;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.*;
import io.netty.util.CharsetUtil;

import java.net.URI;


public class TestHttpServerHandler extends SimpleChannelInboundHandler<HttpObject> {
    //当有读取事件时触发
    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, HttpObject msg) throws Exception {

        if(msg instanceof HttpRequest){
            //channelHandlerContext.channel().eventLoop().execute();
            System.out.println("msg 类型"+msg.getClass());
            HttpRequest httpRequest = (HttpRequest) msg; //获取 uri, 过滤指定的资源
            URI uri = new URI(httpRequest.uri()); if("/favicon.ico".equals(uri.getPath())) {
                System.out.println("请求了 favicon.ico, 不做响应");
                return; }
//回复信息给浏览器 [http 协议]
            ByteBuf content = Unpooled.copiedBuffer("hello, 我是服务器", CharsetUtil.UTF_8);
//构造一个 http 的相应，即 httpresponse
            FullHttpResponse response = new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.OK, content);
            response.headers().set(HttpHeaderNames.CONTENT_TYPE, "text/plain"); response.headers().set(HttpHeaderNames.CONTENT_LENGTH, content.readableBytes());
            channelHandlerContext.writeAndFlush(response);

        }


    }
}
