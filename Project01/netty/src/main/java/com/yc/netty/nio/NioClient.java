package com.yc.netty.nio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.time.LocalDateTime;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author LX
 * @date 2019/4/27 - 21:32
 */
public class NioClient {

    public static void main(String[] args) throws Exception {

        SocketChannel socketChannel = SocketChannel.open();

        socketChannel.configureBlocking(false);

        Selector selector = Selector.open();

        socketChannel.register(selector, SelectionKey.OP_CONNECT);

        socketChannel.connect(new InetSocketAddress("127.0.0.1",8899));

        while (true){

            selector.select();

            Set<SelectionKey> selectedKeys = selector.selectedKeys();

            for (SelectionKey selectionKey : selectedKeys) {

                if(selectionKey.isConnectable()){

                    SocketChannel client = (SocketChannel) selectionKey.channel();

                    if(client.isConnectionPending()){

                        ByteBuffer byteBuffer = ByteBuffer.allocate(128);

                        try {
                            client.finishConnect();

                            byteBuffer.put((LocalDateTime.now()+"θΏζζε ").getBytes());

                            byteBuffer.flip();

                            client.write(byteBuffer);

                            ExecutorService executorService = Executors
                                    .newSingleThreadExecutor(Executors.defaultThreadFactory());

                            executorService.submit(()->{

                                while (true){

                                    try {
                                        byteBuffer.clear();

                                        InputStreamReader in = new InputStreamReader(System.in);

                                        BufferedReader br  = new BufferedReader(in);

                                        String readLine = br.readLine();

                                        byteBuffer.put(readLine.getBytes());

                                        byteBuffer.flip();

                                        client.write(byteBuffer);

                                    }catch (Exception e){

                                        e.printStackTrace();
                                    }

                                }
                            });

                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                        try {


                            client.register(selector, SelectionKey.OP_READ);

                        } catch (ClosedChannelException e) {
                            e.printStackTrace();
                        }

                    }else if(selectionKey.isReadable()){

                        SocketChannel socketChannel1 = (SocketChannel) selectionKey.channel();

                        ByteBuffer byteBuffer = ByteBuffer.allocate(128);

                        try {

                            int read = socketChannel1.read(byteBuffer);

                            if(read>0){

                                String receiveMessage = new String(byteBuffer.array(),0,read);

                                System.out.println(receiveMessage);
                            }

                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                    }
                }
            }
            selectedKeys.clear();
        }
    }
}
