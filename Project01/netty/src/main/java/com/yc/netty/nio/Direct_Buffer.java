package com.yc.netty.nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author LX
 * @date 2019/4/24 - 20:38
 */
public class Direct_Buffer {

    public static void main(String[] args) throws IOException {

        FileInputStream in = new FileInputStream("input.txt");

        FileOutputStream out = new FileOutputStream("output1.txt");

        FileChannel inChannel = in.getChannel();

        FileChannel outChannel = out.getChannel();

        // 零拷贝        直接调用堆外内存
        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(512);

        while (true){
            int read = inChannel.read(byteBuffer);

            if(read == -1){

                break;
            }
            byteBuffer.flip();

            outChannel.write(byteBuffer);

            byteBuffer.clear();
        }

        in.close();
        out.close();
    }
}
