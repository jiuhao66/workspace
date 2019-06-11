package com.yc.netty.nio;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.*;

/**
 * @author LX
 * @date 2019/4/27 - 18:34
 */
public class NioServer {

    private static Map<String , SocketChannel> clientMaps = new HashMap<>();

    public static void main(String[] args) throws IOException {

        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();

        serverSocketChannel.configureBlocking(false);

        InetSocketAddress inetSocketAddress = new InetSocketAddress("127.0.0.1",8899);

        ServerSocket serverSocket = serverSocketChannel.socket();

        serverSocket.bind(inetSocketAddress);

        Selector selector = Selector.open();

        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

        while (true){

            int select = selector.select();

            Set<SelectionKey> selectionKeys = selector.selectedKeys();

            selectionKeys.forEach(selectionKey -> {

                final SocketChannel client ;
                try {

                    if(selectionKey.isAcceptable()){

                        ServerSocketChannel serverSocketChannel1 =
                                (ServerSocketChannel) selectionKey.channel();

                        client = serverSocketChannel1.accept();

                        client.configureBlocking(false);

                        client.register(selector, SelectionKey.OP_READ);

                        String key  = "["+UUID.randomUUID().toString()+"]";

                        clientMaps.put(key, client);

                    }else if(selectionKey.isReadable()){

                        client = (SocketChannel)selectionKey.channel();

                        ByteBuffer byteBuffer = ByteBuffer.allocate(128);

                        int read = client.read(byteBuffer);

                        if(read>0){

                            byteBuffer.flip();

                            Charset charset = Charset.forName("utf-8");

                            String receiveMessage = String.valueOf(charset.decode(byteBuffer).array());

                            System.out.println(client+": "+receiveMessage);

                            String sendKey = null;

                            for(Map.Entry<String , SocketChannel > clientMap:clientMaps.entrySet()){

                                if(client == clientMap.getValue()){

                                    sendKey = clientMap.getKey();
                                    break;

                                }
                            }

                            for(Map.Entry<String , SocketChannel > clientMap:clientMaps.entrySet()){

                                SocketChannel clientMapValue = clientMap.getValue();

                                ByteBuffer byteBuffer1 = ByteBuffer.allocate(128);

                                byteBuffer1.put((sendKey+" 发送: "+receiveMessage).getBytes());

                                byteBuffer1.flip();

                                clientMapValue.write(byteBuffer1);

                            }
                        }
                    }

                }catch (Exception e){

                    e.printStackTrace();
                }
            });

            selectionKeys.clear();
        }
    }
}
