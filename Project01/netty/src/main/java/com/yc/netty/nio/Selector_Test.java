package com.yc.netty.nio;


import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;
import java.util.Set;

/**
 * @author LX
 * @date 2019/4/27 - 11:05
 */
public class Selector_Test {

    public static void main(String[] args) throws IOException {

        int [] ports = new int [5];

        ports[0] = 8899;

        ports[1] = 5001;

        ports[2] = 5002;

        ports[3] = 5003;

        ports[4] = 5004;

        Selector selector = Selector.open();

        for (int i = 0 ; i < 5 ; i ++){

            ServerSocketChannel  socketChannel = ServerSocketChannel.open();

            socketChannel.configureBlocking(false);

            ServerSocket serverSocket = new ServerSocket();

            InetSocketAddress inetSocketAddress = new InetSocketAddress("127.0.0.1",ports[i]);

            socketChannel.bind(inetSocketAddress);

            socketChannel.register(selector, SelectionKey.OP_ACCEPT);

            System.out.println("监听端口: "+ports[i]);
        }

        while (true){

            int select = selector.select();

            System.out.println("selectNumber: "+select);

            Set<SelectionKey> selectionKeys = selector.keys();

            System.out.println("selectionKey: "+selectionKeys);

            Iterator<SelectionKey> selectionKeyIterator = selectionKeys.iterator();

            while (selectionKeyIterator.hasNext()){

                SelectionKey selectionKey = selectionKeyIterator.next();

                // 判断 连接是否 建立 然后建立 就注册
                if(selectionKey.isAcceptable()){

                    ServerSocketChannel serverSocketChannel = (ServerSocketChannel) selectionKey.channel();

                    SocketChannel socketChannel = serverSocketChannel.accept();

                    socketChannel.configureBlocking(false);

                    socketChannel.register(selector, SelectionKey.OP_READ);


                    System.out.println("获得客户端连接: "+socketChannel);

                }else if (selectionKey.isReadable()){

                    SocketChannel socketChannel = (SocketChannel) selectionKey.channel();

                    int byteRead = 0 ;

                    while (true){

                        ByteBuffer byteBuffer = ByteBuffer.allocate(512);

                        byteBuffer.clear();

                        int read = socketChannel.read(byteBuffer);

                        if(read <=0)
                            break;

                        byteBuffer.flip();

                        socketChannel.write(byteBuffer);

                        byteRead+=read;
                    }
                    System.out.println("读取: "+byteRead + "来自于: "+socketChannel);
                }
            }
        }
    }
}
