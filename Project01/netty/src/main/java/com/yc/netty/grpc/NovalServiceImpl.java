package com.yc.netty.grpc;

import com.yc.proto.*;
import io.grpc.stub.StreamObserver;

/**
 *
 * 使用 gRpc  首先  继承 生成好的  service 的类
 *     重写里面的  方法
 *
 *
 * @author LX
 * @date 2019/4/15 - 20:09
 */
public class NovalServiceImpl extends NovalServiceGrpc.NovalServiceImplBase {

    @Override
    public void getNovalByChapter(NovalRequest request, StreamObserver<NovalReponse> responseObserver) {

        System.out.println("来自客户端的  :  ");

        System.out.println("小说名: "+request.getNovalName());

        System.out.println("章节名: "+request.getChapterName());

        NovalReponse noval = NovalReponse.newBuilder().setId(2).setChapterContent("从前有座山，山上有座庙").setNovalName("斗罗大陆").build();

        responseObserver.onNext(noval);

        /*通知  方法都调用完了      开始 返回 给客户端   */
        responseObserver.onCompleted();
    }

    @Override
    public void getStudentsByAge(StudentRequest request, StreamObserver<StudentResponse> responseObserver) {

        System.out.println("来自客户端： "+request.getAge());

        responseObserver.onNext(StudentResponse.newBuilder().setAge(30).setName("李四").setCity("上海").build());
        responseObserver.onNext(StudentResponse.newBuilder().setAge(40).setName("王五").setCity("长沙").build());
        responseObserver.onNext(StudentResponse.newBuilder().setAge(50).setName("赵六").setCity("广州").build());
        responseObserver.onNext(StudentResponse.newBuilder().setAge(60).setName("王麻子").setCity("邵阳").build());
        responseObserver.onNext(StudentResponse.newBuilder().setAge(70).setName("李琦").setCity("北京").build());
        responseObserver.onNext(StudentResponse.newBuilder().setAge(80).setName("李曦").setCity("上海").build());

        responseObserver.onCompleted();
    }



    @Override
    public StreamObserver<StudentRequest> getStudentByAgeStream(StreamObserver<StudentResponseList> responseObserver) {

                   // 采用 回调  接口方法
        return new StreamObserver<StudentRequest>() {

                @Override
                public void onNext(StudentRequest value) {

                    System.out.println("onNext: " + value.getAge());
                }

            @Override
            public void onError(Throwable t) {

                System.out.println(t.getMessage());
            }

            /**
             * 客户端 数据全部发送  完毕的时候  调用此方法
             * 开始 返回信息给服务器
             */
            @Override
            public void onCompleted() {

                StudentResponse studentResponse = StudentResponse.newBuilder().setCity("长沙").setName("李四").setAge(20).build();
                StudentResponse studentResponse1 = StudentResponse.newBuilder().setCity("益阳").setName("赵五").setAge(30).build();

                StudentResponseList studentResponseList = StudentResponseList.newBuilder()
                        .addStudentResponse(studentResponse)
                        .addStudentResponse(studentResponse1).build();

                responseObserver.onNext(studentResponseList);

                responseObserver.onCompleted();
            }
        };
    }

    @Override
    public StreamObserver<StreamRequest> sendAndReceiveMessage(StreamObserver<StreamResponse> responseObserver) {



        return new StreamObserver<StreamRequest>() {
            @Override
            public void onNext(StreamRequest value) {
                System.out.println("from client request : "+ value.getRequestInfo());
            }

            @Override
            public void onError(Throwable t) {

            }

            @Override
            public void onCompleted() {

                StreamResponse build = StreamResponse.newBuilder().setResponseInfo("你好").build();
                StreamResponse build1 = StreamResponse.newBuilder().setResponseInfo("hello").build();
                StreamResponse build2 = StreamResponse.newBuilder().setResponseInfo("最近还好吗").build();
                StreamResponse build3 = StreamResponse.newBuilder().setResponseInfo("今天天气真好").build();

                responseObserver.onNext(build);
                responseObserver.onNext(build1);
                responseObserver.onNext(build2);
                responseObserver.onNext(build3);

                responseObserver.onCompleted();
            }
        };
    }
}


