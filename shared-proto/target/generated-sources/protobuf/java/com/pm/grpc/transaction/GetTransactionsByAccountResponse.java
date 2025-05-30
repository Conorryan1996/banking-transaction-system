// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: transaction_service.proto

package com.pm.grpc.transaction;

/**
 * Protobuf type {@code transaction.GetTransactionsByAccountResponse}
 */
public final class GetTransactionsByAccountResponse extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:transaction.GetTransactionsByAccountResponse)
    GetTransactionsByAccountResponseOrBuilder {
private static final long serialVersionUID = 0L;
  // Use GetTransactionsByAccountResponse.newBuilder() to construct.
  private GetTransactionsByAccountResponse(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private GetTransactionsByAccountResponse() {
    transactions_ = java.util.Collections.emptyList();
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new GetTransactionsByAccountResponse();
  }

  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return com.pm.grpc.transaction.TransactionServiceOuterClass.internal_static_transaction_GetTransactionsByAccountResponse_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.pm.grpc.transaction.TransactionServiceOuterClass.internal_static_transaction_GetTransactionsByAccountResponse_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.pm.grpc.transaction.GetTransactionsByAccountResponse.class, com.pm.grpc.transaction.GetTransactionsByAccountResponse.Builder.class);
  }

  private int bitField0_;
  public static final int TRANSACTIONS_FIELD_NUMBER = 1;
  @SuppressWarnings("serial")
  private java.util.List<com.pm.grpc.transaction.GetTransactionResponse> transactions_;
  /**
   * <code>repeated .transaction.GetTransactionResponse transactions = 1;</code>
   */
  @java.lang.Override
  public java.util.List<com.pm.grpc.transaction.GetTransactionResponse> getTransactionsList() {
    return transactions_;
  }
  /**
   * <code>repeated .transaction.GetTransactionResponse transactions = 1;</code>
   */
  @java.lang.Override
  public java.util.List<? extends com.pm.grpc.transaction.GetTransactionResponseOrBuilder> 
      getTransactionsOrBuilderList() {
    return transactions_;
  }
  /**
   * <code>repeated .transaction.GetTransactionResponse transactions = 1;</code>
   */
  @java.lang.Override
  public int getTransactionsCount() {
    return transactions_.size();
  }
  /**
   * <code>repeated .transaction.GetTransactionResponse transactions = 1;</code>
   */
  @java.lang.Override
  public com.pm.grpc.transaction.GetTransactionResponse getTransactions(int index) {
    return transactions_.get(index);
  }
  /**
   * <code>repeated .transaction.GetTransactionResponse transactions = 1;</code>
   */
  @java.lang.Override
  public com.pm.grpc.transaction.GetTransactionResponseOrBuilder getTransactionsOrBuilder(
      int index) {
    return transactions_.get(index);
  }

  public static final int TOTAL_COUNT_FIELD_NUMBER = 2;
  private int totalCount_ = 0;
  /**
   * <code>int32 total_count = 2;</code>
   * @return The totalCount.
   */
  @java.lang.Override
  public int getTotalCount() {
    return totalCount_;
  }

  public static final int SERVICE_RESPONSE_FIELD_NUMBER = 3;
  private com.pm.grpc.common.ServiceResponse serviceResponse_;
  /**
   * <code>.common.ServiceResponse service_response = 3;</code>
   * @return Whether the serviceResponse field is set.
   */
  @java.lang.Override
  public boolean hasServiceResponse() {
    return ((bitField0_ & 0x00000001) != 0);
  }
  /**
   * <code>.common.ServiceResponse service_response = 3;</code>
   * @return The serviceResponse.
   */
  @java.lang.Override
  public com.pm.grpc.common.ServiceResponse getServiceResponse() {
    return serviceResponse_ == null ? com.pm.grpc.common.ServiceResponse.getDefaultInstance() : serviceResponse_;
  }
  /**
   * <code>.common.ServiceResponse service_response = 3;</code>
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
    for (int i = 0; i < transactions_.size(); i++) {
      output.writeMessage(1, transactions_.get(i));
    }
    if (totalCount_ != 0) {
      output.writeInt32(2, totalCount_);
    }
    if (((bitField0_ & 0x00000001) != 0)) {
      output.writeMessage(3, getServiceResponse());
    }
    getUnknownFields().writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    for (int i = 0; i < transactions_.size(); i++) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(1, transactions_.get(i));
    }
    if (totalCount_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(2, totalCount_);
    }
    if (((bitField0_ & 0x00000001) != 0)) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(3, getServiceResponse());
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
    if (!(obj instanceof com.pm.grpc.transaction.GetTransactionsByAccountResponse)) {
      return super.equals(obj);
    }
    com.pm.grpc.transaction.GetTransactionsByAccountResponse other = (com.pm.grpc.transaction.GetTransactionsByAccountResponse) obj;

    if (!getTransactionsList()
        .equals(other.getTransactionsList())) return false;
    if (getTotalCount()
        != other.getTotalCount()) return false;
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
    if (getTransactionsCount() > 0) {
      hash = (37 * hash) + TRANSACTIONS_FIELD_NUMBER;
      hash = (53 * hash) + getTransactionsList().hashCode();
    }
    hash = (37 * hash) + TOTAL_COUNT_FIELD_NUMBER;
    hash = (53 * hash) + getTotalCount();
    if (hasServiceResponse()) {
      hash = (37 * hash) + SERVICE_RESPONSE_FIELD_NUMBER;
      hash = (53 * hash) + getServiceResponse().hashCode();
    }
    hash = (29 * hash) + getUnknownFields().hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.pm.grpc.transaction.GetTransactionsByAccountResponse parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.pm.grpc.transaction.GetTransactionsByAccountResponse parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.pm.grpc.transaction.GetTransactionsByAccountResponse parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.pm.grpc.transaction.GetTransactionsByAccountResponse parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.pm.grpc.transaction.GetTransactionsByAccountResponse parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.pm.grpc.transaction.GetTransactionsByAccountResponse parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.pm.grpc.transaction.GetTransactionsByAccountResponse parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.pm.grpc.transaction.GetTransactionsByAccountResponse parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  public static com.pm.grpc.transaction.GetTransactionsByAccountResponse parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }

  public static com.pm.grpc.transaction.GetTransactionsByAccountResponse parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.pm.grpc.transaction.GetTransactionsByAccountResponse parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.pm.grpc.transaction.GetTransactionsByAccountResponse parseFrom(
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
  public static Builder newBuilder(com.pm.grpc.transaction.GetTransactionsByAccountResponse prototype) {
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
   * Protobuf type {@code transaction.GetTransactionsByAccountResponse}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:transaction.GetTransactionsByAccountResponse)
      com.pm.grpc.transaction.GetTransactionsByAccountResponseOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.pm.grpc.transaction.TransactionServiceOuterClass.internal_static_transaction_GetTransactionsByAccountResponse_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.pm.grpc.transaction.TransactionServiceOuterClass.internal_static_transaction_GetTransactionsByAccountResponse_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.pm.grpc.transaction.GetTransactionsByAccountResponse.class, com.pm.grpc.transaction.GetTransactionsByAccountResponse.Builder.class);
    }

    // Construct using com.pm.grpc.transaction.GetTransactionsByAccountResponse.newBuilder()
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
        getTransactionsFieldBuilder();
        getServiceResponseFieldBuilder();
      }
    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      bitField0_ = 0;
      if (transactionsBuilder_ == null) {
        transactions_ = java.util.Collections.emptyList();
      } else {
        transactions_ = null;
        transactionsBuilder_.clear();
      }
      bitField0_ = (bitField0_ & ~0x00000001);
      totalCount_ = 0;
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
      return com.pm.grpc.transaction.TransactionServiceOuterClass.internal_static_transaction_GetTransactionsByAccountResponse_descriptor;
    }

    @java.lang.Override
    public com.pm.grpc.transaction.GetTransactionsByAccountResponse getDefaultInstanceForType() {
      return com.pm.grpc.transaction.GetTransactionsByAccountResponse.getDefaultInstance();
    }

    @java.lang.Override
    public com.pm.grpc.transaction.GetTransactionsByAccountResponse build() {
      com.pm.grpc.transaction.GetTransactionsByAccountResponse result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public com.pm.grpc.transaction.GetTransactionsByAccountResponse buildPartial() {
      com.pm.grpc.transaction.GetTransactionsByAccountResponse result = new com.pm.grpc.transaction.GetTransactionsByAccountResponse(this);
      buildPartialRepeatedFields(result);
      if (bitField0_ != 0) { buildPartial0(result); }
      onBuilt();
      return result;
    }

    private void buildPartialRepeatedFields(com.pm.grpc.transaction.GetTransactionsByAccountResponse result) {
      if (transactionsBuilder_ == null) {
        if (((bitField0_ & 0x00000001) != 0)) {
          transactions_ = java.util.Collections.unmodifiableList(transactions_);
          bitField0_ = (bitField0_ & ~0x00000001);
        }
        result.transactions_ = transactions_;
      } else {
        result.transactions_ = transactionsBuilder_.build();
      }
    }

    private void buildPartial0(com.pm.grpc.transaction.GetTransactionsByAccountResponse result) {
      int from_bitField0_ = bitField0_;
      if (((from_bitField0_ & 0x00000002) != 0)) {
        result.totalCount_ = totalCount_;
      }
      int to_bitField0_ = 0;
      if (((from_bitField0_ & 0x00000004) != 0)) {
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
      if (other instanceof com.pm.grpc.transaction.GetTransactionsByAccountResponse) {
        return mergeFrom((com.pm.grpc.transaction.GetTransactionsByAccountResponse)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.pm.grpc.transaction.GetTransactionsByAccountResponse other) {
      if (other == com.pm.grpc.transaction.GetTransactionsByAccountResponse.getDefaultInstance()) return this;
      if (transactionsBuilder_ == null) {
        if (!other.transactions_.isEmpty()) {
          if (transactions_.isEmpty()) {
            transactions_ = other.transactions_;
            bitField0_ = (bitField0_ & ~0x00000001);
          } else {
            ensureTransactionsIsMutable();
            transactions_.addAll(other.transactions_);
          }
          onChanged();
        }
      } else {
        if (!other.transactions_.isEmpty()) {
          if (transactionsBuilder_.isEmpty()) {
            transactionsBuilder_.dispose();
            transactionsBuilder_ = null;
            transactions_ = other.transactions_;
            bitField0_ = (bitField0_ & ~0x00000001);
            transactionsBuilder_ = 
              com.google.protobuf.GeneratedMessageV3.alwaysUseFieldBuilders ?
                 getTransactionsFieldBuilder() : null;
          } else {
            transactionsBuilder_.addAllMessages(other.transactions_);
          }
        }
      }
      if (other.getTotalCount() != 0) {
        setTotalCount(other.getTotalCount());
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
            case 10: {
              com.pm.grpc.transaction.GetTransactionResponse m =
                  input.readMessage(
                      com.pm.grpc.transaction.GetTransactionResponse.parser(),
                      extensionRegistry);
              if (transactionsBuilder_ == null) {
                ensureTransactionsIsMutable();
                transactions_.add(m);
              } else {
                transactionsBuilder_.addMessage(m);
              }
              break;
            } // case 10
            case 16: {
              totalCount_ = input.readInt32();
              bitField0_ |= 0x00000002;
              break;
            } // case 16
            case 26: {
              input.readMessage(
                  getServiceResponseFieldBuilder().getBuilder(),
                  extensionRegistry);
              bitField0_ |= 0x00000004;
              break;
            } // case 26
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

    private java.util.List<com.pm.grpc.transaction.GetTransactionResponse> transactions_ =
      java.util.Collections.emptyList();
    private void ensureTransactionsIsMutable() {
      if (!((bitField0_ & 0x00000001) != 0)) {
        transactions_ = new java.util.ArrayList<com.pm.grpc.transaction.GetTransactionResponse>(transactions_);
        bitField0_ |= 0x00000001;
       }
    }

    private com.google.protobuf.RepeatedFieldBuilderV3<
        com.pm.grpc.transaction.GetTransactionResponse, com.pm.grpc.transaction.GetTransactionResponse.Builder, com.pm.grpc.transaction.GetTransactionResponseOrBuilder> transactionsBuilder_;

    /**
     * <code>repeated .transaction.GetTransactionResponse transactions = 1;</code>
     */
    public java.util.List<com.pm.grpc.transaction.GetTransactionResponse> getTransactionsList() {
      if (transactionsBuilder_ == null) {
        return java.util.Collections.unmodifiableList(transactions_);
      } else {
        return transactionsBuilder_.getMessageList();
      }
    }
    /**
     * <code>repeated .transaction.GetTransactionResponse transactions = 1;</code>
     */
    public int getTransactionsCount() {
      if (transactionsBuilder_ == null) {
        return transactions_.size();
      } else {
        return transactionsBuilder_.getCount();
      }
    }
    /**
     * <code>repeated .transaction.GetTransactionResponse transactions = 1;</code>
     */
    public com.pm.grpc.transaction.GetTransactionResponse getTransactions(int index) {
      if (transactionsBuilder_ == null) {
        return transactions_.get(index);
      } else {
        return transactionsBuilder_.getMessage(index);
      }
    }
    /**
     * <code>repeated .transaction.GetTransactionResponse transactions = 1;</code>
     */
    public Builder setTransactions(
        int index, com.pm.grpc.transaction.GetTransactionResponse value) {
      if (transactionsBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureTransactionsIsMutable();
        transactions_.set(index, value);
        onChanged();
      } else {
        transactionsBuilder_.setMessage(index, value);
      }
      return this;
    }
    /**
     * <code>repeated .transaction.GetTransactionResponse transactions = 1;</code>
     */
    public Builder setTransactions(
        int index, com.pm.grpc.transaction.GetTransactionResponse.Builder builderForValue) {
      if (transactionsBuilder_ == null) {
        ensureTransactionsIsMutable();
        transactions_.set(index, builderForValue.build());
        onChanged();
      } else {
        transactionsBuilder_.setMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .transaction.GetTransactionResponse transactions = 1;</code>
     */
    public Builder addTransactions(com.pm.grpc.transaction.GetTransactionResponse value) {
      if (transactionsBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureTransactionsIsMutable();
        transactions_.add(value);
        onChanged();
      } else {
        transactionsBuilder_.addMessage(value);
      }
      return this;
    }
    /**
     * <code>repeated .transaction.GetTransactionResponse transactions = 1;</code>
     */
    public Builder addTransactions(
        int index, com.pm.grpc.transaction.GetTransactionResponse value) {
      if (transactionsBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureTransactionsIsMutable();
        transactions_.add(index, value);
        onChanged();
      } else {
        transactionsBuilder_.addMessage(index, value);
      }
      return this;
    }
    /**
     * <code>repeated .transaction.GetTransactionResponse transactions = 1;</code>
     */
    public Builder addTransactions(
        com.pm.grpc.transaction.GetTransactionResponse.Builder builderForValue) {
      if (transactionsBuilder_ == null) {
        ensureTransactionsIsMutable();
        transactions_.add(builderForValue.build());
        onChanged();
      } else {
        transactionsBuilder_.addMessage(builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .transaction.GetTransactionResponse transactions = 1;</code>
     */
    public Builder addTransactions(
        int index, com.pm.grpc.transaction.GetTransactionResponse.Builder builderForValue) {
      if (transactionsBuilder_ == null) {
        ensureTransactionsIsMutable();
        transactions_.add(index, builderForValue.build());
        onChanged();
      } else {
        transactionsBuilder_.addMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .transaction.GetTransactionResponse transactions = 1;</code>
     */
    public Builder addAllTransactions(
        java.lang.Iterable<? extends com.pm.grpc.transaction.GetTransactionResponse> values) {
      if (transactionsBuilder_ == null) {
        ensureTransactionsIsMutable();
        com.google.protobuf.AbstractMessageLite.Builder.addAll(
            values, transactions_);
        onChanged();
      } else {
        transactionsBuilder_.addAllMessages(values);
      }
      return this;
    }
    /**
     * <code>repeated .transaction.GetTransactionResponse transactions = 1;</code>
     */
    public Builder clearTransactions() {
      if (transactionsBuilder_ == null) {
        transactions_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000001);
        onChanged();
      } else {
        transactionsBuilder_.clear();
      }
      return this;
    }
    /**
     * <code>repeated .transaction.GetTransactionResponse transactions = 1;</code>
     */
    public Builder removeTransactions(int index) {
      if (transactionsBuilder_ == null) {
        ensureTransactionsIsMutable();
        transactions_.remove(index);
        onChanged();
      } else {
        transactionsBuilder_.remove(index);
      }
      return this;
    }
    /**
     * <code>repeated .transaction.GetTransactionResponse transactions = 1;</code>
     */
    public com.pm.grpc.transaction.GetTransactionResponse.Builder getTransactionsBuilder(
        int index) {
      return getTransactionsFieldBuilder().getBuilder(index);
    }
    /**
     * <code>repeated .transaction.GetTransactionResponse transactions = 1;</code>
     */
    public com.pm.grpc.transaction.GetTransactionResponseOrBuilder getTransactionsOrBuilder(
        int index) {
      if (transactionsBuilder_ == null) {
        return transactions_.get(index);  } else {
        return transactionsBuilder_.getMessageOrBuilder(index);
      }
    }
    /**
     * <code>repeated .transaction.GetTransactionResponse transactions = 1;</code>
     */
    public java.util.List<? extends com.pm.grpc.transaction.GetTransactionResponseOrBuilder> 
         getTransactionsOrBuilderList() {
      if (transactionsBuilder_ != null) {
        return transactionsBuilder_.getMessageOrBuilderList();
      } else {
        return java.util.Collections.unmodifiableList(transactions_);
      }
    }
    /**
     * <code>repeated .transaction.GetTransactionResponse transactions = 1;</code>
     */
    public com.pm.grpc.transaction.GetTransactionResponse.Builder addTransactionsBuilder() {
      return getTransactionsFieldBuilder().addBuilder(
          com.pm.grpc.transaction.GetTransactionResponse.getDefaultInstance());
    }
    /**
     * <code>repeated .transaction.GetTransactionResponse transactions = 1;</code>
     */
    public com.pm.grpc.transaction.GetTransactionResponse.Builder addTransactionsBuilder(
        int index) {
      return getTransactionsFieldBuilder().addBuilder(
          index, com.pm.grpc.transaction.GetTransactionResponse.getDefaultInstance());
    }
    /**
     * <code>repeated .transaction.GetTransactionResponse transactions = 1;</code>
     */
    public java.util.List<com.pm.grpc.transaction.GetTransactionResponse.Builder> 
         getTransactionsBuilderList() {
      return getTransactionsFieldBuilder().getBuilderList();
    }
    private com.google.protobuf.RepeatedFieldBuilderV3<
        com.pm.grpc.transaction.GetTransactionResponse, com.pm.grpc.transaction.GetTransactionResponse.Builder, com.pm.grpc.transaction.GetTransactionResponseOrBuilder> 
        getTransactionsFieldBuilder() {
      if (transactionsBuilder_ == null) {
        transactionsBuilder_ = new com.google.protobuf.RepeatedFieldBuilderV3<
            com.pm.grpc.transaction.GetTransactionResponse, com.pm.grpc.transaction.GetTransactionResponse.Builder, com.pm.grpc.transaction.GetTransactionResponseOrBuilder>(
                transactions_,
                ((bitField0_ & 0x00000001) != 0),
                getParentForChildren(),
                isClean());
        transactions_ = null;
      }
      return transactionsBuilder_;
    }

    private int totalCount_ ;
    /**
     * <code>int32 total_count = 2;</code>
     * @return The totalCount.
     */
    @java.lang.Override
    public int getTotalCount() {
      return totalCount_;
    }
    /**
     * <code>int32 total_count = 2;</code>
     * @param value The totalCount to set.
     * @return This builder for chaining.
     */
    public Builder setTotalCount(int value) {

      totalCount_ = value;
      bitField0_ |= 0x00000002;
      onChanged();
      return this;
    }
    /**
     * <code>int32 total_count = 2;</code>
     * @return This builder for chaining.
     */
    public Builder clearTotalCount() {
      bitField0_ = (bitField0_ & ~0x00000002);
      totalCount_ = 0;
      onChanged();
      return this;
    }

    private com.pm.grpc.common.ServiceResponse serviceResponse_;
    private com.google.protobuf.SingleFieldBuilderV3<
        com.pm.grpc.common.ServiceResponse, com.pm.grpc.common.ServiceResponse.Builder, com.pm.grpc.common.ServiceResponseOrBuilder> serviceResponseBuilder_;
    /**
     * <code>.common.ServiceResponse service_response = 3;</code>
     * @return Whether the serviceResponse field is set.
     */
    public boolean hasServiceResponse() {
      return ((bitField0_ & 0x00000004) != 0);
    }
    /**
     * <code>.common.ServiceResponse service_response = 3;</code>
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
     * <code>.common.ServiceResponse service_response = 3;</code>
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
      bitField0_ |= 0x00000004;
      onChanged();
      return this;
    }
    /**
     * <code>.common.ServiceResponse service_response = 3;</code>
     */
    public Builder setServiceResponse(
        com.pm.grpc.common.ServiceResponse.Builder builderForValue) {
      if (serviceResponseBuilder_ == null) {
        serviceResponse_ = builderForValue.build();
      } else {
        serviceResponseBuilder_.setMessage(builderForValue.build());
      }
      bitField0_ |= 0x00000004;
      onChanged();
      return this;
    }
    /**
     * <code>.common.ServiceResponse service_response = 3;</code>
     */
    public Builder mergeServiceResponse(com.pm.grpc.common.ServiceResponse value) {
      if (serviceResponseBuilder_ == null) {
        if (((bitField0_ & 0x00000004) != 0) &&
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
        bitField0_ |= 0x00000004;
        onChanged();
      }
      return this;
    }
    /**
     * <code>.common.ServiceResponse service_response = 3;</code>
     */
    public Builder clearServiceResponse() {
      bitField0_ = (bitField0_ & ~0x00000004);
      serviceResponse_ = null;
      if (serviceResponseBuilder_ != null) {
        serviceResponseBuilder_.dispose();
        serviceResponseBuilder_ = null;
      }
      onChanged();
      return this;
    }
    /**
     * <code>.common.ServiceResponse service_response = 3;</code>
     */
    public com.pm.grpc.common.ServiceResponse.Builder getServiceResponseBuilder() {
      bitField0_ |= 0x00000004;
      onChanged();
      return getServiceResponseFieldBuilder().getBuilder();
    }
    /**
     * <code>.common.ServiceResponse service_response = 3;</code>
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
     * <code>.common.ServiceResponse service_response = 3;</code>
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


    // @@protoc_insertion_point(builder_scope:transaction.GetTransactionsByAccountResponse)
  }

  // @@protoc_insertion_point(class_scope:transaction.GetTransactionsByAccountResponse)
  private static final com.pm.grpc.transaction.GetTransactionsByAccountResponse DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.pm.grpc.transaction.GetTransactionsByAccountResponse();
  }

  public static com.pm.grpc.transaction.GetTransactionsByAccountResponse getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<GetTransactionsByAccountResponse>
      PARSER = new com.google.protobuf.AbstractParser<GetTransactionsByAccountResponse>() {
    @java.lang.Override
    public GetTransactionsByAccountResponse parsePartialFrom(
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

  public static com.google.protobuf.Parser<GetTransactionsByAccountResponse> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<GetTransactionsByAccountResponse> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public com.pm.grpc.transaction.GetTransactionsByAccountResponse getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

