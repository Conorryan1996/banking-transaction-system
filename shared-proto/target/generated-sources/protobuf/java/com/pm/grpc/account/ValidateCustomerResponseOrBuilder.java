// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: account_service.proto

package com.pm.grpc.account;

public interface ValidateCustomerResponseOrBuilder extends
    // @@protoc_insertion_point(interface_extends:account.ValidateCustomerResponse)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>bool exists = 1;</code>
   * @return The exists.
   */
  boolean getExists();

  /**
   * <code>string customer_name = 2;</code>
   * @return The customerName.
   */
  java.lang.String getCustomerName();
  /**
   * <code>string customer_name = 2;</code>
   * @return The bytes for customerName.
   */
  com.google.protobuf.ByteString
      getCustomerNameBytes();

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
