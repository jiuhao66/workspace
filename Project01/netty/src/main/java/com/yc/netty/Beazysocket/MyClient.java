package com.yc.netty.Beazysocket;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;

/**
 * @author LX
 * @date 2019/3/28 - 21:49
 */
public class MyClient {

    public static void main(String[] args)throws Exception{

        EventLoopGroup clientGroup = new NioEventLoopGroup();

        try {

            Bootstrap bootstrap = new Bootstrap();

            bootstrap.group(clientGroup).
                    channel(NioSocketChannel.class).handler(new MyClientInitializer());

            ChannelFuture channelFuture = bootstrap.connect("localhost", 8899).sync();

            channelFuture.channel().closeFuture().sync();

        }finally {

            clientGroup.shutdownGracefully();
        }
    }
}
