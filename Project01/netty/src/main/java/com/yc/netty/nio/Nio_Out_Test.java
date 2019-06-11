package com.yc.netty.nio;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author LX
 * @date 2019/4/21 - 20:39
 */
public class Nio_Out_Test {

    public static void main(String[] args) throws IOException {

        FileOutputStream out  = new FileOutputStream("NioTest2.txt");

        FileChannel channel = out.getChannel();

        ByteBuffer byteBuffer = ByteBuffer.allocate(512);

        byte [] message = "hello nio".getBytes();

        for (byte t :message){

            byteBuffer.put(t);
        }
        byteBuffer.flip();

        channel.write(byteBuffer);

        out.flush();
        out.close();
    }
}
