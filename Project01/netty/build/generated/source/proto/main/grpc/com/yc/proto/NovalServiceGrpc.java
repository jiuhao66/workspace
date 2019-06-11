package com.yc.proto;

import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.4.0)",
    comments = "Source: noval.proto")
public final class NovalServiceGrpc {

  private NovalServiceGrpc() {}

  public static final String SERVICE_NAME = "com.yc.proto.NovalService";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<com.yc.proto.NovalRequest,
      com.yc.proto.NovalReponse> METHOD_GET_NOVAL_BY_CHAPTER =
      io.grpc.MethodDescriptor.<com.yc.proto.NovalRequest, com.yc.proto.NovalReponse>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "com.yc.proto.NovalService", "getNovalByChapter"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.yc.proto.NovalRequest.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.yc.proto.NovalReponse.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<com.yc.proto.StudentRequest,
      com.yc.proto.StudentResponse> METHOD_GET_STUDENTS_BY_AGE =
      io.grpc.MethodDescriptor.<com.yc.proto.StudentRequest, com.yc.proto.StudentResponse>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
          .setFullMethodName(generateFullMethodName(
              "com.yc.proto.NovalService", "getStudentsByAge"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.yc.proto.StudentRequest.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.yc.proto.StudentResponse.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<com.yc.proto.StudentRequest,
      com.yc.proto.StudentResponseList> METHOD_GET_STUDENT_BY_AGE_STREAM =
      io.grpc.MethodDescriptor.<com.yc.proto.StudentRequest, com.yc.proto.StudentResponseList>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
          .setFullMethodName(generateFullMethodName(
              "com.yc.proto.NovalService", "getStudentByAgeStream"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.yc.proto.StudentRequest.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.yc.proto.StudentResponseList.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<com.yc.proto.StreamRequest,
      com.yc.proto.StreamResponse> METHOD_SEND_AND_RECEIVE_MESSAGE =
      io.grpc.MethodDescriptor.<com.yc.proto.StreamRequest, com.yc.proto.StreamResponse>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
          .setFullMethodName(generateFullMethodName(
              "com.yc.proto.NovalService", "sendAndReceiveMessage"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.yc.proto.StreamRequest.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.yc.proto.StreamResponse.getDefaultInstance()))
          .build();

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static NovalServiceStub newStub(io.grpc.Channel channel) {
    return new NovalServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static NovalServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new NovalServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static NovalServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new NovalServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class NovalServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void getNovalByChapter(com.yc.proto.NovalRequest request,
        io.grpc.stub.StreamObserver<com.yc.proto.NovalReponse> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_GET_NOVAL_BY_CHAPTER, responseObserver);
    }

    /**
     * <pre>
     *    参数类型  必须是message 类型
     * </pre>
     */
    public void getStudentsByAge(com.yc.proto.StudentRequest request,
        io.grpc.stub.StreamObserver<com.yc.proto.StudentResponse> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_GET_STUDENTS_BY_AGE, responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<com.yc.proto.StudentRequest> getStudentByAgeStream(
        io.grpc.stub.StreamObserver<com.yc.proto.StudentResponseList> responseObserver) {
      return asyncUnimplementedStreamingCall(METHOD_GET_STUDENT_BY_AGE_STREAM, responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<com.yc.proto.StreamRequest> sendAndReceiveMessage(
        io.grpc.stub.StreamObserver<com.yc.proto.StreamResponse> responseObserver) {
      return asyncUnimplementedStreamingCall(METHOD_SEND_AND_RECEIVE_MESSAGE, responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            METHOD_GET_NOVAL_BY_CHAPTER,
            asyncUnaryCall(
              new MethodHandlers<
                com.yc.proto.NovalRequest,
                com.yc.proto.NovalReponse>(
                  this, METHODID_GET_NOVAL_BY_CHAPTER)))
          .addMethod(
            METHOD_GET_STUDENTS_BY_AGE,
            asyncServerStreamingCall(
              new MethodHandlers<
                com.yc.proto.StudentRequest,
                com.yc.proto.StudentResponse>(
                  this, METHODID_GET_STUDENTS_BY_AGE)))
          .addMethod(
            METHOD_GET_STUDENT_BY_AGE_STREAM,
            asyncClientStreamingCall(
              new MethodHandlers<
                com.yc.proto.StudentRequest,
                com.yc.proto.StudentResponseList>(
                  this, METHODID_GET_STUDENT_BY_AGE_STREAM)))
          .addMethod(
            METHOD_SEND_AND_RECEIVE_MESSAGE,
            asyncBidiStreamingCall(
              new MethodHandlers<
                com.yc.proto.StreamRequest,
                com.yc.proto.StreamResponse>(
                  this, METHODID_SEND_AND_RECEIVE_MESSAGE)))
          .build();
    }
  }

  /**
   */
  public static final class NovalServiceStub extends io.grpc.stub.AbstractStub<NovalServiceStub> {
    private NovalServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private NovalServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected NovalServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new NovalServiceStub(channel, callOptions);
    }

    /**
     */
    public void getNovalByChapter(com.yc.proto.NovalRequest request,
        io.grpc.stub.StreamObserver<com.yc.proto.NovalReponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_GET_NOVAL_BY_CHAPTER, getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     *    参数类型  必须是message 类型
     * </pre>
     */
    public void getStudentsByAge(com.yc.proto.StudentRequest request,
        io.grpc.stub.StreamObserver<com.yc.proto.StudentResponse> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(METHOD_GET_STUDENTS_BY_AGE, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<com.yc.proto.StudentRequest> getStudentByAgeStream(
        io.grpc.stub.StreamObserver<com.yc.proto.StudentResponseList> responseObserver) {
      return asyncClientStreamingCall(
          getChannel().newCall(METHOD_GET_STUDENT_BY_AGE_STREAM, getCallOptions()), responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<com.yc.proto.StreamRequest> sendAndReceiveMessage(
        io.grpc.stub.StreamObserver<com.yc.proto.StreamResponse> responseObserver) {
      return asyncBidiStreamingCall(
          getChannel().newCall(METHOD_SEND_AND_RECEIVE_MESSAGE, getCallOptions()), responseObserver);
    }
  }

  /**
   */
  public static final class NovalServiceBlockingStub extends io.grpc.stub.AbstractStub<NovalServiceBlockingStub> {
    private NovalServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private NovalServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected NovalServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new NovalServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.yc.proto.NovalReponse getNovalByChapter(com.yc.proto.NovalRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_GET_NOVAL_BY_CHAPTER, getCallOptions(), request);
    }

    /**
     * <pre>
     *    参数类型  必须是message 类型
     * </pre>
     */
    public java.util.Iterator<com.yc.proto.StudentResponse> getStudentsByAge(
        com.yc.proto.StudentRequest request) {
      return blockingServerStreamingCall(
          getChannel(), METHOD_GET_STUDENTS_BY_AGE, getCallOptions(), request);
    }
  }

  /**
   */
  public static final class NovalServiceFutureStub extends io.grpc.stub.AbstractStub<NovalServiceFutureStub> {
    private NovalServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private NovalServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected NovalServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new NovalServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.yc.proto.NovalReponse> getNovalByChapter(
        com.yc.proto.NovalRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_GET_NOVAL_BY_CHAPTER, getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_NOVAL_BY_CHAPTER = 0;
  private static final int METHODID_GET_STUDENTS_BY_AGE = 1;
  private static final int METHODID_GET_STUDENT_BY_AGE_STREAM = 2;
  private static final int METHODID_SEND_AND_RECEIVE_MESSAGE = 3;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final NovalServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(NovalServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_NOVAL_BY_CHAPTER:
          serviceImpl.getNovalByChapter((com.yc.proto.NovalRequest) request,
              (io.grpc.stub.StreamObserver<com.yc.proto.NovalReponse>) responseObserver);
          break;
        case METHODID_GET_STUDENTS_BY_AGE:
          serviceImpl.getStudentsByAge((com.yc.proto.StudentRequest) request,
              (io.grpc.stub.StreamObserver<com.yc.proto.StudentResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_STUDENT_BY_AGE_STREAM:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.getStudentByAgeStream(
              (io.grpc.stub.StreamObserver<com.yc.proto.StudentResponseList>) responseObserver);
        case METHODID_SEND_AND_RECEIVE_MESSAGE:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.sendAndReceiveMessage(
              (io.grpc.stub.StreamObserver<com.yc.proto.StreamResponse>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static final class NovalServiceDescriptorSupplier implements io.grpc.protobuf.ProtoFileDescriptorSupplier {
    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.yc.proto.noval.getDescriptor();
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (NovalServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new NovalServiceDescriptorSupplier())
              .addMethod(METHOD_GET_NOVAL_BY_CHAPTER)
              .addMethod(METHOD_GET_STUDENTS_BY_AGE)
              .addMethod(METHOD_GET_STUDENT_BY_AGE_STREAM)
              .addMethod(METHOD_SEND_AND_RECEIVE_MESSAGE)
              .build();
        }
      }
    }
    return result;
  }
}
