package com.yc.netty.FprotoBuf_netty;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * @author LX
 * @date 2019/3/30 - 13:33
 */
public class TestServerHandler extends SimpleChannelInboundHandler<MyDataInfo.MyMessage>{


    @Override
    protected void channelRead0(ChannelHandlerContext ctx, MyDataInfo.MyMessage msg) throws Exception {

        /*System.out.println(msg);

        String name = msg.getDataType().name();

        System.out.println(name);*/

        MyDataInfo.MyMessage.DataType dataType = msg.getDataType();

        if(dataType == MyDataInfo.MyMessage.DataType.Person){

            MyDataInfo.Person person = msg.getPerson();
            System.out.println(person.getName());
            System.out.println(person.getAddress());
            System.out.println(person.getAge());

        }else if(dataType == MyDataInfo.MyMessage.DataType.Cat){

            MyDataInfo.Cat cat = msg.getCat();
            System.out.println(cat.getName());
            System.out.println(cat.getCity());
        }else{

            MyDataInfo.Dog dog = msg.getDog();
            System.out.println(dog.getName());
            System.out.println(dog.getAge());
        }
    }
}
