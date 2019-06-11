package com.yc.netty.Dheartcheck;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.timeout.IdleStateHandler;

import java.util.concurrent.TimeUnit;

/**
 * @author LX
 * @date 2019/3/29 - 17:53
 */
public class MyServerInitializer extends ChannelInitializer<SocketChannel> {

    @Override
    protected void initChannel(SocketChannel ch) throws Exception {

        ChannelPipeline pipeline = ch.pipeline();

        pipeline.addLast( new IdleStateHandler(5,7,10, TimeUnit.SECONDS) );

        pipeline.addLast(new MyServerHandler());
    }
}
