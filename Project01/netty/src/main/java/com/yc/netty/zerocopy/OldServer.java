package com.yc.netty.zerocopy;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author LX
 * @date 2019/5/1 - 15:43
 */
public class OldServer {

    public static void main(String[] args) throws IOException {

        ServerSocket serverSocket = new ServerSocket(8899);
        
        while (true){

            Socket accept = serverSocket.accept();

            DataOutputStream dataOutputStream = new DataOutputStream(accept.getOutputStream());

            try {
                byte [] array = new byte[4096];

                int len = 0;

            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
