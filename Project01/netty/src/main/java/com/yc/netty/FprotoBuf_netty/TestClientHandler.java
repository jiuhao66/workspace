package com.yc.netty.FprotoBuf_netty;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.util.Random;

/**
 * @author LX
 * @date 2019/3/30 - 13:44
 */
public class TestClientHandler extends SimpleChannelInboundHandler<MyDataInfo.MyMessage> {

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, MyDataInfo.MyMessage msg) throws Exception {


    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {

        int randomInt = new Random().nextInt(3);

        MyDataInfo.MyMessage myMessage = null;

        if(randomInt==0){

             myMessage = MyDataInfo.MyMessage.newBuilder()
                    .setDataType(MyDataInfo.MyMessage.DataType.Person)
                    .setPerson(MyDataInfo.Person.newBuilder().setAge(20)
                            .setName("张三").setAddress("湖南衡阳").build()).build();

        }else if(randomInt==1){
            myMessage = MyDataInfo.MyMessage
                    .newBuilder().setDataType(MyDataInfo.MyMessage.DataType.Dog)
            .setDog(MyDataInfo.Dog.newBuilder().setAge(1).setName("小黄").build()).build();

        }else{
            myMessage = MyDataInfo.MyMessage
                    .newBuilder().setDataType(MyDataInfo.MyMessage.DataType.Cat)
                    .setCat(MyDataInfo.Cat.newBuilder().
                            setCity("农村小猫").setName("小黄").build()).build();
        }

        ctx.channel().writeAndFlush(myMessage);
    }
}
