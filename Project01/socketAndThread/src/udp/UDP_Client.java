package udp;

import java.io.IOException;
import java.net.*;

/**
 * @author LX
 * @date 2018/12/30 - 11:07
 */
public class UDP_Client {
    public static void main(String[] args) throws IOException {

        DatagramSocket client =new DatagramSocket();

        String  sendStr= "hello  world ";

        byte [] sendBuf=sendStr.getBytes();

        InetAddress inetAddress =InetAddress.getByName("127.0.0.1");

        int port =8686;

        DatagramPacket sendpacket =new DatagramPacket(sendBuf,sendBuf.length,inetAddress,port);

       client.send(sendpacket);

       byte [] recvBuf=new byte[1024];

       DatagramPacket recvPacket =new DatagramPacket(recvBuf,recvBuf.length);

       client.receive(recvPacket);  // 线程堵塞

       String recvStr= new String (recvPacket.getData(),0,recvPacket.getLength());

       System.out.println("receive from server " + recvStr);

       client.close();


    }
}
