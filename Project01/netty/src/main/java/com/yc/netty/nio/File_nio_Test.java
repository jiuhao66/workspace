package com.yc.netty.nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author LX
 * @date 2019/4/23 - 21:23
 */
public class File_nio_Test {

    public static void main(String[] args) throws IOException {

        FileInputStream in = new FileInputStream("input.txt");

        FileOutputStream out = new FileOutputStream("output.txt");

        FileChannel inChannel = in.getChannel();

        FileChannel outChannel = out.getChannel();

        ByteBuffer byteBuffer = ByteBuffer.allocate(512);

        while (true){

            byteBuffer.clear();

            int read = inChannel.read(byteBuffer);

            if(read == -1){

                break;
            }
            byteBuffer.flip();

            outChannel.write(byteBuffer);
        }

        inChannel.close();
        outChannel.close();
    }
}
