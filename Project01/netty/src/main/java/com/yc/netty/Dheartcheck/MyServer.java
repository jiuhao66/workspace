package com.yc.netty.Dheartcheck;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;

/**
 * @author LX
 * @date 2019/3/29 - 17:50
 */
public class MyServer {

    public static void main(String[] args) {

        EventLoopGroup bossGroup = new NioEventLoopGroup();

        EventLoopGroup workerGroup = new NioEventLoopGroup();

        try {
            ServerBootstrap bootstrap = new ServerBootstrap();

            bootstrap.group(bossGroup, workerGroup).
                    channel(NioServerSocketChannel.class).handler(new LoggingHandler(LogLevel.INFO))
                    .childHandler(new MyServerInitializer());

            //            sync  加了 代表 會在一直等待
            ChannelFuture channelFuture = bootstrap.bind(8899).sync();

            channelFuture.channel().closeFuture().sync();
        } catch (InterruptedException e) {

            e.printStackTrace();
        } finally {

            bossGroup.shutdownGracefully();

            workerGroup.shutdownGracefully();
        }
    }
}
