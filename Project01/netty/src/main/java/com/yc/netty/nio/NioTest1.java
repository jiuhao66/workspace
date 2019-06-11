package com.yc.netty.nio;

import java.nio.IntBuffer;
import java.security.SecureRandom;

/**
 * @author LX
 * @date 2019/4/21 - 19:39
 */
public class NioTest1 {

    public static void main(String[] args) {

        /*   分配 大小为十 的 缓冲区*/
        IntBuffer intBuffer = IntBuffer.allocate(10);
        SecureRandom random = new SecureRandom();

        for ( int i = 0; i < intBuffer.capacity() ;i++){

            int nextInt = random.nextInt(20);

            System.out.print(nextInt + "  ");
            intBuffer.put(nextInt);
        }
        System.out.println();

        intBuffer.flip();

        while (intBuffer.hasRemaining()){
            System.out.println(intBuffer.get());
        }
    }
}
