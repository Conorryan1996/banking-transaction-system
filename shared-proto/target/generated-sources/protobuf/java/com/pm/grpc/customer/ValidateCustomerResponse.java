// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: customer_service.proto

package com.pm.grpc.customer;

/**
 * Protobuf type {@code customer.ValidateCustomerResponse}
 */
public final class ValidateCustomerResponse extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:customer.ValidateCustomerResponse)
    ValidateCustomerResponseOrBuilder {
private static final long serialVersionUID = 0L;
  // Use ValidateCustomerResponse.newBuilder() to construct.
  private ValidateCustomerResponse(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private ValidateCustomerResponse() {
    fullName_ = "";
    status_ = 0;
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new ValidateCustomerResponse();
  }

  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return com.pm.grpc.customer.CustomerServiceOuterClass.internal_static_customer_ValidateCustomerResponse_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.pm.grpc.customer.CustomerServiceOuterClass.internal_static_customer_ValidateCustomerResponse_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.pm.grpc.customer.ValidateCustomerResponse.class, com.pm.grpc.customer.ValidateCustomerResponse.Builder.class);
  }

  private int bitField0_;
  public static final int EXISTS_FIELD_NUMBER = 1;
  private boolean exists_ = false;
  /**
   * <code>bool exists = 1;</code>
   * @return The exists.
   */
  @java.lang.Override
  public boolean getExists() {
    return exists_;
  }

  public static final int FULL_NAME_FIELD_NUMBER = 2;
  @SuppressWarnings("serial")
  private volatile java.lang.Object fullName_ = "";
  /**
   * <code>string full_name = 2;</code>
   * @return The fullName.
   */
  @java.lang.Override
  public java.lang.String getFullName() {
    java.lang.Object ref = fullName_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      fullName_ = s;
      return s;
    }
  }
  /**
   * <code>string full_name = 2;</code>
   * @return The bytes for fullName.
   */
  @java.lang.Override
  public com.google.protobuf.ByteString
      getFullNameBytes() {
    java.lang.Object ref = fullName_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      fullName_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int STATUS_FIELD_NUMBER = 3;
  private int status_ = 0;
  /**
   * <code>.common.CustomerStatus status = 3;</code>
   * @return The enum numeric value on the wire for status.
   */
  @java.lang.Override public int getStatusValue() {
    return status_;
  }
  /**
   * <code>.common.CustomerStatus status = 3;</code>
   * @return The status.
   */
  @java.lang.Override public com.pm.grpc.common.CustomerStatus getStatus() {
    com.pm.grpc.common.CustomerStatus result = com.pm.grpc.common.CustomerStatus.forNumber(status_);
    return result == null ? com.pm.grpc.common.CustomerStatus.UNRECOGNIZED : result;
  }

  public static final int SERVICE_RESPONSE_FIELD_NUMBER = 4;
  private com.pm.grpc.common.ServiceResponse serviceResponse_;
  /**
   * <code>.common.ServiceResponse service_response = 4;</code>
   * @return Whether the serviceResponse field is set.
   */
  @java.lang.Override
  public boolean hasServiceResponse() {
    return ((bitField0_ & 0x00000001) != 0);
  }
  /**
   * <code>.common.ServiceResponse service_response = 4;</code>
   * @return The serviceResponse.
   */
  @java.lang.Override
  public com.pm.grpc.common.ServiceResponse getServiceResponse() {
    return serviceResponse_ == null ? com.pm.grpc.common.ServiceResponse.getDefaultInstance() : serviceResponse_;
  }
  /**
   * <code>.common.ServiceResponse service_response = 4;</code>
   */
  @java.lang.Override
  public com.pm.grpc.common.ServiceResponseOrBuilder getServiceResponseOrBuilder() {
    return serviceResponse_ == null ? com.pm.grpc.common.ServiceResponse.getDefaultInstance() : serviceResponse_;
  }

  private byte memoizedIsInitialized = -1;
  @java.lang.Override
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  @java.lang.Override
  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (exists_ != false) {
      output.writeBool(1, exists_);
    }
    if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(fullName_)) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 2, fullName_);
    }
    if (status_ != com.pm.grpc.common.CustomerStatus.CUSTOMER_STATUS_UNSPECIFIED.getNumber()) {
      output.writeEnum(3, status_);
    }
    if (((bitField0_ & 0x00000001) != 0)) {
      output.writeMessage(4, getServiceResponse());
    }
    getUnknownFields().writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (exists_ != false) {
      size += com.google.protobuf.CodedOutputStream
        .computeBoolSize(1, exists_);
    }
    if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(fullName_)) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(2, fullName_);
    }
    if (status_ != com.pm.grpc.common.CustomerStatus.CUSTOMER_STATUS_UNSPECIFIED.getNumber()) {
      size += com.google.protobuf.CodedOutputStream
        .computeEnumSize(3, status_);
    }
    if (((bitField0_ & 0x00000001) != 0)) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(4, getServiceResponse());
    }
    size += getUnknownFields().getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof com.pm.grpc.customer.ValidateCustomerResponse)) {
      return super.equals(obj);
    }
    com.pm.grpc.customer.ValidateCustomerResponse other = (com.pm.grpc.customer.ValidateCustomerResponse) obj;

    if (getExists()
        != other.getExists()) return false;
    if (!getFullName()
        .equals(other.getFullName())) return false;
    if (status_ != other.status_) return false;
    if (hasServiceResponse() != other.hasServiceResponse()) return false;
    if (hasServiceResponse()) {
      if (!getServiceResponse()
          .equals(other.getServiceResponse())) return false;
    }
    if (!getUnknownFields().equals(other.getUnknownFields())) return false;
    return true;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    hash = (37 * hash) + EXISTS_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashBoolean(
        getExists());
    hash = (37 * hash) + FULL_NAME_FIELD_NUMBER;
    hash = (53 * hash) + getFullName().hashCode();
    hash = (37 * hash) + STATUS_FIELD_NUMBER;
    hash = (53 * hash) + status_;
    if (hasServiceResponse()) {
      hash = (37 * hash) + SERVICE_RESPONSE_FIELD_NUMBER;
      hash = (53 * hash) + getServiceResponse().hashCode();
    }
    hash = (29 * hash) + getUnknownFields().hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.pm.grpc.customer.ValidateCustomerResponse parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.pm.grpc.customer.ValidateCustomerResponse parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.pm.grpc.customer.ValidateCustomerResponse parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.pm.grpc.customer.ValidateCustomerResponse parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.pm.grpc.customer.ValidateCustomerResponse parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.pm.grpc.customer.ValidateCustomerResponse parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.pm.grpc.customer.ValidateCustomerResponse parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.pm.grpc.customer.ValidateCustomerResponse parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  public static com.pm.grpc.customer.ValidateCustomerResponse parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }

  public static com.pm.grpc.customer.ValidateCustomerResponse parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.pm.grpc.customer.ValidateCustomerResponse parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.pm.grpc.customer.ValidateCustomerResponse parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  @java.lang.Override
  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(com.pm.grpc.customer.ValidateCustomerResponse prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  @java.lang.Override
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * Protobuf type {@code customer.ValidateCustomerResponse}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:customer.ValidateCustomerResponse)
      com.pm.grpc.customer.ValidateCustomerResponseOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.pm.grpc.customer.CustomerServiceOuterClass.internal_static_customer_ValidateCustomerResponse_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.pm.grpc.customer.CustomerServiceOuterClass.internal_static_customer_ValidateCustomerResponse_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.pm.grpc.customer.ValidateCustomerResponse.class, com.pm.grpc.customer.ValidateCustomerResponse.Builder.class);
    }

    // Construct using com.pm.grpc.customer.ValidateCustomerResponse.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }
    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessageV3
              .alwaysUseFieldBuilders) {
        getServiceResponseFieldBuilder();
      }
    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      bitField0_ = 0;
      exists_ = false;
      fullName_ = "";
      status_ = 0;
      serviceResponse_ = null;
      if (serviceResponseBuilder_ != null) {
        serviceResponseBuilder_.dispose();
        serviceResponseBuilder_ = null;
      }
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.pm.grpc.customer.CustomerServiceOuterClass.internal_static_customer_ValidateCustomerResponse_descriptor;
    }

    @java.lang.Override
    public com.pm.grpc.customer.ValidateCustomerResponse getDefaultInstanceForType() {
      return com.pm.grpc.customer.ValidateCustomerResponse.getDefaultInstance();
    }

    @java.lang.Override
    public com.pm.grpc.customer.ValidateCustomerResponse build() {
      com.pm.grpc.customer.ValidateCustomerResponse result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public com.pm.grpc.customer.ValidateCustomerResponse buildPartial() {
      com.pm.grpc.customer.ValidateCustomerResponse result = new com.pm.grpc.customer.ValidateCustomerResponse(this);
      if (bitField0_ != 0) { buildPartial0(result); }
      onBuilt();
      return result;
    }

    private void buildPartial0(com.pm.grpc.customer.ValidateCustomerResponse result) {
      int from_bitField0_ = bitField0_;
      if (((from_bitField0_ & 0x00000001) != 0)) {
        result.exists_ = exists_;
      }
      if (((from_bitField0_ & 0x00000002) != 0)) {
        result.fullName_ = fullName_;
      }
      if (((from_bitField0_ & 0x00000004) != 0)) {
        result.status_ = status_;
      }
      int to_bitField0_ = 0;
      if (((from_bitField0_ & 0x00000008) != 0)) {
        result.serviceResponse_ = serviceResponseBuilder_ == null
            ? serviceResponse_
            : serviceResponseBuilder_.build();
        to_bitField0_ |= 0x00000001;
      }
      result.bitField0_ |= to_bitField0_;
    }

    @java.lang.Override
    public Builder clone() {
      return super.clone();
    }
    @java.lang.Override
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return super.setField(field, value);
    }
    @java.lang.Override
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return super.clearField(field);
    }
    @java.lang.Override
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return super.clearOneof(oneof);
    }
    @java.lang.Override
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, java.lang.Object value) {
      return super.setRepeatedField(field, index, value);
    }
    @java.lang.Override
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return super.addRepeatedField(field, value);
    }
    @java.lang.Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof com.pm.grpc.customer.ValidateCustomerResponse) {
        return mergeFrom((com.pm.grpc.customer.ValidateCustomerResponse)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.pm.grpc.customer.ValidateCustomerResponse other) {
      if (other == com.pm.grpc.customer.ValidateCustomerResponse.getDefaultInstance()) return this;
      if (other.getExists() != false) {
        setExists(other.getExists());
      }
      if (!other.getFullName().isEmpty()) {
        fullName_ = other.fullName_;
        bitField0_ |= 0x00000002;
        onChanged();
      }
      if (other.status_ != 0) {
        setStatusValue(other.getStatusValue());
      }
      if (other.hasServiceResponse()) {
        mergeServiceResponse(other.getServiceResponse());
      }
      this.mergeUnknownFields(other.getUnknownFields());
      onChanged();
      return this;
    }

    @java.lang.Override
    public final boolean isInitialized() {
      return true;
    }

    @java.lang.Override
    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      if (extensionRegistry == null) {
        throw new java.lang.NullPointerException();
      }
      try {
        boolean done = false;
        while (!done) {
          int tag = input.readTag();
          switch (tag) {
            case 0:
              done = true;
              break;
            case 8: {
              exists_ = input.readBool();
              bitField0_ |= 0x00000001;
              break;
            } // case 8
            case 18: {
              fullName_ = input.readStringRequireUtf8();
              bitField0_ |= 0x00000002;
              break;
            } // case 18
            case 24: {
              status_ = input.readEnum();
              bitField0_ |= 0x00000004;
              break;
            } // case 24
            case 34: {
              input.readMessage(
                  getServiceResponseFieldBuilder().getBuilder(),
                  extensionRegistry);
              bitField0_ |= 0x00000008;
              break;
            } // case 34
            default: {
              if (!super.parseUnknownField(input, extensionRegistry, tag)) {
                done = true; // was an endgroup tag
              }
              break;
            } // default:
          } // switch (tag)
        } // while (!done)
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.unwrapIOException();
      } finally {
        onChanged();
      } // finally
      return this;
    }
    private int bitField0_;

    private boolean exists_ ;
    /**
     * <code>bool exists = 1;</code>
     * @return The exists.
     */
    @java.lang.Override
    public boolean getExists() {
      return exists_;
    }
    /**
     * <code>bool exists = 1;</code>
     * @param value The exists to set.
     * @return This builder for chaining.
     */
    public Builder setExists(boolean value) {

      exists_ = value;
      bitField0_ |= 0x00000001;
      onChanged();
      return this;
    }
    /**
     * <code>bool exists = 1;</code>
     * @return This builder for chaining.
     */
    public Builder clearExists() {
      bitField0_ = (bitField0_ & ~0x00000001);
      exists_ = false;
      onChanged();
      return this;
    }

    private java.lang.Object fullName_ = "";
    /**
     * <code>string full_name = 2;</code>
     * @return The fullName.
     */
    public java.lang.String getFullName() {
      java.lang.Object ref = fullName_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        fullName_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string full_name = 2;</code>
     * @return The bytes for fullName.
     */
    public com.google.protobuf.ByteString
        getFullNameBytes() {
      java.lang.Object ref = fullName_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        fullName_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string full_name = 2;</code>
     * @param value The fullName to set.
     * @return This builder for chaining.
     */
    public Builder setFullName(
        java.lang.String value) {
      if (value == null) { throw new NullPointerException(); }
      fullName_ = value;
      bitField0_ |= 0x00000002;
      onChanged();
      return this;
    }
    /**
     * <code>string full_name = 2;</code>
     * @return This builder for chaining.
     */
    public Builder clearFullName() {
      fullName_ = getDefaultInstance().getFullName();
      bitField0_ = (bitField0_ & ~0x00000002);
      onChanged();
      return this;
    }
    /**
     * <code>string full_name = 2;</code>
     * @param value The bytes for fullName to set.
     * @return This builder for chaining.
     */
    public Builder setFullNameBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) { throw new NullPointerException(); }
      checkByteStringIsUtf8(value);
      fullName_ = value;
      bitField0_ |= 0x00000002;
      onChanged();
      return this;
    }

    private int status_ = 0;
    /**
     * <code>.common.CustomerStatus status = 3;</code>
     * @return The enum numeric value on the wire for status.
     */
    @java.lang.Override public int getStatusValue() {
      return status_;
    }
    /**
     * <code>.common.CustomerStatus status = 3;</code>
     * @param value The enum numeric value on the wire for status to set.
     * @return This builder for chaining.
     */
    public Builder setStatusValue(int value) {
      status_ = value;
      bitField0_ |= 0x00000004;
      onChanged();
      return this;
    }
    /**
     * <code>.common.CustomerStatus status = 3;</code>
     * @return The status.
     */
    @java.lang.Override
    public com.pm.grpc.common.CustomerStatus getStatus() {
      com.pm.grpc.common.CustomerStatus result = com.pm.grpc.common.CustomerStatus.forNumber(status_);
      return result == null ? com.pm.grpc.common.CustomerStatus.UNRECOGNIZED : result;
    }
    /**
     * <code>.common.CustomerStatus status = 3;</code>
     * @param value The status to set.
     * @return This builder for chaining.
     */
    public Builder setStatus(com.pm.grpc.common.CustomerStatus value) {
      if (value == null) {
        throw new NullPointerException();
      }
      bitField0_ |= 0x00000004;
      status_ = value.getNumber();
      onChanged();
      return this;
    }
    /**
     * <code>.common.CustomerStatus status = 3;</code>
     * @return This builder for chaining.
     */
    public Builder clearStatus() {
      bitField0_ = (bitField0_ & ~0x00000004);
      status_ = 0;
      onChanged();
      return this;
    }

    private com.pm.grpc.common.ServiceResponse serviceResponse_;
    private com.google.protobuf.SingleFieldBuilderV3<
        com.pm.grpc.common.ServiceResponse, com.pm.grpc.common.ServiceResponse.Builder, com.pm.grpc.common.ServiceResponseOrBuilder> serviceResponseBuilder_;
    /**
     * <code>.common.ServiceResponse service_response = 4;</code>
     * @return Whether the serviceResponse field is set.
     */
    public boolean hasServiceResponse() {
      return ((bitField0_ & 0x00000008) != 0);
    }
    /**
     * <code>.common.ServiceResponse service_response = 4;</code>
     * @return The serviceResponse.
     */
    public com.pm.grpc.common.ServiceResponse getServiceResponse() {
      if (serviceResponseBuilder_ == null) {
        return serviceResponse_ == null ? com.pm.grpc.common.ServiceResponse.getDefaultInstance() : serviceResponse_;
      } else {
        return serviceResponseBuilder_.getMessage();
      }
    }
    /**
     * <code>.common.ServiceResponse service_response = 4;</code>
     */
    public Builder setServiceResponse(com.pm.grpc.common.ServiceResponse value) {
      if (serviceResponseBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        serviceResponse_ = value;
      } else {
        serviceResponseBuilder_.setMessage(value);
      }
      bitField0_ |= 0x00000008;
      onChanged();
      return this;
    }
    /**
     * <code>.common.ServiceResponse service_response = 4;</code>
     */
    public Builder setServiceResponse(
        com.pm.grpc.common.ServiceResponse.Builder builderForValue) {
      if (serviceResponseBuilder_ == null) {
        serviceResponse_ = builderForValue.build();
      } else {
        serviceResponseBuilder_.setMessage(builderForValue.build());
      }
      bitField0_ |= 0x00000008;
      onChanged();
      return this;
    }
    /**
     * <code>.common.ServiceResponse service_response = 4;</code>
     */
    public Builder mergeServiceResponse(com.pm.grpc.common.ServiceResponse value) {
      if (serviceResponseBuilder_ == null) {
        if (((bitField0_ & 0x00000008) != 0) &&
          serviceResponse_ != null &&
          serviceResponse_ != com.pm.grpc.common.ServiceResponse.getDefaultInstance()) {
          getServiceResponseBuilder().mergeFrom(value);
        } else {
          serviceResponse_ = value;
        }
      } else {
        serviceResponseBuilder_.mergeFrom(value);
      }
      if (serviceResponse_ != null) {
        bitField0_ |= 0x00000008;
        onChanged();
      }
      return this;
    }
    /**
     * <code>.common.ServiceResponse service_response = 4;</code>
     */
    public Builder clearServiceResponse() {
      bitField0_ = (bitField0_ & ~0x00000008);
      serviceResponse_ = null;
      if (serviceResponseBuilder_ != null) {
        serviceResponseBuilder_.dispose();
        serviceResponseBuilder_ = null;
      }
      onChanged();
      return this;
    }
    /**
     * <code>.common.ServiceResponse service_response = 4;</code>
     */
    public com.pm.grpc.common.ServiceResponse.Builder getServiceResponseBuilder() {
      bitField0_ |= 0x00000008;
      onChanged();
      return getServiceResponseFieldBuilder().getBuilder();
    }
    /**
     * <code>.common.ServiceResponse service_response = 4;</code>
     */
    public com.pm.grpc.common.ServiceResponseOrBuilder getServiceResponseOrBuilder() {
      if (serviceResponseBuilder_ != null) {
        return serviceResponseBuilder_.getMessageOrBuilder();
      } else {
        return serviceResponse_ == null ?
            com.pm.grpc.common.ServiceResponse.getDefaultInstance() : serviceResponse_;
      }
    }
    /**
     * <code>.common.ServiceResponse service_response = 4;</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
        com.pm.grpc.common.ServiceResponse, com.pm.grpc.common.ServiceResponse.Builder, com.pm.grpc.common.ServiceResponseOrBuilder> 
        getServiceResponseFieldBuilder() {
      if (serviceResponseBuilder_ == null) {
        serviceResponseBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
            com.pm.grpc.common.ServiceResponse, com.pm.grpc.common.ServiceResponse.Builder, com.pm.grpc.common.ServiceResponseOrBuilder>(
                getServiceResponse(),
                getParentForChildren(),
                isClean());
        serviceResponse_ = null;
      }
      return serviceResponseBuilder_;
    }
    @java.lang.Override
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFields(unknownFields);
    }

    @java.lang.Override
    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:customer.ValidateCustomerResponse)
  }

  // @@protoc_insertion_point(class_scope:customer.ValidateCustomerResponse)
  private static final com.pm.grpc.customer.ValidateCustomerResponse DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.pm.grpc.customer.ValidateCustomerResponse();
  }

  public static com.pm.grpc.customer.ValidateCustomerResponse getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<ValidateCustomerResponse>
      PARSER = new com.google.protobuf.AbstractParser<ValidateCustomerResponse>() {
    @java.lang.Override
    public ValidateCustomerResponse parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      Builder builder = newBuilder();
      try {
        builder.mergeFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.setUnfinishedMessage(builder.buildPartial());
      } catch (com.google.protobuf.UninitializedMessageException e) {
        throw e.asInvalidProtocolBufferException().setUnfinishedMessage(builder.buildPartial());
      } catch (java.io.IOException e) {
        throw new com.google.protobuf.InvalidProtocolBufferException(e)
            .setUnfinishedMessage(builder.buildPartial());
      }
      return builder.buildPartial();
    }
  };

  public static com.google.protobuf.Parser<ValidateCustomerResponse> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<ValidateCustomerResponse> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public com.pm.grpc.customer.ValidateCustomerResponse getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

