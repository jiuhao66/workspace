package com.yc.netty.Beazysocket;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.util.UUID;

/**
 * 当客户端 和服务器 一连接  就会  创建这个方法
 *
 *
 *
 * @author LX
 * @date 2019/3/28 - 21:41
 */
public class MyServerHandler extends SimpleChannelInboundHandler<String> {

    /**
     * 只有 接受到 信息才会执行这个方法

     *
     * @param ctx
     * @param msg
     * @throws Exception
     */

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, String msg) {

        System.out.println(ctx.channel().remoteAddress()+"  "+msg);

        ctx.channel().writeAndFlush("from server"+ UUID.randomUUID().toString());

    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        super.channelInactive(ctx);
    }

    /**
     * 出现异常了   执行这个方法
     *
     * @param ctx
     * @param cause
     * @throws Exception
     */
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {

        cause.printStackTrace();

        ctx.close();
    }
}
