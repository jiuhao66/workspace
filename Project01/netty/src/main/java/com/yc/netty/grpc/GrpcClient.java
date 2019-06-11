package com.yc.netty.grpc;

import com.yc.proto.*;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

import java.util.Iterator;
import java.util.List;

/**
 * @author LX
 * @date 2019/4/15 - 20:37
 */
public class GrpcClient {

    public static void main(String[] args) throws InterruptedException {

        ManagedChannel managedChannel = ManagedChannelBuilder
                .forAddress("localhost", 8899)
                /*  默认使用 tls             */
                         .usePlaintext(true).build();
        NovalServiceGrpc.NovalServiceBlockingStub blockingStub = NovalServiceGrpc
                .newBlockingStub(managedChannel);

        NovalServiceGrpc.NovalServiceStub sub = NovalServiceGrpc.newStub(managedChannel);

        NovalRequest build = NovalRequest.newBuilder().setId(10)
                .setNovalName("斗破苍穹")
                .setChapterName("第一章").build();

        NovalReponse novalReponse = blockingStub.getNovalByChapter(build);

        System.out.println("来自服务器。。。。。");

        System.out.println(novalReponse.getId());
        System.out.println(novalReponse.getNovalName());
        System.out.println(novalReponse.getChapterName());
        System.out.println(novalReponse.getChapterContent());

        System.out.println("++++++++++++++++++++++");
        Iterator<StudentResponse> studentsByAge = blockingStub.getStudentsByAge(StudentRequest.newBuilder().setAge(66).build());

        while (studentsByAge.hasNext()){

            StudentResponse next = studentsByAge.next();

            System.out.println(next.getAge()+ " "+
                    next.getCity()+" "+next.getName());
        }

        System.out.println("_______________________________");

        StreamObserver<StudentResponseList> studentResponseListStreamObserver
                = new StreamObserver<StudentResponseList>() {

            @Override
            public void onNext(StudentResponseList value) {

                List<StudentResponse> studentResponseList =
                        value.getStudentResponseList();

                studentResponseList.forEach(studentResponse -> {

                    System.out.println(studentResponse.getAge()+ " "
                            +studentResponse.getCity()+" "+studentResponse.getName());
                    System.out.println("-------------------");
                });
            }
            @Override
            public void onError(Throwable t) {

            }
            @Override
            public void onCompleted() {

            }
        };

        StreamObserver<StudentRequest> studentRequestStreamObserver =
        sub.getStudentByAgeStream(studentResponseListStreamObserver);

        studentRequestStreamObserver.onNext(StudentRequest.newBuilder().setAge(20).build());
        studentRequestStreamObserver.onNext(StudentRequest.newBuilder().setAge(30).build());
        studentRequestStreamObserver.onNext(StudentRequest.newBuilder().setAge(40).build());
        studentRequestStreamObserver.onNext(StudentRequest.newBuilder().setAge(50).build());

        studentRequestStreamObserver.onCompleted();

        System.out.println("=========================");
        /* 通过 创建出 流对象   来获得返回的数据    */
        StreamObserver<StreamResponse> streamRequestStreamObserver=new StreamObserver<StreamResponse>(){
            @Override
            public void onNext(StreamResponse value) {

                System.out.println("from server message : "+ value.getResponseInfo());
            }

            @Override
            public void onError(Throwable t) {

            }

            @Override
            public void onCompleted() {

            }
        };
        StreamObserver<StreamRequest> streamRequestStreamObserver1 = sub.sendAndReceiveMessage(streamRequestStreamObserver);

        StreamRequest streamRequest = StreamRequest.newBuilder().setRequestInfo("大哥").build();
        StreamRequest streamRequest1 = StreamRequest.newBuilder().setRequestInfo("我好喜欢你").build();
        StreamRequest streamRequest2 = StreamRequest.newBuilder().setRequestInfo("你这也太厉害了 ").build();
        StreamRequest streamRequest3 = StreamRequest.newBuilder().setRequestInfo("大哥，你好6").build();
        streamRequestStreamObserver1.onNext(streamRequest);
        streamRequestStreamObserver1.onNext(streamRequest1);
        streamRequestStreamObserver1.onNext(streamRequest2);
        streamRequestStreamObserver1.onNext(streamRequest3);

        streamRequestStreamObserver1.onCompleted();
        Thread.sleep(6000);
    }
}
