package com.yc.netty.Beazysocket;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.time.LocalDateTime;

/**
 * @author LX
 * @date 2019/3/28 - 22:01
 */
public class MyClientHandler extends SimpleChannelInboundHandler<String> {
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {

        cause.printStackTrace();

        ctx.close();
    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {

        System.out.println("client output: "+msg);

        ctx.writeAndFlush("from client: "+ LocalDateTime.now());
    }

    /**
     *
     * @param ctx
     * @throws Exception
     */
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        ctx.channel().writeAndFlush("66600" );
    }
}
