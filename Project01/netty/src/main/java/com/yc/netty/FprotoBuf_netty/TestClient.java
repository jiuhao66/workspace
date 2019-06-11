package com.yc.netty.FprotoBuf_netty;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;

/**
 * @author LX
 * @date 2019/3/30 - 13:40
 */
public class TestClient {

    public static void main(String[] args) {

        EventLoopGroup clientGroup = new NioEventLoopGroup();

        try {

            Bootstrap bootstrap = new Bootstrap();

            bootstrap.group(clientGroup).
                    channel(NioSocketChannel.class).handler(new TestClientInitializer());

            ChannelFuture channelFuture = bootstrap.connect("localhost", 8899).sync();

            channelFuture.channel().closeFuture().sync();

        } catch (InterruptedException e) {

            e.printStackTrace();
        } finally {

            clientGroup.shutdownGracefully();
        }
    }
}
