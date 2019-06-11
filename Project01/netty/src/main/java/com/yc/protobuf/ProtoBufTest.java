package com.yc.protobuf;

import com.google.protobuf.InvalidProtocolBufferException;

/**
 * @author LX
 * @date 2019/3/30 - 13:07
 */
public class ProtoBufTest {

    public static void main(String[] args) throws InvalidProtocolBufferException {

        DataInfo.Student student = DataInfo.Student.newBuilder().setName("lixin").setAge(20).setAddress("湖南").build();

        byte[] bytes = student.toByteArray();

        DataInfo.Student student1 = DataInfo.Student.parseFrom(bytes);

        System.out.println(student1.getName());

        System.out.println(student1.getAge());

        System.out.print(student1.getAddress());
    }
}
