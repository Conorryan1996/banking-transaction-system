// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: transaction_service.proto

package com.pm.grpc.transaction;

public interface GetTransactionsByCustomerResponseOrBuilder extends
    // @@protoc_insertion_point(interface_extends:transaction.GetTransactionsByCustomerResponse)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>repeated .transaction.GetTransactionResponse transactions = 1;</code>
   */
  java.util.List<com.pm.grpc.transaction.GetTransactionResponse> 
      getTransactionsList();
  /**
   * <code>repeated .transaction.GetTransactionResponse transactions = 1;</code>
   */
  com.pm.grpc.transaction.GetTransactionResponse getTransactions(int index);
  /**
   * <code>repeated .transaction.GetTransactionResponse transactions = 1;</code>
   */
  int getTransactionsCount();
  /**
   * <code>repeated .transaction.GetTransactionResponse transactions = 1;</code>
   */
  java.util.List<? extends com.pm.grpc.transaction.GetTransactionResponseOrBuilder> 
      getTransactionsOrBuilderList();
  /**
   * <code>repeated .transaction.GetTransactionResponse transactions = 1;</code>
   */
  com.pm.grpc.transaction.GetTransactionResponseOrBuilder getTransactionsOrBuilder(
      int index);

  /**
   * <code>int32 total_count = 2;</code>
   * @return The totalCount.
   */
  int getTotalCount();

  /**
   * <code>.common.ServiceResponse service_response = 3;</code>
   * @return Whether the serviceResponse field is set.
   */
  boolean hasServiceResponse();
  /**
   * <code>.common.ServiceResponse service_response = 3;</code>
   * @return The serviceResponse.
   */
  com.pm.grpc.common.ServiceResponse getServiceResponse();
  /**
   * <code>.common.ServiceResponse service_response = 3;</code>
   */
  com.pm.grpc.common.ServiceResponseOrBuilder getServiceResponseOrBuilder();
}
