// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: customer_service.proto

package com.pm.grpc.customer;

/**
 * Protobuf type {@code customer.DefaultAccountInfo}
 */
public final class DefaultAccountInfo extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:customer.DefaultAccountInfo)
    DefaultAccountInfoOrBuilder {
private static final long serialVersionUID = 0L;
  // Use DefaultAccountInfo.newBuilder() to construct.
  private DefaultAccountInfo(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private DefaultAccountInfo() {
    accountId_ = "";
    accountNumber_ = "";
    accountType_ = 0;
    balance_ = "";
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new DefaultAccountInfo();
  }

  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return com.pm.grpc.customer.CustomerServiceOuterClass.internal_static_customer_DefaultAccountInfo_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.pm.grpc.customer.CustomerServiceOuterClass.internal_static_customer_DefaultAccountInfo_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.pm.grpc.customer.DefaultAccountInfo.class, com.pm.grpc.customer.DefaultAccountInfo.Builder.class);
  }

  public static final int ACCOUNT_ID_FIELD_NUMBER = 1;
  @SuppressWarnings("serial")
  private volatile java.lang.Object accountId_ = "";
  /**
   * <code>string account_id = 1;</code>
   * @return The accountId.
   */
  @java.lang.Override
  public java.lang.String getAccountId() {
    java.lang.Object ref = accountId_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      accountId_ = s;
      return s;
    }
  }
  /**
   * <code>string account_id = 1;</code>
   * @return The bytes for accountId.
   */
  @java.lang.Override
  public com.google.protobuf.ByteString
      getAccountIdBytes() {
    java.lang.Object ref = accountId_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      accountId_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int ACCOUNT_NUMBER_FIELD_NUMBER = 2;
  @SuppressWarnings("serial")
  private volatile java.lang.Object accountNumber_ = "";
  /**
   * <code>string account_number = 2;</code>
   * @return The accountNumber.
   */
  @java.lang.Override
  public java.lang.String getAccountNumber() {
    java.lang.Object ref = accountNumber_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      accountNumber_ = s;
      return s;
    }
  }
  /**
   * <code>string account_number = 2;</code>
   * @return The bytes for accountNumber.
   */
  @java.lang.Override
  public com.google.protobuf.ByteString
      getAccountNumberBytes() {
    java.lang.Object ref = accountNumber_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      accountNumber_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int ACCOUNT_TYPE_FIELD_NUMBER = 3;
  private int accountType_ = 0;
  /**
   * <code>.common.AccountType account_type = 3;</code>
   * @return The enum numeric value on the wire for accountType.
   */
  @java.lang.Override public int getAccountTypeValue() {
    return accountType_;
  }
  /**
   * <code>.common.AccountType account_type = 3;</code>
   * @return The accountType.
   */
  @java.lang.Override public com.pm.grpc.common.AccountType getAccountType() {
    com.pm.grpc.common.AccountType result = com.pm.grpc.common.AccountType.forNumber(accountType_);
    return result == null ? com.pm.grpc.common.AccountType.UNRECOGNIZED : result;
  }

  public static final int BALANCE_FIELD_NUMBER = 4;
  @SuppressWarnings("serial")
  private volatile java.lang.Object balance_ = "";
  /**
   * <code>string balance = 4;</code>
   * @return The balance.
   */
  @java.lang.Override
  public java.lang.String getBalance() {
    java.lang.Object ref = balance_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      balance_ = s;
      return s;
    }
  }
  /**
   * <code>string balance = 4;</code>
   * @return The bytes for balance.
   */
  @java.lang.Override
  public com.google.protobuf.ByteString
      getBalanceBytes() {
    java.lang.Object ref = balance_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      balance_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
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
    if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(accountId_)) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 1, accountId_);
    }
    if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(accountNumber_)) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 2, accountNumber_);
    }
    if (accountType_ != com.pm.grpc.common.AccountType.ACCOUNT_TYPE_UNSPECIFIED.getNumber()) {
      output.writeEnum(3, accountType_);
    }
    if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(balance_)) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 4, balance_);
    }
    getUnknownFields().writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(accountId_)) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, accountId_);
    }
    if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(accountNumber_)) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(2, accountNumber_);
    }
    if (accountType_ != com.pm.grpc.common.AccountType.ACCOUNT_TYPE_UNSPECIFIED.getNumber()) {
      size += com.google.protobuf.CodedOutputStream
        .computeEnumSize(3, accountType_);
    }
    if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(balance_)) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(4, balance_);
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
    if (!(obj instanceof com.pm.grpc.customer.DefaultAccountInfo)) {
      return super.equals(obj);
    }
    com.pm.grpc.customer.DefaultAccountInfo other = (com.pm.grpc.customer.DefaultAccountInfo) obj;

    if (!getAccountId()
        .equals(other.getAccountId())) return false;
    if (!getAccountNumber()
        .equals(other.getAccountNumber())) return false;
    if (accountType_ != other.accountType_) return false;
    if (!getBalance()
        .equals(other.getBalance())) return false;
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
    hash = (37 * hash) + ACCOUNT_ID_FIELD_NUMBER;
    hash = (53 * hash) + getAccountId().hashCode();
    hash = (37 * hash) + ACCOUNT_NUMBER_FIELD_NUMBER;
    hash = (53 * hash) + getAccountNumber().hashCode();
    hash = (37 * hash) + ACCOUNT_TYPE_FIELD_NUMBER;
    hash = (53 * hash) + accountType_;
    hash = (37 * hash) + BALANCE_FIELD_NUMBER;
    hash = (53 * hash) + getBalance().hashCode();
    hash = (29 * hash) + getUnknownFields().hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.pm.grpc.customer.DefaultAccountInfo parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.pm.grpc.customer.DefaultAccountInfo parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.pm.grpc.customer.DefaultAccountInfo parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.pm.grpc.customer.DefaultAccountInfo parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.pm.grpc.customer.DefaultAccountInfo parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.pm.grpc.customer.DefaultAccountInfo parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.pm.grpc.customer.DefaultAccountInfo parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.pm.grpc.customer.DefaultAccountInfo parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  public static com.pm.grpc.customer.DefaultAccountInfo parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }

  public static com.pm.grpc.customer.DefaultAccountInfo parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.pm.grpc.customer.DefaultAccountInfo parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.pm.grpc.customer.DefaultAccountInfo parseFrom(
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
  public static Builder newBuilder(com.pm.grpc.customer.DefaultAccountInfo prototype) {
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
   * Protobuf type {@code customer.DefaultAccountInfo}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:customer.DefaultAccountInfo)
      com.pm.grpc.customer.DefaultAccountInfoOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.pm.grpc.customer.CustomerServiceOuterClass.internal_static_customer_DefaultAccountInfo_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.pm.grpc.customer.CustomerServiceOuterClass.internal_static_customer_DefaultAccountInfo_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.pm.grpc.customer.DefaultAccountInfo.class, com.pm.grpc.customer.DefaultAccountInfo.Builder.class);
    }

    // Construct using com.pm.grpc.customer.DefaultAccountInfo.newBuilder()
    private Builder() {

    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);

    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      bitField0_ = 0;
      accountId_ = "";
      accountNumber_ = "";
      accountType_ = 0;
      balance_ = "";
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.pm.grpc.customer.CustomerServiceOuterClass.internal_static_customer_DefaultAccountInfo_descriptor;
    }

    @java.lang.Override
    public com.pm.grpc.customer.DefaultAccountInfo getDefaultInstanceForType() {
      return com.pm.grpc.customer.DefaultAccountInfo.getDefaultInstance();
    }

    @java.lang.Override
    public com.pm.grpc.customer.DefaultAccountInfo build() {
      com.pm.grpc.customer.DefaultAccountInfo result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public com.pm.grpc.customer.DefaultAccountInfo buildPartial() {
      com.pm.grpc.customer.DefaultAccountInfo result = new com.pm.grpc.customer.DefaultAccountInfo(this);
      if (bitField0_ != 0) { buildPartial0(result); }
      onBuilt();
      return result;
    }

    private void buildPartial0(com.pm.grpc.customer.DefaultAccountInfo result) {
      int from_bitField0_ = bitField0_;
      if (((from_bitField0_ & 0x00000001) != 0)) {
        result.accountId_ = accountId_;
      }
      if (((from_bitField0_ & 0x00000002) != 0)) {
        result.accountNumber_ = accountNumber_;
      }
      if (((from_bitField0_ & 0x00000004) != 0)) {
        result.accountType_ = accountType_;
      }
      if (((from_bitField0_ & 0x00000008) != 0)) {
        result.balance_ = balance_;
      }
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
      if (other instanceof com.pm.grpc.customer.DefaultAccountInfo) {
        return mergeFrom((com.pm.grpc.customer.DefaultAccountInfo)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.pm.grpc.customer.DefaultAccountInfo other) {
      if (other == com.pm.grpc.customer.DefaultAccountInfo.getDefaultInstance()) return this;
      if (!other.getAccountId().isEmpty()) {
        accountId_ = other.accountId_;
        bitField0_ |= 0x00000001;
        onChanged();
      }
      if (!other.getAccountNumber().isEmpty()) {
        accountNumber_ = other.accountNumber_;
        bitField0_ |= 0x00000002;
        onChanged();
      }
      if (other.accountType_ != 0) {
        setAccountTypeValue(other.getAccountTypeValue());
      }
      if (!other.getBalance().isEmpty()) {
        balance_ = other.balance_;
        bitField0_ |= 0x00000008;
        onChanged();
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
              accountId_ = input.readStringRequireUtf8();
              bitField0_ |= 0x00000001;
              break;
            } // case 10
            case 18: {
              accountNumber_ = input.readStringRequireUtf8();
              bitField0_ |= 0x00000002;
              break;
            } // case 18
            case 24: {
              accountType_ = input.readEnum();
              bitField0_ |= 0x00000004;
              break;
            } // case 24
            case 34: {
              balance_ = input.readStringRequireUtf8();
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

    private java.lang.Object accountId_ = "";
    /**
     * <code>string account_id = 1;</code>
     * @return The accountId.
     */
    public java.lang.String getAccountId() {
      java.lang.Object ref = accountId_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        accountId_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string account_id = 1;</code>
     * @return The bytes for accountId.
     */
    public com.google.protobuf.ByteString
        getAccountIdBytes() {
      java.lang.Object ref = accountId_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        accountId_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string account_id = 1;</code>
     * @param value The accountId to set.
     * @return This builder for chaining.
     */
    public Builder setAccountId(
        java.lang.String value) {
      if (value == null) { throw new NullPointerException(); }
      accountId_ = value;
      bitField0_ |= 0x00000001;
      onChanged();
      return this;
    }
    /**
     * <code>string account_id = 1;</code>
     * @return This builder for chaining.
     */
    public Builder clearAccountId() {
      accountId_ = getDefaultInstance().getAccountId();
      bitField0_ = (bitField0_ & ~0x00000001);
      onChanged();
      return this;
    }
    /**
     * <code>string account_id = 1;</code>
     * @param value The bytes for accountId to set.
     * @return This builder for chaining.
     */
    public Builder setAccountIdBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) { throw new NullPointerException(); }
      checkByteStringIsUtf8(value);
      accountId_ = value;
      bitField0_ |= 0x00000001;
      onChanged();
      return this;
    }

    private java.lang.Object accountNumber_ = "";
    /**
     * <code>string account_number = 2;</code>
     * @return The accountNumber.
     */
    public java.lang.String getAccountNumber() {
      java.lang.Object ref = accountNumber_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        accountNumber_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string account_number = 2;</code>
     * @return The bytes for accountNumber.
     */
    public com.google.protobuf.ByteString
        getAccountNumberBytes() {
      java.lang.Object ref = accountNumber_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        accountNumber_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string account_number = 2;</code>
     * @param value The accountNumber to set.
     * @return This builder for chaining.
     */
    public Builder setAccountNumber(
        java.lang.String value) {
      if (value == null) { throw new NullPointerException(); }
      accountNumber_ = value;
      bitField0_ |= 0x00000002;
      onChanged();
      return this;
    }
    /**
     * <code>string account_number = 2;</code>
     * @return This builder for chaining.
     */
    public Builder clearAccountNumber() {
      accountNumber_ = getDefaultInstance().getAccountNumber();
      bitField0_ = (bitField0_ & ~0x00000002);
      onChanged();
      return this;
    }
    /**
     * <code>string account_number = 2;</code>
     * @param value The bytes for accountNumber to set.
     * @return This builder for chaining.
     */
    public Builder setAccountNumberBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) { throw new NullPointerException(); }
      checkByteStringIsUtf8(value);
      accountNumber_ = value;
      bitField0_ |= 0x00000002;
      onChanged();
      return this;
    }

    private int accountType_ = 0;
    /**
     * <code>.common.AccountType account_type = 3;</code>
     * @return The enum numeric value on the wire for accountType.
     */
    @java.lang.Override public int getAccountTypeValue() {
      return accountType_;
    }
    /**
     * <code>.common.AccountType account_type = 3;</code>
     * @param value The enum numeric value on the wire for accountType to set.
     * @return This builder for chaining.
     */
    public Builder setAccountTypeValue(int value) {
      accountType_ = value;
      bitField0_ |= 0x00000004;
      onChanged();
      return this;
    }
    /**
     * <code>.common.AccountType account_type = 3;</code>
     * @return The accountType.
     */
    @java.lang.Override
    public com.pm.grpc.common.AccountType getAccountType() {
      com.pm.grpc.common.AccountType result = com.pm.grpc.common.AccountType.forNumber(accountType_);
      return result == null ? com.pm.grpc.common.AccountType.UNRECOGNIZED : result;
    }
    /**
     * <code>.common.AccountType account_type = 3;</code>
     * @param value The accountType to set.
     * @return This builder for chaining.
     */
    public Builder setAccountType(com.pm.grpc.common.AccountType value) {
      if (value == null) {
        throw new NullPointerException();
      }
      bitField0_ |= 0x00000004;
      accountType_ = value.getNumber();
      onChanged();
      return this;
    }
    /**
     * <code>.common.AccountType account_type = 3;</code>
     * @return This builder for chaining.
     */
    public Builder clearAccountType() {
      bitField0_ = (bitField0_ & ~0x00000004);
      accountType_ = 0;
      onChanged();
      return this;
    }

    private java.lang.Object balance_ = "";
    /**
     * <code>string balance = 4;</code>
     * @return The balance.
     */
    public java.lang.String getBalance() {
      java.lang.Object ref = balance_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        balance_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string balance = 4;</code>
     * @return The bytes for balance.
     */
    public com.google.protobuf.ByteString
        getBalanceBytes() {
      java.lang.Object ref = balance_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        balance_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string balance = 4;</code>
     * @param value The balance to set.
     * @return This builder for chaining.
     */
    public Builder setBalance(
        java.lang.String value) {
      if (value == null) { throw new NullPointerException(); }
      balance_ = value;
      bitField0_ |= 0x00000008;
      onChanged();
      return this;
    }
    /**
     * <code>string balance = 4;</code>
     * @return This builder for chaining.
     */
    public Builder clearBalance() {
      balance_ = getDefaultInstance().getBalance();
      bitField0_ = (bitField0_ & ~0x00000008);
      onChanged();
      return this;
    }
    /**
     * <code>string balance = 4;</code>
     * @param value The bytes for balance to set.
     * @return This builder for chaining.
     */
    public Builder setBalanceBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) { throw new NullPointerException(); }
      checkByteStringIsUtf8(value);
      balance_ = value;
      bitField0_ |= 0x00000008;
      onChanged();
      return this;
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


    // @@protoc_insertion_point(builder_scope:customer.DefaultAccountInfo)
  }

  // @@protoc_insertion_point(class_scope:customer.DefaultAccountInfo)
  private static final com.pm.grpc.customer.DefaultAccountInfo DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.pm.grpc.customer.DefaultAccountInfo();
  }

  public static com.pm.grpc.customer.DefaultAccountInfo getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<DefaultAccountInfo>
      PARSER = new com.google.protobuf.AbstractParser<DefaultAccountInfo>() {
    @java.lang.Override
    public DefaultAccountInfo parsePartialFrom(
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

  public static com.google.protobuf.Parser<DefaultAccountInfo> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<DefaultAccountInfo> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public com.pm.grpc.customer.DefaultAccountInfo getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

