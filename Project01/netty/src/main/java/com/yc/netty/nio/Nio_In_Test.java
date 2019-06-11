package com.yc.netty.nio;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author LX
 * @date 2019/4/21 - 20:19
 */
public class Nio_In_Test {

    public static void main(String[] args) throws IOException {

        FileInputStream in = new FileInputStream("NioTest2.txt");

        FileChannel fileChannel = in.getChannel();

        ByteBuffer byteBuffer = ByteBuffer.allocate(512);

        //把文件里面的信息 写入buffer里面
        fileChannel.read(byteBuffer);

        byteBuffer.flip();

        while (byteBuffer.hasRemaining()){
            System.out.println((char)byteBuffer.get());
        }
        fileChannel.close();

        in.close();
    }
}
