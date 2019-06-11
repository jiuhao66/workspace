package udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * @author LX
 * @date 2018/12/30 - 11:07
 */
public class UDP_Server {

    public static void main(String[] args) throws IOException {

        DatagramSocket server =new DatagramSocket(8686);

        byte [] recvBuf = new byte[1024];

        DatagramPacket recvPacket =new DatagramPacket(recvBuf,recvBuf.length);

        server.receive(recvPacket);  // 线程堵塞

        String  recvStr=new String( recvPacket.getData(),0,recvPacket.getLength());

        System.out.println( " receive  from client " + recvStr );

        int port =recvPacket.getPort();

        InetAddress address =recvPacket.getAddress();

        String response=new String( " hello i am  server ");

        byte [] sendBuf =response.getBytes();

        DatagramPacket sendPacket =new DatagramPacket(sendBuf ,sendBuf.length,address ,port);

        server.send(sendPacket);

        server.close();

    }
}
