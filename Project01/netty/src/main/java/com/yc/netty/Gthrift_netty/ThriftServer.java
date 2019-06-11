package com.yc.netty.Gthrift_netty;

import org.apache.thrift.TProcessorFactory;
import org.apache.thrift.protocol.TCompactProtocol;
import org.apache.thrift.server.THsHaServer;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TThreadedSelectorServer;
import org.apache.thrift.transport.TFramedTransport;
import org.apache.thrift.transport.TNonblockingServerSocket;
import org.apache.thrift.transport.TTransportException;
import thrift.generated.PersonService;

/**
 * @author LX
 * @date 2019/4/3 - 19:09
 */
public class ThriftServer {
    public static void main(String[] args) throws TTransportException {

        /*EventLoopGroup bossGroup = new NioEventLoopGroup();

        EventLoopGroup workerGroup = new NioEventLoopGroup();

        ServerBootstrap server = new ServerBootstrap();*/

        // 服务模型   非堵塞    需要结合 TFramedTransport来使用
        TNonblockingServerSocket serverSocket = new TNonblockingServerSocket(8899);

        THsHaServer.Args arg = new THsHaServer.Args(serverSocket).minWorkerThreads(2).minWorkerThreads(4);

        PersonService.Processor<PersonThriftServiceImpl> processor =
                new PersonService.Processor<>(new PersonThriftServiceImpl());

        // 传输协议
        arg.protocolFactory(new TCompactProtocol.Factory());

        // 传输格式
        arg.transportFactory(new TFramedTransport.Factory());

        //
        arg.processorFactory(new TProcessorFactory(processor));

        // 半异步 半同步的 服务模型
        TServer server = new THsHaServer(arg);

        System.out.println("Thrift Server Started! ");

        //死循环    非堵塞的
        server.serve();

    }
}
