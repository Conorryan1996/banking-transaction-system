// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: common.proto

package com.pm.grpc.common;

public interface ServiceResponseOrBuilder extends
    // @@protoc_insertion_point(interface_extends:common.ServiceResponse)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>bool success = 1;</code>
   * @return The success.
   */
  boolean getSuccess();

  /**
   * <code>string message = 2;</code>
   * @return The message.
   */
  java.lang.String getMessage();
  /**
   * <code>string message = 2;</code>
   * @return The bytes for message.
   */
  com.google.protobuf.ByteString
      getMessageBytes();

  /**
   * <code>string error_code = 3;</code>
   * @return The errorCode.
   */
  java.lang.String getErrorCode();
  /**
   * <code>string error_code = 3;</code>
   * @return The bytes for errorCode.
   */
  com.google.protobuf.ByteString
      getErrorCodeBytes();
}
