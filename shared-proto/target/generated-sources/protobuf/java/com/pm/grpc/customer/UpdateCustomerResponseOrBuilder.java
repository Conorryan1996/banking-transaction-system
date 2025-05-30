// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: customer_service.proto

package com.pm.grpc.customer;

public interface UpdateCustomerResponseOrBuilder extends
    // @@protoc_insertion_point(interface_extends:customer.UpdateCustomerResponse)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>string customer_id = 1;</code>
   * @return The customerId.
   */
  java.lang.String getCustomerId();
  /**
   * <code>string customer_id = 1;</code>
   * @return The bytes for customerId.
   */
  com.google.protobuf.ByteString
      getCustomerIdBytes();

  /**
   * <code>string first_name = 2;</code>
   * @return The firstName.
   */
  java.lang.String getFirstName();
  /**
   * <code>string first_name = 2;</code>
   * @return The bytes for firstName.
   */
  com.google.protobuf.ByteString
      getFirstNameBytes();

  /**
   * <code>string last_name = 3;</code>
   * @return The lastName.
   */
  java.lang.String getLastName();
  /**
   * <code>string last_name = 3;</code>
   * @return The bytes for lastName.
   */
  com.google.protobuf.ByteString
      getLastNameBytes();

  /**
   * <code>string email = 4;</code>
   * @return The email.
   */
  java.lang.String getEmail();
  /**
   * <code>string email = 4;</code>
   * @return The bytes for email.
   */
  com.google.protobuf.ByteString
      getEmailBytes();

  /**
   * <code>string phone = 5;</code>
   * @return The phone.
   */
  java.lang.String getPhone();
  /**
   * <code>string phone = 5;</code>
   * @return The bytes for phone.
   */
  com.google.protobuf.ByteString
      getPhoneBytes();

  /**
   * <code>string last_modified_date = 6;</code>
   * @return The lastModifiedDate.
   */
  java.lang.String getLastModifiedDate();
  /**
   * <code>string last_modified_date = 6;</code>
   * @return The bytes for lastModifiedDate.
   */
  com.google.protobuf.ByteString
      getLastModifiedDateBytes();

  /**
   * <code>.common.ServiceResponse service_response = 7;</code>
   * @return Whether the serviceResponse field is set.
   */
  boolean hasServiceResponse();
  /**
   * <code>.common.ServiceResponse service_response = 7;</code>
   * @return The serviceResponse.
   */
  com.pm.grpc.common.ServiceResponse getServiceResponse();
  /**
   * <code>.common.ServiceResponse service_response = 7;</code>
   */
  com.pm.grpc.common.ServiceResponseOrBuilder getServiceResponseOrBuilder();
}
