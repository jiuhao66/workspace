package com.yc.netty.nio;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author LX
 * @date 2019/4/24 - 21:14
 */
public class NeiCunYinSheFile {

    public static void main(String[] args) throws IOException {

        RandomAccessFile accessFile = new RandomAccessFile("accessFile.txt","rw");

        FileChannel channel = accessFile.getChannel();

        MappedByteBuffer mappedByteBuffer = channel.map(FileChannel.MapMode.READ_WRITE, 0, 6);

        mappedByteBuffer.put(0,(byte)'a');
        mappedByteBuffer.put(4, (byte) 'c');

        accessFile.close();
    }
}
