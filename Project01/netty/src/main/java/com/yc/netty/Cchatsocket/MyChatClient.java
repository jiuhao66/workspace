package com.yc.netty.Cchatsocket;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author LX
 * @date 2019/3/29 - 10:08
 */
public class MyChatClient {

    public static void main(String[] args)  {

        EventLoopGroup clientGroup = new NioEventLoopGroup();

        try {

            Bootstrap bootstrap = new Bootstrap();

            bootstrap.group(clientGroup).
                    channel(NioSocketChannel.class).handler(new MyChatClientInitializer());

            Channel channel = bootstrap.connect("localhost", 8899).sync().channel();

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            for (; ; ){

                channel.writeAndFlush(br.readLine()+"\r\n");
            }
//            channelFuture.channel().closeFuture().sync();

        } catch (InterruptedException e) {

            e.printStackTrace();
        } catch (IOException e) {

            e.printStackTrace();
        } finally {

            clientGroup.shutdownGracefully();
        }
    }
}
