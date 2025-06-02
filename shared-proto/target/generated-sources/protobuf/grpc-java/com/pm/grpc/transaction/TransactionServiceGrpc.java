package com.pm.grpc.transaction;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.60.1)",
    comments = "Source: transaction_service.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class TransactionServiceGrpc {

  private TransactionServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME = "transaction.TransactionService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.pm.grpc.transaction.ProcessTransactionRequest,
      com.pm.grpc.transaction.ProcessTransactionResponse> getProcessTransactionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ProcessTransaction",
      requestType = com.pm.grpc.transaction.ProcessTransactionRequest.class,
      responseType = com.pm.grpc.transaction.ProcessTransactionResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.pm.grpc.transaction.ProcessTransactionRequest,
      com.pm.grpc.transaction.ProcessTransactionResponse> getProcessTransactionMethod() {
    io.grpc.MethodDescriptor<com.pm.grpc.transaction.ProcessTransactionRequest, com.pm.grpc.transaction.ProcessTransactionResponse> getProcessTransactionMethod;
    if ((getProcessTransactionMethod = TransactionServiceGrpc.getProcessTransactionMethod) == null) {
      synchronized (TransactionServiceGrpc.class) {
        if ((getProcessTransactionMethod = TransactionServiceGrpc.getProcessTransactionMethod) == null) {
          TransactionServiceGrpc.getProcessTransactionMethod = getProcessTransactionMethod =
              io.grpc.MethodDescriptor.<com.pm.grpc.transaction.ProcessTransactionRequest, com.pm.grpc.transaction.ProcessTransactionResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ProcessTransaction"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.pm.grpc.transaction.ProcessTransactionRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.pm.grpc.transaction.ProcessTransactionResponse.getDefaultInstance()))
              .setSchemaDescriptor(new TransactionServiceMethodDescriptorSupplier("ProcessTransaction"))
              .build();
        }
      }
    }
    return getProcessTransactionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.pm.grpc.transaction.GetTransactionRequest,
      com.pm.grpc.transaction.GetTransactionResponse> getGetTransactionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetTransaction",
      requestType = com.pm.grpc.transaction.GetTransactionRequest.class,
      responseType = com.pm.grpc.transaction.GetTransactionResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.pm.grpc.transaction.GetTransactionRequest,
      com.pm.grpc.transaction.GetTransactionResponse> getGetTransactionMethod() {
    io.grpc.MethodDescriptor<com.pm.grpc.transaction.GetTransactionRequest, com.pm.grpc.transaction.GetTransactionResponse> getGetTransactionMethod;
    if ((getGetTransactionMethod = TransactionServiceGrpc.getGetTransactionMethod) == null) {
      synchronized (TransactionServiceGrpc.class) {
        if ((getGetTransactionMethod = TransactionServiceGrpc.getGetTransactionMethod) == null) {
          TransactionServiceGrpc.getGetTransactionMethod = getGetTransactionMethod =
              io.grpc.MethodDescriptor.<com.pm.grpc.transaction.GetTransactionRequest, com.pm.grpc.transaction.GetTransactionResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetTransaction"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.pm.grpc.transaction.GetTransactionRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.pm.grpc.transaction.GetTransactionResponse.getDefaultInstance()))
              .setSchemaDescriptor(new TransactionServiceMethodDescriptorSupplier("GetTransaction"))
              .build();
        }
      }
    }
    return getGetTransactionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.pm.grpc.transaction.GetTransactionsByAccountRequest,
      com.pm.grpc.transaction.GetTransactionsByAccountResponse> getGetTransactionsByAccountMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetTransactionsByAccount",
      requestType = com.pm.grpc.transaction.GetTransactionsByAccountRequest.class,
      responseType = com.pm.grpc.transaction.GetTransactionsByAccountResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.pm.grpc.transaction.GetTransactionsByAccountRequest,
      com.pm.grpc.transaction.GetTransactionsByAccountResponse> getGetTransactionsByAccountMethod() {
    io.grpc.MethodDescriptor<com.pm.grpc.transaction.GetTransactionsByAccountRequest, com.pm.grpc.transaction.GetTransactionsByAccountResponse> getGetTransactionsByAccountMethod;
    if ((getGetTransactionsByAccountMethod = TransactionServiceGrpc.getGetTransactionsByAccountMethod) == null) {
      synchronized (TransactionServiceGrpc.class) {
        if ((getGetTransactionsByAccountMethod = TransactionServiceGrpc.getGetTransactionsByAccountMethod) == null) {
          TransactionServiceGrpc.getGetTransactionsByAccountMethod = getGetTransactionsByAccountMethod =
              io.grpc.MethodDescriptor.<com.pm.grpc.transaction.GetTransactionsByAccountRequest, com.pm.grpc.transaction.GetTransactionsByAccountResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetTransactionsByAccount"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.pm.grpc.transaction.GetTransactionsByAccountRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.pm.grpc.transaction.GetTransactionsByAccountResponse.getDefaultInstance()))
              .setSchemaDescriptor(new TransactionServiceMethodDescriptorSupplier("GetTransactionsByAccount"))
              .build();
        }
      }
    }
    return getGetTransactionsByAccountMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.pm.grpc.transaction.GetTransactionsByCustomerRequest,
      com.pm.grpc.transaction.GetTransactionsByCustomerResponse> getGetTransactionsByCustomerMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetTransactionsByCustomer",
      requestType = com.pm.grpc.transaction.GetTransactionsByCustomerRequest.class,
      responseType = com.pm.grpc.transaction.GetTransactionsByCustomerResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.pm.grpc.transaction.GetTransactionsByCustomerRequest,
      com.pm.grpc.transaction.GetTransactionsByCustomerResponse> getGetTransactionsByCustomerMethod() {
    io.grpc.MethodDescriptor<com.pm.grpc.transaction.GetTransactionsByCustomerRequest, com.pm.grpc.transaction.GetTransactionsByCustomerResponse> getGetTransactionsByCustomerMethod;
    if ((getGetTransactionsByCustomerMethod = TransactionServiceGrpc.getGetTransactionsByCustomerMethod) == null) {
      synchronized (TransactionServiceGrpc.class) {
        if ((getGetTransactionsByCustomerMethod = TransactionServiceGrpc.getGetTransactionsByCustomerMethod) == null) {
          TransactionServiceGrpc.getGetTransactionsByCustomerMethod = getGetTransactionsByCustomerMethod =
              io.grpc.MethodDescriptor.<com.pm.grpc.transaction.GetTransactionsByCustomerRequest, com.pm.grpc.transaction.GetTransactionsByCustomerResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetTransactionsByCustomer"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.pm.grpc.transaction.GetTransactionsByCustomerRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.pm.grpc.transaction.GetTransactionsByCustomerResponse.getDefaultInstance()))
              .setSchemaDescriptor(new TransactionServiceMethodDescriptorSupplier("GetTransactionsByCustomer"))
              .build();
        }
      }
    }
    return getGetTransactionsByCustomerMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.pm.grpc.transaction.GetAccountBalanceRequest,
      com.pm.grpc.transaction.GetAccountBalanceResponse> getGetAccountBalanceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetAccountBalance",
      requestType = com.pm.grpc.transaction.GetAccountBalanceRequest.class,
      responseType = com.pm.grpc.transaction.GetAccountBalanceResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.pm.grpc.transaction.GetAccountBalanceRequest,
      com.pm.grpc.transaction.GetAccountBalanceResponse> getGetAccountBalanceMethod() {
    io.grpc.MethodDescriptor<com.pm.grpc.transaction.GetAccountBalanceRequest, com.pm.grpc.transaction.GetAccountBalanceResponse> getGetAccountBalanceMethod;
    if ((getGetAccountBalanceMethod = TransactionServiceGrpc.getGetAccountBalanceMethod) == null) {
      synchronized (TransactionServiceGrpc.class) {
        if ((getGetAccountBalanceMethod = TransactionServiceGrpc.getGetAccountBalanceMethod) == null) {
          TransactionServiceGrpc.getGetAccountBalanceMethod = getGetAccountBalanceMethod =
              io.grpc.MethodDescriptor.<com.pm.grpc.transaction.GetAccountBalanceRequest, com.pm.grpc.transaction.GetAccountBalanceResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetAccountBalance"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.pm.grpc.transaction.GetAccountBalanceRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.pm.grpc.transaction.GetAccountBalanceResponse.getDefaultInstance()))
              .setSchemaDescriptor(new TransactionServiceMethodDescriptorSupplier("GetAccountBalance"))
              .build();
        }
      }
    }
    return getGetAccountBalanceMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static TransactionServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<TransactionServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<TransactionServiceStub>() {
        @java.lang.Override
        public TransactionServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new TransactionServiceStub(channel, callOptions);
        }
      };
    return TransactionServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static TransactionServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<TransactionServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<TransactionServiceBlockingStub>() {
        @java.lang.Override
        public TransactionServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new TransactionServiceBlockingStub(channel, callOptions);
        }
      };
    return TransactionServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static TransactionServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<TransactionServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<TransactionServiceFutureStub>() {
        @java.lang.Override
        public TransactionServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new TransactionServiceFutureStub(channel, callOptions);
        }
      };
    return TransactionServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public interface AsyncService {

    /**
     */
    default void processTransaction(com.pm.grpc.transaction.ProcessTransactionRequest request,
        io.grpc.stub.StreamObserver<com.pm.grpc.transaction.ProcessTransactionResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getProcessTransactionMethod(), responseObserver);
    }

    /**
     */
    default void getTransaction(com.pm.grpc.transaction.GetTransactionRequest request,
        io.grpc.stub.StreamObserver<com.pm.grpc.transaction.GetTransactionResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetTransactionMethod(), responseObserver);
    }

    /**
     */
    default void getTransactionsByAccount(com.pm.grpc.transaction.GetTransactionsByAccountRequest request,
        io.grpc.stub.StreamObserver<com.pm.grpc.transaction.GetTransactionsByAccountResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetTransactionsByAccountMethod(), responseObserver);
    }

    /**
     */
    default void getTransactionsByCustomer(com.pm.grpc.transaction.GetTransactionsByCustomerRequest request,
        io.grpc.stub.StreamObserver<com.pm.grpc.transaction.GetTransactionsByCustomerResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetTransactionsByCustomerMethod(), responseObserver);
    }

    /**
     */
    default void getAccountBalance(com.pm.grpc.transaction.GetAccountBalanceRequest request,
        io.grpc.stub.StreamObserver<com.pm.grpc.transaction.GetAccountBalanceResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetAccountBalanceMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service TransactionService.
   */
  public static abstract class TransactionServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return TransactionServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service TransactionService.
   */
  public static final class TransactionServiceStub
      extends io.grpc.stub.AbstractAsyncStub<TransactionServiceStub> {
    private TransactionServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TransactionServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new TransactionServiceStub(channel, callOptions);
    }

    /**
     */
    public void processTransaction(com.pm.grpc.transaction.ProcessTransactionRequest request,
        io.grpc.stub.StreamObserver<com.pm.grpc.transaction.ProcessTransactionResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getProcessTransactionMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getTransaction(com.pm.grpc.transaction.GetTransactionRequest request,
        io.grpc.stub.StreamObserver<com.pm.grpc.transaction.GetTransactionResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetTransactionMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getTransactionsByAccount(com.pm.grpc.transaction.GetTransactionsByAccountRequest request,
        io.grpc.stub.StreamObserver<com.pm.grpc.transaction.GetTransactionsByAccountResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetTransactionsByAccountMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getTransactionsByCustomer(com.pm.grpc.transaction.GetTransactionsByCustomerRequest request,
        io.grpc.stub.StreamObserver<com.pm.grpc.transaction.GetTransactionsByCustomerResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetTransactionsByCustomerMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getAccountBalance(com.pm.grpc.transaction.GetAccountBalanceRequest request,
        io.grpc.stub.StreamObserver<com.pm.grpc.transaction.GetAccountBalanceResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetAccountBalanceMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service TransactionService.
   */
  public static final class TransactionServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<TransactionServiceBlockingStub> {
    private TransactionServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TransactionServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new TransactionServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.pm.grpc.transaction.ProcessTransactionResponse processTransaction(com.pm.grpc.transaction.ProcessTransactionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getProcessTransactionMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.pm.grpc.transaction.GetTransactionResponse getTransaction(com.pm.grpc.transaction.GetTransactionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetTransactionMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.pm.grpc.transaction.GetTransactionsByAccountResponse getTransactionsByAccount(com.pm.grpc.transaction.GetTransactionsByAccountRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetTransactionsByAccountMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.pm.grpc.transaction.GetTransactionsByCustomerResponse getTransactionsByCustomer(com.pm.grpc.transaction.GetTransactionsByCustomerRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetTransactionsByCustomerMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.pm.grpc.transaction.GetAccountBalanceResponse getAccountBalance(com.pm.grpc.transaction.GetAccountBalanceRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetAccountBalanceMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service TransactionService.
   */
  public static final class TransactionServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<TransactionServiceFutureStub> {
    private TransactionServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TransactionServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new TransactionServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.pm.grpc.transaction.ProcessTransactionResponse> processTransaction(
        com.pm.grpc.transaction.ProcessTransactionRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getProcessTransactionMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.pm.grpc.transaction.GetTransactionResponse> getTransaction(
        com.pm.grpc.transaction.GetTransactionRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetTransactionMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.pm.grpc.transaction.GetTransactionsByAccountResponse> getTransactionsByAccount(
        com.pm.grpc.transaction.GetTransactionsByAccountRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetTransactionsByAccountMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.pm.grpc.transaction.GetTransactionsByCustomerResponse> getTransactionsByCustomer(
        com.pm.grpc.transaction.GetTransactionsByCustomerRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetTransactionsByCustomerMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.pm.grpc.transaction.GetAccountBalanceResponse> getAccountBalance(
        com.pm.grpc.transaction.GetAccountBalanceRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetAccountBalanceMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_PROCESS_TRANSACTION = 0;
  private static final int METHODID_GET_TRANSACTION = 1;
  private static final int METHODID_GET_TRANSACTIONS_BY_ACCOUNT = 2;
  private static final int METHODID_GET_TRANSACTIONS_BY_CUSTOMER = 3;
  private static final int METHODID_GET_ACCOUNT_BALANCE = 4;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final AsyncService serviceImpl;
    private final int methodId;

    MethodHandlers(AsyncService serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_PROCESS_TRANSACTION:
          serviceImpl.processTransaction((com.pm.grpc.transaction.ProcessTransactionRequest) request,
              (io.grpc.stub.StreamObserver<com.pm.grpc.transaction.ProcessTransactionResponse>) responseObserver);
          break;
        case METHODID_GET_TRANSACTION:
          serviceImpl.getTransaction((com.pm.grpc.transaction.GetTransactionRequest) request,
              (io.grpc.stub.StreamObserver<com.pm.grpc.transaction.GetTransactionResponse>) responseObserver);
          break;
        case METHODID_GET_TRANSACTIONS_BY_ACCOUNT:
          serviceImpl.getTransactionsByAccount((com.pm.grpc.transaction.GetTransactionsByAccountRequest) request,
              (io.grpc.stub.StreamObserver<com.pm.grpc.transaction.GetTransactionsByAccountResponse>) responseObserver);
          break;
        case METHODID_GET_TRANSACTIONS_BY_CUSTOMER:
          serviceImpl.getTransactionsByCustomer((com.pm.grpc.transaction.GetTransactionsByCustomerRequest) request,
              (io.grpc.stub.StreamObserver<com.pm.grpc.transaction.GetTransactionsByCustomerResponse>) responseObserver);
          break;
        case METHODID_GET_ACCOUNT_BALANCE:
          serviceImpl.getAccountBalance((com.pm.grpc.transaction.GetAccountBalanceRequest) request,
              (io.grpc.stub.StreamObserver<com.pm.grpc.transaction.GetAccountBalanceResponse>) responseObserver);
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
        default:
          throw new AssertionError();
      }
    }
  }

  public static final io.grpc.ServerServiceDefinition bindService(AsyncService service) {
    return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
        .addMethod(
          getProcessTransactionMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.pm.grpc.transaction.ProcessTransactionRequest,
              com.pm.grpc.transaction.ProcessTransactionResponse>(
                service, METHODID_PROCESS_TRANSACTION)))
        .addMethod(
          getGetTransactionMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.pm.grpc.transaction.GetTransactionRequest,
              com.pm.grpc.transaction.GetTransactionResponse>(
                service, METHODID_GET_TRANSACTION)))
        .addMethod(
          getGetTransactionsByAccountMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.pm.grpc.transaction.GetTransactionsByAccountRequest,
              com.pm.grpc.transaction.GetTransactionsByAccountResponse>(
                service, METHODID_GET_TRANSACTIONS_BY_ACCOUNT)))
        .addMethod(
          getGetTransactionsByCustomerMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.pm.grpc.transaction.GetTransactionsByCustomerRequest,
              com.pm.grpc.transaction.GetTransactionsByCustomerResponse>(
                service, METHODID_GET_TRANSACTIONS_BY_CUSTOMER)))
        .addMethod(
          getGetAccountBalanceMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.pm.grpc.transaction.GetAccountBalanceRequest,
              com.pm.grpc.transaction.GetAccountBalanceResponse>(
                service, METHODID_GET_ACCOUNT_BALANCE)))
        .build();
  }

  private static abstract class TransactionServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    TransactionServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.pm.grpc.transaction.TransactionServiceOuterClass.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("TransactionService");
    }
  }

  private static final class TransactionServiceFileDescriptorSupplier
      extends TransactionServiceBaseDescriptorSupplier {
    TransactionServiceFileDescriptorSupplier() {}
  }

  private static final class TransactionServiceMethodDescriptorSupplier
      extends TransactionServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    TransactionServiceMethodDescriptorSupplier(java.lang.String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (TransactionServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new TransactionServiceFileDescriptorSupplier())
              .addMethod(getProcessTransactionMethod())
              .addMethod(getGetTransactionMethod())
              .addMethod(getGetTransactionsByAccountMethod())
              .addMethod(getGetTransactionsByCustomerMethod())
              .addMethod(getGetAccountBalanceMethod())
              .build();
        }
      }
    }
    return result;
  }
}
