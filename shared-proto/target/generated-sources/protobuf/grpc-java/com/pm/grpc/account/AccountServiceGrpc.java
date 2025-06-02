package com.pm.grpc.account;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.60.1)",
    comments = "Source: account_service.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class AccountServiceGrpc {

  private AccountServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME = "account.AccountService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.pm.grpc.account.CreateAccountRequest,
      com.pm.grpc.account.CreateAccountResponse> getCreateAccountMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateAccount",
      requestType = com.pm.grpc.account.CreateAccountRequest.class,
      responseType = com.pm.grpc.account.CreateAccountResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.pm.grpc.account.CreateAccountRequest,
      com.pm.grpc.account.CreateAccountResponse> getCreateAccountMethod() {
    io.grpc.MethodDescriptor<com.pm.grpc.account.CreateAccountRequest, com.pm.grpc.account.CreateAccountResponse> getCreateAccountMethod;
    if ((getCreateAccountMethod = AccountServiceGrpc.getCreateAccountMethod) == null) {
      synchronized (AccountServiceGrpc.class) {
        if ((getCreateAccountMethod = AccountServiceGrpc.getCreateAccountMethod) == null) {
          AccountServiceGrpc.getCreateAccountMethod = getCreateAccountMethod =
              io.grpc.MethodDescriptor.<com.pm.grpc.account.CreateAccountRequest, com.pm.grpc.account.CreateAccountResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateAccount"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.pm.grpc.account.CreateAccountRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.pm.grpc.account.CreateAccountResponse.getDefaultInstance()))
              .setSchemaDescriptor(new AccountServiceMethodDescriptorSupplier("CreateAccount"))
              .build();
        }
      }
    }
    return getCreateAccountMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.pm.grpc.account.GetAccountRequest,
      com.pm.grpc.account.GetAccountResponse> getGetAccountMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetAccount",
      requestType = com.pm.grpc.account.GetAccountRequest.class,
      responseType = com.pm.grpc.account.GetAccountResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.pm.grpc.account.GetAccountRequest,
      com.pm.grpc.account.GetAccountResponse> getGetAccountMethod() {
    io.grpc.MethodDescriptor<com.pm.grpc.account.GetAccountRequest, com.pm.grpc.account.GetAccountResponse> getGetAccountMethod;
    if ((getGetAccountMethod = AccountServiceGrpc.getGetAccountMethod) == null) {
      synchronized (AccountServiceGrpc.class) {
        if ((getGetAccountMethod = AccountServiceGrpc.getGetAccountMethod) == null) {
          AccountServiceGrpc.getGetAccountMethod = getGetAccountMethod =
              io.grpc.MethodDescriptor.<com.pm.grpc.account.GetAccountRequest, com.pm.grpc.account.GetAccountResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetAccount"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.pm.grpc.account.GetAccountRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.pm.grpc.account.GetAccountResponse.getDefaultInstance()))
              .setSchemaDescriptor(new AccountServiceMethodDescriptorSupplier("GetAccount"))
              .build();
        }
      }
    }
    return getGetAccountMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.pm.grpc.account.GetAccountsByCustomerRequest,
      com.pm.grpc.account.GetAccountsByCustomerResponse> getGetAccountsByCustomerMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetAccountsByCustomer",
      requestType = com.pm.grpc.account.GetAccountsByCustomerRequest.class,
      responseType = com.pm.grpc.account.GetAccountsByCustomerResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.pm.grpc.account.GetAccountsByCustomerRequest,
      com.pm.grpc.account.GetAccountsByCustomerResponse> getGetAccountsByCustomerMethod() {
    io.grpc.MethodDescriptor<com.pm.grpc.account.GetAccountsByCustomerRequest, com.pm.grpc.account.GetAccountsByCustomerResponse> getGetAccountsByCustomerMethod;
    if ((getGetAccountsByCustomerMethod = AccountServiceGrpc.getGetAccountsByCustomerMethod) == null) {
      synchronized (AccountServiceGrpc.class) {
        if ((getGetAccountsByCustomerMethod = AccountServiceGrpc.getGetAccountsByCustomerMethod) == null) {
          AccountServiceGrpc.getGetAccountsByCustomerMethod = getGetAccountsByCustomerMethod =
              io.grpc.MethodDescriptor.<com.pm.grpc.account.GetAccountsByCustomerRequest, com.pm.grpc.account.GetAccountsByCustomerResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetAccountsByCustomer"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.pm.grpc.account.GetAccountsByCustomerRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.pm.grpc.account.GetAccountsByCustomerResponse.getDefaultInstance()))
              .setSchemaDescriptor(new AccountServiceMethodDescriptorSupplier("GetAccountsByCustomer"))
              .build();
        }
      }
    }
    return getGetAccountsByCustomerMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.pm.grpc.account.UpdateAccountStatusRequest,
      com.pm.grpc.account.UpdateAccountStatusResponse> getUpdateAccountStatusMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateAccountStatus",
      requestType = com.pm.grpc.account.UpdateAccountStatusRequest.class,
      responseType = com.pm.grpc.account.UpdateAccountStatusResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.pm.grpc.account.UpdateAccountStatusRequest,
      com.pm.grpc.account.UpdateAccountStatusResponse> getUpdateAccountStatusMethod() {
    io.grpc.MethodDescriptor<com.pm.grpc.account.UpdateAccountStatusRequest, com.pm.grpc.account.UpdateAccountStatusResponse> getUpdateAccountStatusMethod;
    if ((getUpdateAccountStatusMethod = AccountServiceGrpc.getUpdateAccountStatusMethod) == null) {
      synchronized (AccountServiceGrpc.class) {
        if ((getUpdateAccountStatusMethod = AccountServiceGrpc.getUpdateAccountStatusMethod) == null) {
          AccountServiceGrpc.getUpdateAccountStatusMethod = getUpdateAccountStatusMethod =
              io.grpc.MethodDescriptor.<com.pm.grpc.account.UpdateAccountStatusRequest, com.pm.grpc.account.UpdateAccountStatusResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateAccountStatus"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.pm.grpc.account.UpdateAccountStatusRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.pm.grpc.account.UpdateAccountStatusResponse.getDefaultInstance()))
              .setSchemaDescriptor(new AccountServiceMethodDescriptorSupplier("UpdateAccountStatus"))
              .build();
        }
      }
    }
    return getUpdateAccountStatusMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.pm.grpc.account.GetAccountBalanceRequest,
      com.pm.grpc.account.GetAccountBalanceResponse> getGetAccountBalanceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetAccountBalance",
      requestType = com.pm.grpc.account.GetAccountBalanceRequest.class,
      responseType = com.pm.grpc.account.GetAccountBalanceResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.pm.grpc.account.GetAccountBalanceRequest,
      com.pm.grpc.account.GetAccountBalanceResponse> getGetAccountBalanceMethod() {
    io.grpc.MethodDescriptor<com.pm.grpc.account.GetAccountBalanceRequest, com.pm.grpc.account.GetAccountBalanceResponse> getGetAccountBalanceMethod;
    if ((getGetAccountBalanceMethod = AccountServiceGrpc.getGetAccountBalanceMethod) == null) {
      synchronized (AccountServiceGrpc.class) {
        if ((getGetAccountBalanceMethod = AccountServiceGrpc.getGetAccountBalanceMethod) == null) {
          AccountServiceGrpc.getGetAccountBalanceMethod = getGetAccountBalanceMethod =
              io.grpc.MethodDescriptor.<com.pm.grpc.account.GetAccountBalanceRequest, com.pm.grpc.account.GetAccountBalanceResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetAccountBalance"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.pm.grpc.account.GetAccountBalanceRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.pm.grpc.account.GetAccountBalanceResponse.getDefaultInstance()))
              .setSchemaDescriptor(new AccountServiceMethodDescriptorSupplier("GetAccountBalance"))
              .build();
        }
      }
    }
    return getGetAccountBalanceMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.pm.grpc.account.ValidateCustomerRequest,
      com.pm.grpc.account.ValidateCustomerResponse> getValidateCustomerMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ValidateCustomer",
      requestType = com.pm.grpc.account.ValidateCustomerRequest.class,
      responseType = com.pm.grpc.account.ValidateCustomerResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.pm.grpc.account.ValidateCustomerRequest,
      com.pm.grpc.account.ValidateCustomerResponse> getValidateCustomerMethod() {
    io.grpc.MethodDescriptor<com.pm.grpc.account.ValidateCustomerRequest, com.pm.grpc.account.ValidateCustomerResponse> getValidateCustomerMethod;
    if ((getValidateCustomerMethod = AccountServiceGrpc.getValidateCustomerMethod) == null) {
      synchronized (AccountServiceGrpc.class) {
        if ((getValidateCustomerMethod = AccountServiceGrpc.getValidateCustomerMethod) == null) {
          AccountServiceGrpc.getValidateCustomerMethod = getValidateCustomerMethod =
              io.grpc.MethodDescriptor.<com.pm.grpc.account.ValidateCustomerRequest, com.pm.grpc.account.ValidateCustomerResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ValidateCustomer"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.pm.grpc.account.ValidateCustomerRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.pm.grpc.account.ValidateCustomerResponse.getDefaultInstance()))
              .setSchemaDescriptor(new AccountServiceMethodDescriptorSupplier("ValidateCustomer"))
              .build();
        }
      }
    }
    return getValidateCustomerMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.pm.grpc.account.UpdateAccountBalanceRequest,
      com.pm.grpc.account.UpdateAccountBalanceResponse> getUpdateAccountBalanceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateAccountBalance",
      requestType = com.pm.grpc.account.UpdateAccountBalanceRequest.class,
      responseType = com.pm.grpc.account.UpdateAccountBalanceResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.pm.grpc.account.UpdateAccountBalanceRequest,
      com.pm.grpc.account.UpdateAccountBalanceResponse> getUpdateAccountBalanceMethod() {
    io.grpc.MethodDescriptor<com.pm.grpc.account.UpdateAccountBalanceRequest, com.pm.grpc.account.UpdateAccountBalanceResponse> getUpdateAccountBalanceMethod;
    if ((getUpdateAccountBalanceMethod = AccountServiceGrpc.getUpdateAccountBalanceMethod) == null) {
      synchronized (AccountServiceGrpc.class) {
        if ((getUpdateAccountBalanceMethod = AccountServiceGrpc.getUpdateAccountBalanceMethod) == null) {
          AccountServiceGrpc.getUpdateAccountBalanceMethod = getUpdateAccountBalanceMethod =
              io.grpc.MethodDescriptor.<com.pm.grpc.account.UpdateAccountBalanceRequest, com.pm.grpc.account.UpdateAccountBalanceResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateAccountBalance"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.pm.grpc.account.UpdateAccountBalanceRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.pm.grpc.account.UpdateAccountBalanceResponse.getDefaultInstance()))
              .setSchemaDescriptor(new AccountServiceMethodDescriptorSupplier("UpdateAccountBalance"))
              .build();
        }
      }
    }
    return getUpdateAccountBalanceMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static AccountServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AccountServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<AccountServiceStub>() {
        @java.lang.Override
        public AccountServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new AccountServiceStub(channel, callOptions);
        }
      };
    return AccountServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static AccountServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AccountServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<AccountServiceBlockingStub>() {
        @java.lang.Override
        public AccountServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new AccountServiceBlockingStub(channel, callOptions);
        }
      };
    return AccountServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static AccountServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AccountServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<AccountServiceFutureStub>() {
        @java.lang.Override
        public AccountServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new AccountServiceFutureStub(channel, callOptions);
        }
      };
    return AccountServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public interface AsyncService {

    /**
     */
    default void createAccount(com.pm.grpc.account.CreateAccountRequest request,
        io.grpc.stub.StreamObserver<com.pm.grpc.account.CreateAccountResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreateAccountMethod(), responseObserver);
    }

    /**
     */
    default void getAccount(com.pm.grpc.account.GetAccountRequest request,
        io.grpc.stub.StreamObserver<com.pm.grpc.account.GetAccountResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetAccountMethod(), responseObserver);
    }

    /**
     */
    default void getAccountsByCustomer(com.pm.grpc.account.GetAccountsByCustomerRequest request,
        io.grpc.stub.StreamObserver<com.pm.grpc.account.GetAccountsByCustomerResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetAccountsByCustomerMethod(), responseObserver);
    }

    /**
     */
    default void updateAccountStatus(com.pm.grpc.account.UpdateAccountStatusRequest request,
        io.grpc.stub.StreamObserver<com.pm.grpc.account.UpdateAccountStatusResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUpdateAccountStatusMethod(), responseObserver);
    }

    /**
     */
    default void getAccountBalance(com.pm.grpc.account.GetAccountBalanceRequest request,
        io.grpc.stub.StreamObserver<com.pm.grpc.account.GetAccountBalanceResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetAccountBalanceMethod(), responseObserver);
    }

    /**
     */
    default void validateCustomer(com.pm.grpc.account.ValidateCustomerRequest request,
        io.grpc.stub.StreamObserver<com.pm.grpc.account.ValidateCustomerResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getValidateCustomerMethod(), responseObserver);
    }

    /**
     * <pre>
     * NEW: Add balance update method for transactions
     * </pre>
     */
    default void updateAccountBalance(com.pm.grpc.account.UpdateAccountBalanceRequest request,
        io.grpc.stub.StreamObserver<com.pm.grpc.account.UpdateAccountBalanceResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUpdateAccountBalanceMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service AccountService.
   */
  public static abstract class AccountServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return AccountServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service AccountService.
   */
  public static final class AccountServiceStub
      extends io.grpc.stub.AbstractAsyncStub<AccountServiceStub> {
    private AccountServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AccountServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AccountServiceStub(channel, callOptions);
    }

    /**
     */
    public void createAccount(com.pm.grpc.account.CreateAccountRequest request,
        io.grpc.stub.StreamObserver<com.pm.grpc.account.CreateAccountResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateAccountMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getAccount(com.pm.grpc.account.GetAccountRequest request,
        io.grpc.stub.StreamObserver<com.pm.grpc.account.GetAccountResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetAccountMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getAccountsByCustomer(com.pm.grpc.account.GetAccountsByCustomerRequest request,
        io.grpc.stub.StreamObserver<com.pm.grpc.account.GetAccountsByCustomerResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetAccountsByCustomerMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void updateAccountStatus(com.pm.grpc.account.UpdateAccountStatusRequest request,
        io.grpc.stub.StreamObserver<com.pm.grpc.account.UpdateAccountStatusResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateAccountStatusMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getAccountBalance(com.pm.grpc.account.GetAccountBalanceRequest request,
        io.grpc.stub.StreamObserver<com.pm.grpc.account.GetAccountBalanceResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetAccountBalanceMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void validateCustomer(com.pm.grpc.account.ValidateCustomerRequest request,
        io.grpc.stub.StreamObserver<com.pm.grpc.account.ValidateCustomerResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getValidateCustomerMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * NEW: Add balance update method for transactions
     * </pre>
     */
    public void updateAccountBalance(com.pm.grpc.account.UpdateAccountBalanceRequest request,
        io.grpc.stub.StreamObserver<com.pm.grpc.account.UpdateAccountBalanceResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateAccountBalanceMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service AccountService.
   */
  public static final class AccountServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<AccountServiceBlockingStub> {
    private AccountServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AccountServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AccountServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.pm.grpc.account.CreateAccountResponse createAccount(com.pm.grpc.account.CreateAccountRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateAccountMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.pm.grpc.account.GetAccountResponse getAccount(com.pm.grpc.account.GetAccountRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetAccountMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.pm.grpc.account.GetAccountsByCustomerResponse getAccountsByCustomer(com.pm.grpc.account.GetAccountsByCustomerRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetAccountsByCustomerMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.pm.grpc.account.UpdateAccountStatusResponse updateAccountStatus(com.pm.grpc.account.UpdateAccountStatusRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateAccountStatusMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.pm.grpc.account.GetAccountBalanceResponse getAccountBalance(com.pm.grpc.account.GetAccountBalanceRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetAccountBalanceMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.pm.grpc.account.ValidateCustomerResponse validateCustomer(com.pm.grpc.account.ValidateCustomerRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getValidateCustomerMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * NEW: Add balance update method for transactions
     * </pre>
     */
    public com.pm.grpc.account.UpdateAccountBalanceResponse updateAccountBalance(com.pm.grpc.account.UpdateAccountBalanceRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateAccountBalanceMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service AccountService.
   */
  public static final class AccountServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<AccountServiceFutureStub> {
    private AccountServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AccountServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AccountServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.pm.grpc.account.CreateAccountResponse> createAccount(
        com.pm.grpc.account.CreateAccountRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateAccountMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.pm.grpc.account.GetAccountResponse> getAccount(
        com.pm.grpc.account.GetAccountRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetAccountMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.pm.grpc.account.GetAccountsByCustomerResponse> getAccountsByCustomer(
        com.pm.grpc.account.GetAccountsByCustomerRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetAccountsByCustomerMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.pm.grpc.account.UpdateAccountStatusResponse> updateAccountStatus(
        com.pm.grpc.account.UpdateAccountStatusRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateAccountStatusMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.pm.grpc.account.GetAccountBalanceResponse> getAccountBalance(
        com.pm.grpc.account.GetAccountBalanceRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetAccountBalanceMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.pm.grpc.account.ValidateCustomerResponse> validateCustomer(
        com.pm.grpc.account.ValidateCustomerRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getValidateCustomerMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * NEW: Add balance update method for transactions
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.pm.grpc.account.UpdateAccountBalanceResponse> updateAccountBalance(
        com.pm.grpc.account.UpdateAccountBalanceRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateAccountBalanceMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_ACCOUNT = 0;
  private static final int METHODID_GET_ACCOUNT = 1;
  private static final int METHODID_GET_ACCOUNTS_BY_CUSTOMER = 2;
  private static final int METHODID_UPDATE_ACCOUNT_STATUS = 3;
  private static final int METHODID_GET_ACCOUNT_BALANCE = 4;
  private static final int METHODID_VALIDATE_CUSTOMER = 5;
  private static final int METHODID_UPDATE_ACCOUNT_BALANCE = 6;

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
        case METHODID_CREATE_ACCOUNT:
          serviceImpl.createAccount((com.pm.grpc.account.CreateAccountRequest) request,
              (io.grpc.stub.StreamObserver<com.pm.grpc.account.CreateAccountResponse>) responseObserver);
          break;
        case METHODID_GET_ACCOUNT:
          serviceImpl.getAccount((com.pm.grpc.account.GetAccountRequest) request,
              (io.grpc.stub.StreamObserver<com.pm.grpc.account.GetAccountResponse>) responseObserver);
          break;
        case METHODID_GET_ACCOUNTS_BY_CUSTOMER:
          serviceImpl.getAccountsByCustomer((com.pm.grpc.account.GetAccountsByCustomerRequest) request,
              (io.grpc.stub.StreamObserver<com.pm.grpc.account.GetAccountsByCustomerResponse>) responseObserver);
          break;
        case METHODID_UPDATE_ACCOUNT_STATUS:
          serviceImpl.updateAccountStatus((com.pm.grpc.account.UpdateAccountStatusRequest) request,
              (io.grpc.stub.StreamObserver<com.pm.grpc.account.UpdateAccountStatusResponse>) responseObserver);
          break;
        case METHODID_GET_ACCOUNT_BALANCE:
          serviceImpl.getAccountBalance((com.pm.grpc.account.GetAccountBalanceRequest) request,
              (io.grpc.stub.StreamObserver<com.pm.grpc.account.GetAccountBalanceResponse>) responseObserver);
          break;
        case METHODID_VALIDATE_CUSTOMER:
          serviceImpl.validateCustomer((com.pm.grpc.account.ValidateCustomerRequest) request,
              (io.grpc.stub.StreamObserver<com.pm.grpc.account.ValidateCustomerResponse>) responseObserver);
          break;
        case METHODID_UPDATE_ACCOUNT_BALANCE:
          serviceImpl.updateAccountBalance((com.pm.grpc.account.UpdateAccountBalanceRequest) request,
              (io.grpc.stub.StreamObserver<com.pm.grpc.account.UpdateAccountBalanceResponse>) responseObserver);
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
          getCreateAccountMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.pm.grpc.account.CreateAccountRequest,
              com.pm.grpc.account.CreateAccountResponse>(
                service, METHODID_CREATE_ACCOUNT)))
        .addMethod(
          getGetAccountMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.pm.grpc.account.GetAccountRequest,
              com.pm.grpc.account.GetAccountResponse>(
                service, METHODID_GET_ACCOUNT)))
        .addMethod(
          getGetAccountsByCustomerMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.pm.grpc.account.GetAccountsByCustomerRequest,
              com.pm.grpc.account.GetAccountsByCustomerResponse>(
                service, METHODID_GET_ACCOUNTS_BY_CUSTOMER)))
        .addMethod(
          getUpdateAccountStatusMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.pm.grpc.account.UpdateAccountStatusRequest,
              com.pm.grpc.account.UpdateAccountStatusResponse>(
                service, METHODID_UPDATE_ACCOUNT_STATUS)))
        .addMethod(
          getGetAccountBalanceMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.pm.grpc.account.GetAccountBalanceRequest,
              com.pm.grpc.account.GetAccountBalanceResponse>(
                service, METHODID_GET_ACCOUNT_BALANCE)))
        .addMethod(
          getValidateCustomerMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.pm.grpc.account.ValidateCustomerRequest,
              com.pm.grpc.account.ValidateCustomerResponse>(
                service, METHODID_VALIDATE_CUSTOMER)))
        .addMethod(
          getUpdateAccountBalanceMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.pm.grpc.account.UpdateAccountBalanceRequest,
              com.pm.grpc.account.UpdateAccountBalanceResponse>(
                service, METHODID_UPDATE_ACCOUNT_BALANCE)))
        .build();
  }

  private static abstract class AccountServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    AccountServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.pm.grpc.account.AccountServiceOuterClass.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("AccountService");
    }
  }

  private static final class AccountServiceFileDescriptorSupplier
      extends AccountServiceBaseDescriptorSupplier {
    AccountServiceFileDescriptorSupplier() {}
  }

  private static final class AccountServiceMethodDescriptorSupplier
      extends AccountServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    AccountServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (AccountServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new AccountServiceFileDescriptorSupplier())
              .addMethod(getCreateAccountMethod())
              .addMethod(getGetAccountMethod())
              .addMethod(getGetAccountsByCustomerMethod())
              .addMethod(getUpdateAccountStatusMethod())
              .addMethod(getGetAccountBalanceMethod())
              .addMethod(getValidateCustomerMethod())
              .addMethod(getUpdateAccountBalanceMethod())
              .build();
        }
      }
    }
    return result;
  }
}
