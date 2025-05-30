// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: customer_service.proto

package com.pm.grpc.customer;

public interface DefaultAccountInfoOrBuilder extends
    // @@protoc_insertion_point(interface_extends:customer.DefaultAccountInfo)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>string account_id = 1;</code>
   * @return The accountId.
   */
  java.lang.String getAccountId();
  /**
   * <code>string account_id = 1;</code>
   * @return The bytes for accountId.
   */
  com.google.protobuf.ByteString
      getAccountIdBytes();

  /**
   * <code>string account_number = 2;</code>
   * @return The accountNumber.
   */
  java.lang.String getAccountNumber();
  /**
   * <code>string account_number = 2;</code>
   * @return The bytes for accountNumber.
   */
  com.google.protobuf.ByteString
      getAccountNumberBytes();

  /**
   * <code>.common.AccountType account_type = 3;</code>
   * @return The enum numeric value on the wire for accountType.
   */
  int getAccountTypeValue();
  /**
   * <code>.common.AccountType account_type = 3;</code>
   * @return The accountType.
   */
  com.pm.grpc.common.AccountType getAccountType();

  /**
   * <code>string balance = 4;</code>
   * @return The balance.
   */
  java.lang.String getBalance();
  /**
   * <code>string balance = 4;</code>
   * @return The bytes for balance.
   */
  com.google.protobuf.ByteString
      getBalanceBytes();
}
