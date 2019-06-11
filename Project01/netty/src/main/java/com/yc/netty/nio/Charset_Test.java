package com.yc.netty.nio;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;

/**
 * @author LX
 * @date 2019/4/28 - 20:07
 */
public class Charset_Test {

    public static void main(String[] args) throws IOException {

        String inputFile = "charset_in.txt";

        String outputFile = "charset_out.txt";

        FileInputStream in = new FileInputStream("charset_in.txt");

        FileOutputStream out = new FileOutputStream("charset_out.txt");

        FileChannel inChannel = in.getChannel();

        FileChannel outChannel = out.getChannel();

        ByteBuffer byteBuffer = ByteBuffer.allocate(128);

        int read = inChannel.read(byteBuffer);

        Charset charset = Charset.forName("utf-8");

        CharsetDecoder decoder = charset.newDecoder();

        CharsetEncoder encoder = charset.newEncoder();

        byteBuffer.flip();

        CharBuffer charBuffer = decoder.decode(byteBuffer);

        ByteBuffer encode = encoder.encode(charBuffer);

        outChannel.write(encode);

        in.close();

        out.close();
    }
}
