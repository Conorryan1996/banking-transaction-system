package com.pm.grpc.fraud;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 * <pre>
 * Fraud detection service
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.60.1)",
    comments = "Source: fraud_service.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class FraudServiceGrpc {

  private FraudServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME = "com.pm.grpc.fraud.FraudService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.pm.grpc.fraud.CheckTransactionRequest,
      com.pm.grpc.fraud.CheckTransactionResponse> getCheckTransactionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CheckTransaction",
      requestType = com.pm.grpc.fraud.CheckTransactionRequest.class,
      responseType = com.pm.grpc.fraud.CheckTransactionResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.pm.grpc.fraud.CheckTransactionRequest,
      com.pm.grpc.fraud.CheckTransactionResponse> getCheckTransactionMethod() {
    io.grpc.MethodDescriptor<com.pm.grpc.fraud.CheckTransactionRequest, com.pm.grpc.fraud.CheckTransactionResponse> getCheckTransactionMethod;
    if ((getCheckTransactionMethod = FraudServiceGrpc.getCheckTransactionMethod) == null) {
      synchronized (FraudServiceGrpc.class) {
        if ((getCheckTransactionMethod = FraudServiceGrpc.getCheckTransactionMethod) == null) {
          FraudServiceGrpc.getCheckTransactionMethod = getCheckTransactionMethod =
              io.grpc.MethodDescriptor.<com.pm.grpc.fraud.CheckTransactionRequest, com.pm.grpc.fraud.CheckTransactionResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CheckTransaction"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.pm.grpc.fraud.CheckTransactionRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.pm.grpc.fraud.CheckTransactionResponse.getDefaultInstance()))
              .setSchemaDescriptor(new FraudServiceMethodDescriptorSupplier("CheckTransaction"))
              .build();
        }
      }
    }
    return getCheckTransactionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.pm.grpc.fraud.GetCustomerAlertsRequest,
      com.pm.grpc.fraud.GetCustomerAlertsResponse> getGetCustomerAlertsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetCustomerAlerts",
      requestType = com.pm.grpc.fraud.GetCustomerAlertsRequest.class,
      responseType = com.pm.grpc.fraud.GetCustomerAlertsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.pm.grpc.fraud.GetCustomerAlertsRequest,
      com.pm.grpc.fraud.GetCustomerAlertsResponse> getGetCustomerAlertsMethod() {
    io.grpc.MethodDescriptor<com.pm.grpc.fraud.GetCustomerAlertsRequest, com.pm.grpc.fraud.GetCustomerAlertsResponse> getGetCustomerAlertsMethod;
    if ((getGetCustomerAlertsMethod = FraudServiceGrpc.getGetCustomerAlertsMethod) == null) {
      synchronized (FraudServiceGrpc.class) {
        if ((getGetCustomerAlertsMethod = FraudServiceGrpc.getGetCustomerAlertsMethod) == null) {
          FraudServiceGrpc.getGetCustomerAlertsMethod = getGetCustomerAlertsMethod =
              io.grpc.MethodDescriptor.<com.pm.grpc.fraud.GetCustomerAlertsRequest, com.pm.grpc.fraud.GetCustomerAlertsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetCustomerAlerts"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.pm.grpc.fraud.GetCustomerAlertsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.pm.grpc.fraud.GetCustomerAlertsResponse.getDefaultInstance()))
              .setSchemaDescriptor(new FraudServiceMethodDescriptorSupplier("GetCustomerAlerts"))
              .build();
        }
      }
    }
    return getGetCustomerAlertsMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static FraudServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<FraudServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<FraudServiceStub>() {
        @java.lang.Override
        public FraudServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new FraudServiceStub(channel, callOptions);
        }
      };
    return FraudServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static FraudServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<FraudServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<FraudServiceBlockingStub>() {
        @java.lang.Override
        public FraudServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new FraudServiceBlockingStub(channel, callOptions);
        }
      };
    return FraudServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static FraudServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<FraudServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<FraudServiceFutureStub>() {
        @java.lang.Override
        public FraudServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new FraudServiceFutureStub(channel, callOptions);
        }
      };
    return FraudServiceFutureStub.newStub(factory, channel);
  }

  /**
   * <pre>
   * Fraud detection service
   * </pre>
   */
  public interface AsyncService {

    /**
     * <pre>
     * Check if a transaction would trigger fraud rules
     * </pre>
     */
    default void checkTransaction(com.pm.grpc.fraud.CheckTransactionRequest request,
        io.grpc.stub.StreamObserver<com.pm.grpc.fraud.CheckTransactionResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCheckTransactionMethod(), responseObserver);
    }

    /**
     * <pre>
     * Get fraud alerts for a customer
     * </pre>
     */
    default void getCustomerAlerts(com.pm.grpc.fraud.GetCustomerAlertsRequest request,
        io.grpc.stub.StreamObserver<com.pm.grpc.fraud.GetCustomerAlertsResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetCustomerAlertsMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service FraudService.
   * <pre>
   * Fraud detection service
   * </pre>
   */
  public static abstract class FraudServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return FraudServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service FraudService.
   * <pre>
   * Fraud detection service
   * </pre>
   */
  public static final class FraudServiceStub
      extends io.grpc.stub.AbstractAsyncStub<FraudServiceStub> {
    private FraudServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected FraudServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new FraudServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     * Check if a transaction would trigger fraud rules
     * </pre>
     */
    public void checkTransaction(com.pm.grpc.fraud.CheckTransactionRequest request,
        io.grpc.stub.StreamObserver<com.pm.grpc.fraud.CheckTransactionResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCheckTransactionMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Get fraud alerts for a customer
     * </pre>
     */
    public void getCustomerAlerts(com.pm.grpc.fraud.GetCustomerAlertsRequest request,
        io.grpc.stub.StreamObserver<com.pm.grpc.fraud.GetCustomerAlertsResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetCustomerAlertsMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service FraudService.
   * <pre>
   * Fraud detection service
   * </pre>
   */
  public static final class FraudServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<FraudServiceBlockingStub> {
    private FraudServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected FraudServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new FraudServiceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Check if a transaction would trigger fraud rules
     * </pre>
     */
    public com.pm.grpc.fraud.CheckTransactionResponse checkTransaction(com.pm.grpc.fraud.CheckTransactionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCheckTransactionMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Get fraud alerts for a customer
     * </pre>
     */
    public com.pm.grpc.fraud.GetCustomerAlertsResponse getCustomerAlerts(com.pm.grpc.fraud.GetCustomerAlertsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetCustomerAlertsMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service FraudService.
   * <pre>
   * Fraud detection service
   * </pre>
   */
  public static final class FraudServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<FraudServiceFutureStub> {
    private FraudServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected FraudServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new FraudServiceFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Check if a transaction would trigger fraud rules
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.pm.grpc.fraud.CheckTransactionResponse> checkTransaction(
        com.pm.grpc.fraud.CheckTransactionRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCheckTransactionMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Get fraud alerts for a customer
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.pm.grpc.fraud.GetCustomerAlertsResponse> getCustomerAlerts(
        com.pm.grpc.fraud.GetCustomerAlertsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetCustomerAlertsMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CHECK_TRANSACTION = 0;
  private static final int METHODID_GET_CUSTOMER_ALERTS = 1;

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
        case METHODID_CHECK_TRANSACTION:
          serviceImpl.checkTransaction((com.pm.grpc.fraud.CheckTransactionRequest) request,
              (io.grpc.stub.StreamObserver<com.pm.grpc.fraud.CheckTransactionResponse>) responseObserver);
          break;
        case METHODID_GET_CUSTOMER_ALERTS:
          serviceImpl.getCustomerAlerts((com.pm.grpc.fraud.GetCustomerAlertsRequest) request,
              (io.grpc.stub.StreamObserver<com.pm.grpc.fraud.GetCustomerAlertsResponse>) responseObserver);
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
          getCheckTransactionMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.pm.grpc.fraud.CheckTransactionRequest,
              com.pm.grpc.fraud.CheckTransactionResponse>(
                service, METHODID_CHECK_TRANSACTION)))
        .addMethod(
          getGetCustomerAlertsMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.pm.grpc.fraud.GetCustomerAlertsRequest,
              com.pm.grpc.fraud.GetCustomerAlertsResponse>(
                service, METHODID_GET_CUSTOMER_ALERTS)))
        .build();
  }

  private static abstract class FraudServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    FraudServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.pm.grpc.fraud.FraudServiceProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("FraudService");
    }
  }

  private static final class FraudServiceFileDescriptorSupplier
      extends FraudServiceBaseDescriptorSupplier {
    FraudServiceFileDescriptorSupplier() {}
  }

  private static final class FraudServiceMethodDescriptorSupplier
      extends FraudServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    FraudServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (FraudServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new FraudServiceFileDescriptorSupplier())
              .addMethod(getCheckTransactionMethod())
              .addMethod(getGetCustomerAlertsMethod())
              .build();
        }
      }
    }
    return result;
  }
}
