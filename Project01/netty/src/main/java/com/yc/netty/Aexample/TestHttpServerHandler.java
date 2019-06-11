package com.yc.netty.Aexample;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.*;
import io.netty.util.CharsetUtil;

import java.net.URI;

/**
 * @author LX
 * @date 2019/3/27 - 22:42
 */
public class TestHttpServerHandler extends SimpleChannelInboundHandler<HttpObject> {

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, HttpObject msg) throws Exception {

        if (msg instanceof HttpRequest){

            HttpRequest req = (HttpRequest) msg;

            URI uri = new URI(req.uri());

            if ("/favicon.ico".equals(uri.getPath())){
                System.out.println("请求  favicon.ico ");
                return;
            }

            ByteBuf content = Unpooled.copiedBuffer("hello word" , CharsetUtil.UTF_8);

            FullHttpResponse response = new DefaultFullHttpResponse(HttpVersion.HTTP_1_1,
                    HttpResponseStatus.OK,content);

            response.headers().set(HttpHeaderNames.CONTENT_TYPE, "text/plain");

            response.headers().set(HttpHeaderNames.CONTENT_LENGTH, content.readableBytes());

            ctx.writeAndFlush(response);

            ctx.channel().close();
        }

    }

    @Override
    public void channelRegistered(ChannelHandlerContext ctx) throws Exception {

        System.out.println("channelRegistered");

        super.channelRegistered(ctx);
    }

    @Override
    public void channelUnregistered(ChannelHandlerContext ctx) throws Exception {

        System.out.println("channelUnregistered");
        super.channelUnregistered(ctx);
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {

        System.out.println("channelActive");
        super.channelActive(ctx);
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {

        System.out.println("channelInactive");
        super.channelInactive(ctx);
    }
}
