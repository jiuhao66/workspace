package com.yc.netty.Cchatsocket;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.util.concurrent.GlobalEventExecutor;

/**
 * @author LX
 * @date 2019/3/29 - 9:39
 */
public class MyChatServerHandler extends SimpleChannelInboundHandler<String> {

    // 保存 连接好的  channel 对象
    private static ChannelGroup channelGroup = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {

        Channel channel = ctx.channel();

        channelGroup.forEach( channel1 -> {

            System.out.println(channel1.remoteAddress());

            if(channel !=channel1 ){

                channel1.writeAndFlush(channel.remoteAddress()+"发送的消息: "+msg+"\n");
            }else{

                channel.writeAndFlush("自己: "+msg);
            }
        });
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {

        cause.printStackTrace();

        ctx.close();
    }

    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {

        Channel channel = ctx.channel();

        channelGroup.writeAndFlush("服务器 - "+channel.remoteAddress()+" "+"加入\n");

        channelGroup.add(channel);
    }

    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {

        Channel channel = ctx.channel();

        channelGroup.writeAndFlush("服务器 - "+channel.remoteAddress()+" "+"下线\n");

        //断掉的 channel 会自动 remove掉  可以不主动调用
//        channelGroup.remove(channel);
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {

        System.out.println(ctx.channel().remoteAddress()+" 上线了");
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {

        System.out.println(ctx.channel().remoteAddress()+" 下线了");
    }
}
