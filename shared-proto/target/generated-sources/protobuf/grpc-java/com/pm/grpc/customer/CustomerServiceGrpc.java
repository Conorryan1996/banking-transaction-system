package com.pm.grpc.customer;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.60.1)",
    comments = "Source: customer_service.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class CustomerServiceGrpc {

  private CustomerServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME = "customer.CustomerService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.pm.grpc.customer.CreateCustomerRequest,
      com.pm.grpc.customer.CreateCustomerResponse> getCreateCustomerMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateCustomer",
      requestType = com.pm.grpc.customer.CreateCustomerRequest.class,
      responseType = com.pm.grpc.customer.CreateCustomerResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.pm.grpc.customer.CreateCustomerRequest,
      com.pm.grpc.customer.CreateCustomerResponse> getCreateCustomerMethod() {
    io.grpc.MethodDescriptor<com.pm.grpc.customer.CreateCustomerRequest, com.pm.grpc.customer.CreateCustomerResponse> getCreateCustomerMethod;
    if ((getCreateCustomerMethod = CustomerServiceGrpc.getCreateCustomerMethod) == null) {
      synchronized (CustomerServiceGrpc.class) {
        if ((getCreateCustomerMethod = CustomerServiceGrpc.getCreateCustomerMethod) == null) {
          CustomerServiceGrpc.getCreateCustomerMethod = getCreateCustomerMethod =
              io.grpc.MethodDescriptor.<com.pm.grpc.customer.CreateCustomerRequest, com.pm.grpc.customer.CreateCustomerResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateCustomer"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.pm.grpc.customer.CreateCustomerRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.pm.grpc.customer.CreateCustomerResponse.getDefaultInstance()))
              .setSchemaDescriptor(new CustomerServiceMethodDescriptorSupplier("CreateCustomer"))
              .build();
        }
      }
    }
    return getCreateCustomerMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.pm.grpc.customer.GetCustomerRequest,
      com.pm.grpc.customer.GetCustomerResponse> getGetCustomerMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetCustomer",
      requestType = com.pm.grpc.customer.GetCustomerRequest.class,
      responseType = com.pm.grpc.customer.GetCustomerResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.pm.grpc.customer.GetCustomerRequest,
      com.pm.grpc.customer.GetCustomerResponse> getGetCustomerMethod() {
    io.grpc.MethodDescriptor<com.pm.grpc.customer.GetCustomerRequest, com.pm.grpc.customer.GetCustomerResponse> getGetCustomerMethod;
    if ((getGetCustomerMethod = CustomerServiceGrpc.getGetCustomerMethod) == null) {
      synchronized (CustomerServiceGrpc.class) {
        if ((getGetCustomerMethod = CustomerServiceGrpc.getGetCustomerMethod) == null) {
          CustomerServiceGrpc.getGetCustomerMethod = getGetCustomerMethod =
              io.grpc.MethodDescriptor.<com.pm.grpc.customer.GetCustomerRequest, com.pm.grpc.customer.GetCustomerResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetCustomer"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.pm.grpc.customer.GetCustomerRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.pm.grpc.customer.GetCustomerResponse.getDefaultInstance()))
              .setSchemaDescriptor(new CustomerServiceMethodDescriptorSupplier("GetCustomer"))
              .build();
        }
      }
    }
    return getGetCustomerMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.pm.grpc.customer.UpdateCustomerRequest,
      com.pm.grpc.customer.UpdateCustomerResponse> getUpdateCustomerMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateCustomer",
      requestType = com.pm.grpc.customer.UpdateCustomerRequest.class,
      responseType = com.pm.grpc.customer.UpdateCustomerResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.pm.grpc.customer.UpdateCustomerRequest,
      com.pm.grpc.customer.UpdateCustomerResponse> getUpdateCustomerMethod() {
    io.grpc.MethodDescriptor<com.pm.grpc.customer.UpdateCustomerRequest, com.pm.grpc.customer.UpdateCustomerResponse> getUpdateCustomerMethod;
    if ((getUpdateCustomerMethod = CustomerServiceGrpc.getUpdateCustomerMethod) == null) {
      synchronized (CustomerServiceGrpc.class) {
        if ((getUpdateCustomerMethod = CustomerServiceGrpc.getUpdateCustomerMethod) == null) {
          CustomerServiceGrpc.getUpdateCustomerMethod = getUpdateCustomerMethod =
              io.grpc.MethodDescriptor.<com.pm.grpc.customer.UpdateCustomerRequest, com.pm.grpc.customer.UpdateCustomerResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateCustomer"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.pm.grpc.customer.UpdateCustomerRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.pm.grpc.customer.UpdateCustomerResponse.getDefaultInstance()))
              .setSchemaDescriptor(new CustomerServiceMethodDescriptorSupplier("UpdateCustomer"))
              .build();
        }
      }
    }
    return getUpdateCustomerMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.pm.grpc.customer.ValidateCustomerRequest,
      com.pm.grpc.customer.ValidateCustomerResponse> getValidateCustomerMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ValidateCustomer",
      requestType = com.pm.grpc.customer.ValidateCustomerRequest.class,
      responseType = com.pm.grpc.customer.ValidateCustomerResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.pm.grpc.customer.ValidateCustomerRequest,
      com.pm.grpc.customer.ValidateCustomerResponse> getValidateCustomerMethod() {
    io.grpc.MethodDescriptor<com.pm.grpc.customer.ValidateCustomerRequest, com.pm.grpc.customer.ValidateCustomerResponse> getValidateCustomerMethod;
    if ((getValidateCustomerMethod = CustomerServiceGrpc.getValidateCustomerMethod) == null) {
      synchronized (CustomerServiceGrpc.class) {
        if ((getValidateCustomerMethod = CustomerServiceGrpc.getValidateCustomerMethod) == null) {
          CustomerServiceGrpc.getValidateCustomerMethod = getValidateCustomerMethod =
              io.grpc.MethodDescriptor.<com.pm.grpc.customer.ValidateCustomerRequest, com.pm.grpc.customer.ValidateCustomerResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ValidateCustomer"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.pm.grpc.customer.ValidateCustomerRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.pm.grpc.customer.ValidateCustomerResponse.getDefaultInstance()))
              .setSchemaDescriptor(new CustomerServiceMethodDescriptorSupplier("ValidateCustomer"))
              .build();
        }
      }
    }
    return getValidateCustomerMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static CustomerServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CustomerServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<CustomerServiceStub>() {
        @java.lang.Override
        public CustomerServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new CustomerServiceStub(channel, callOptions);
        }
      };
    return CustomerServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static CustomerServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CustomerServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<CustomerServiceBlockingStub>() {
        @java.lang.Override
        public CustomerServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new CustomerServiceBlockingStub(channel, callOptions);
        }
      };
    return CustomerServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static CustomerServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CustomerServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<CustomerServiceFutureStub>() {
        @java.lang.Override
        public CustomerServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new CustomerServiceFutureStub(channel, callOptions);
        }
      };
    return CustomerServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public interface AsyncService {

    /**
     */
    default void createCustomer(com.pm.grpc.customer.CreateCustomerRequest request,
        io.grpc.stub.StreamObserver<com.pm.grpc.customer.CreateCustomerResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreateCustomerMethod(), responseObserver);
    }

    /**
     */
    default void getCustomer(com.pm.grpc.customer.GetCustomerRequest request,
        io.grpc.stub.StreamObserver<com.pm.grpc.customer.GetCustomerResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetCustomerMethod(), responseObserver);
    }

    /**
     */
    default void updateCustomer(com.pm.grpc.customer.UpdateCustomerRequest request,
        io.grpc.stub.StreamObserver<com.pm.grpc.customer.UpdateCustomerResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUpdateCustomerMethod(), responseObserver);
    }

    /**
     */
    default void validateCustomer(com.pm.grpc.customer.ValidateCustomerRequest request,
        io.grpc.stub.StreamObserver<com.pm.grpc.customer.ValidateCustomerResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getValidateCustomerMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service CustomerService.
   */
  public static abstract class CustomerServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return CustomerServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service CustomerService.
   */
  public static final class CustomerServiceStub
      extends io.grpc.stub.AbstractAsyncStub<CustomerServiceStub> {
    private CustomerServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CustomerServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CustomerServiceStub(channel, callOptions);
    }

    /**
     */
    public void createCustomer(com.pm.grpc.customer.CreateCustomerRequest request,
        io.grpc.stub.StreamObserver<com.pm.grpc.customer.CreateCustomerResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateCustomerMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getCustomer(com.pm.grpc.customer.GetCustomerRequest request,
        io.grpc.stub.StreamObserver<com.pm.grpc.customer.GetCustomerResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetCustomerMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void updateCustomer(com.pm.grpc.customer.UpdateCustomerRequest request,
        io.grpc.stub.StreamObserver<com.pm.grpc.customer.UpdateCustomerResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateCustomerMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void validateCustomer(com.pm.grpc.customer.ValidateCustomerRequest request,
        io.grpc.stub.StreamObserver<com.pm.grpc.customer.ValidateCustomerResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getValidateCustomerMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service CustomerService.
   */
  public static final class CustomerServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<CustomerServiceBlockingStub> {
    private CustomerServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CustomerServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CustomerServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.pm.grpc.customer.CreateCustomerResponse createCustomer(com.pm.grpc.customer.CreateCustomerRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateCustomerMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.pm.grpc.customer.GetCustomerResponse getCustomer(com.pm.grpc.customer.GetCustomerRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetCustomerMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.pm.grpc.customer.UpdateCustomerResponse updateCustomer(com.pm.grpc.customer.UpdateCustomerRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateCustomerMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.pm.grpc.customer.ValidateCustomerResponse validateCustomer(com.pm.grpc.customer.ValidateCustomerRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getValidateCustomerMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service CustomerService.
   */
  public static final class CustomerServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<CustomerServiceFutureStub> {
    private CustomerServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CustomerServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CustomerServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.pm.grpc.customer.CreateCustomerResponse> createCustomer(
        com.pm.grpc.customer.CreateCustomerRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateCustomerMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.pm.grpc.customer.GetCustomerResponse> getCustomer(
        com.pm.grpc.customer.GetCustomerRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetCustomerMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.pm.grpc.customer.UpdateCustomerResponse> updateCustomer(
        com.pm.grpc.customer.UpdateCustomerRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateCustomerMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.pm.grpc.customer.ValidateCustomerResponse> validateCustomer(
        com.pm.grpc.customer.ValidateCustomerRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getValidateCustomerMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_CUSTOMER = 0;
  private static final int METHODID_GET_CUSTOMER = 1;
  private static final int METHODID_UPDATE_CUSTOMER = 2;
  private static final int METHODID_VALIDATE_CUSTOMER = 3;

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
        case METHODID_CREATE_CUSTOMER:
          serviceImpl.createCustomer((com.pm.grpc.customer.CreateCustomerRequest) request,
              (io.grpc.stub.StreamObserver<com.pm.grpc.customer.CreateCustomerResponse>) responseObserver);
          break;
        case METHODID_GET_CUSTOMER:
          serviceImpl.getCustomer((com.pm.grpc.customer.GetCustomerRequest) request,
              (io.grpc.stub.StreamObserver<com.pm.grpc.customer.GetCustomerResponse>) responseObserver);
          break;
        case METHODID_UPDATE_CUSTOMER:
          serviceImpl.updateCustomer((com.pm.grpc.customer.UpdateCustomerRequest) request,
              (io.grpc.stub.StreamObserver<com.pm.grpc.customer.UpdateCustomerResponse>) responseObserver);
          break;
        case METHODID_VALIDATE_CUSTOMER:
          serviceImpl.validateCustomer((com.pm.grpc.customer.ValidateCustomerRequest) request,
              (io.grpc.stub.StreamObserver<com.pm.grpc.customer.ValidateCustomerResponse>) responseObserver);
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
          getCreateCustomerMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.pm.grpc.customer.CreateCustomerRequest,
              com.pm.grpc.customer.CreateCustomerResponse>(
                service, METHODID_CREATE_CUSTOMER)))
        .addMethod(
          getGetCustomerMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.pm.grpc.customer.GetCustomerRequest,
              com.pm.grpc.customer.GetCustomerResponse>(
                service, METHODID_GET_CUSTOMER)))
        .addMethod(
          getUpdateCustomerMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.pm.grpc.customer.UpdateCustomerRequest,
              com.pm.grpc.customer.UpdateCustomerResponse>(
                service, METHODID_UPDATE_CUSTOMER)))
        .addMethod(
          getValidateCustomerMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.pm.grpc.customer.ValidateCustomerRequest,
              com.pm.grpc.customer.ValidateCustomerResponse>(
                service, METHODID_VALIDATE_CUSTOMER)))
        .build();
  }

  private static abstract class CustomerServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    CustomerServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.pm.grpc.customer.CustomerServiceOuterClass.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("CustomerService");
    }
  }

  private static final class CustomerServiceFileDescriptorSupplier
      extends CustomerServiceBaseDescriptorSupplier {
    CustomerServiceFileDescriptorSupplier() {}
  }

  private static final class CustomerServiceMethodDescriptorSupplier
      extends CustomerServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    CustomerServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (CustomerServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new CustomerServiceFileDescriptorSupplier())
              .addMethod(getCreateCustomerMethod())
              .addMethod(getGetCustomerMethod())
              .addMethod(getUpdateCustomerMethod())
              .addMethod(getValidateCustomerMethod())
              .build();
        }
      }
    }
    return result;
  }
}
