package com.yc.netty.nio;

import java.nio.IntBuffer;

/**
 * @author LX
 * @date 2019/4/24 - 20:09
 */
public class Slice_Buffer {

    public static void main(String[] args) {

        IntBuffer intBuffer = IntBuffer.allocate(10);

        for (int  i = 0 ; i <intBuffer.capacity() ; i++){
            intBuffer.put(i);
        }

        intBuffer.position(2);
        intBuffer.limit(6);

        //  截取 从position位置 到limit 的 buffer     与原本的Buffer共用同一块内存
        IntBuffer slice = intBuffer.slice();

        for (int  i  = 0 ;i<slice.capacity();i++){

            int i1 = slice.get(i);

            slice.put(i,i1*2);
        }
        // 只读  Buffer
        //  IntBuffer intBuffer1 = intBuffer.asReadOnlyBuffer();

        intBuffer.position(0);
        intBuffer.limit(intBuffer.capacity());

        for (int  i = 0 ; i < intBuffer.capacity(); i++){

            System.out.println(intBuffer.get());
        }
    }
}
