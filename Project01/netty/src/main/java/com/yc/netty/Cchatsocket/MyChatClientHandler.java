package com.yc.netty.Cchatsocket;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * @author LX
 * @date 2019/3/29 - 10:28
 */
public class MyChatClientHandler extends SimpleChannelInboundHandler<String> {


    @Override
    protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {

        System.out.println(msg);
    }

    public MyChatClientHandler() {
        System.out.println(6666);
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {

        Channel channel = ctx.channel();
    }
}
