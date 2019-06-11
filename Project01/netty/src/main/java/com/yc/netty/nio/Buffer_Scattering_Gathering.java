package com.yc.netty.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Arrays;

/**
 * @author LX
 * @date 2019/4/24 - 21:28
 */
public class Buffer_Scattering_Gathering {

    public static void main(String[] args) throws IOException {

        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();

        InetSocketAddress address = new InetSocketAddress(8899);

        serverSocketChannel.bind(address);

        int messageLength = 2 + 3 + 4;

        ByteBuffer []byteBuffer = new ByteBuffer[3];

        byteBuffer[0] = ByteBuffer.allocate(2);

        byteBuffer[1] = ByteBuffer.allocate(3);

        byteBuffer[2] = ByteBuffer.allocate(4);

        SocketChannel accept = serverSocketChannel.accept();

        while (true){

            int bytesRead = 0 ;

            while (bytesRead < messageLength){

                long r = accept.read(byteBuffer);

                bytesRead += r;

                Arrays.asList(byteBuffer).forEach(
                        buffer-> System.out.println("position : "+buffer.position()
                                + "limit: "+buffer.limit()));
            }

            Arrays.asList(byteBuffer).forEach(buffer->buffer.flip());

            long bytesWrite = 0;

            while (bytesWrite< messageLength){

                long write = accept.write(byteBuffer);

                bytesWrite+=write;
            }

            Arrays.asList(byteBuffer).forEach(buffer->buffer.clear());
            System.out.println("bytesRead: "+bytesRead+"bytesWrite: "+bytesWrite+"messageLength: "+messageLength);
        }
    }
}
