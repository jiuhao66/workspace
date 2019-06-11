package com.yc.netty.grpc;

import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;

/**
 * @author LX
 * @date 2019/4/15 - 20:22
 */
public class GrpcServer {

    private Server server ;

    private  void start() throws IOException {

        int port = 8899 ;
        server = ServerBuilder
                .forPort(port)
                /*          处理接受的  请求 */
                .addService(new NovalServiceImpl())
                       .build()
                           .start();
        System.out.println("server start  ......");

        Runtime.getRuntime().addShutdownHook(new Thread(()->{

            System.out.println("关闭  jvm   ");
        }));

        System.out.println("执行到这里  ");
    }
    private void stop(){

        System.out.println("关闭服务器");
        if(server!=null){
            this.server.shutdown();
        }
    }

    /**
     *  作用是 为了让  服务启动 处理等待状态
     *
     *    默认的服务 启动了  就会自动 关闭 的
     *
     * @throws InterruptedException
     */
    private void awaitTermination() throws InterruptedException {

        if(server!=null){

            server.awaitTermination();
        }
    }

    public static void main(String[] args) throws IOException, InterruptedException {

        GrpcServer server = new GrpcServer();

        server.start();
        server.awaitTermination();
        server.stop();
    }
}
