// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: customer_service.proto

package com.pm.grpc.customer;

public final class CustomerServiceOuterClass {
  private CustomerServiceOuterClass() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_customer_CreateCustomerRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_customer_CreateCustomerRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_customer_CreateCustomerResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_customer_CreateCustomerResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_customer_DefaultAccountInfo_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_customer_DefaultAccountInfo_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_customer_GetCustomerRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_customer_GetCustomerRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_customer_GetCustomerResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_customer_GetCustomerResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_customer_UpdateCustomerRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_customer_UpdateCustomerRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_customer_UpdateCustomerResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_customer_UpdateCustomerResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_customer_ValidateCustomerRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_customer_ValidateCustomerRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_customer_ValidateCustomerResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_customer_ValidateCustomerResponse_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\026customer_service.proto\022\010customer\032\014comm" +
      "on.proto\"\337\001\n\025CreateCustomerRequest\022\022\n\nfi" +
      "rst_name\030\001 \001(\t\022\021\n\tlast_name\030\002 \001(\t\022\r\n\005ema" +
      "il\030\003 \001(\t\022\r\n\005phone\030\004 \001(\t\022\025\n\rdate_of_birth" +
      "\030\005 \001(\t\022\036\n\026create_default_account\030\006 \001(\010\0221" +
      "\n\024default_account_type\030\007 \001(\0162\023.common.Ac" +
      "countType\022\027\n\017initial_deposit\030\010 \001(\t\"\213\002\n\026C" +
      "reateCustomerResponse\022\023\n\013customer_id\030\001 \001" +
      "(\t\022\022\n\nfirst_name\030\002 \001(\t\022\021\n\tlast_name\030\003 \001(" +
      "\t\022\r\n\005email\030\004 \001(\t\022&\n\006status\030\005 \001(\0162\026.commo" +
      "n.CustomerStatus\022\024\n\014created_date\030\006 \001(\t\0225" +
      "\n\017default_account\030\007 \001(\0132\034.customer.Defau" +
      "ltAccountInfo\0221\n\020service_response\030\010 \001(\0132" +
      "\027.common.ServiceResponse\"|\n\022DefaultAccou" +
      "ntInfo\022\022\n\naccount_id\030\001 \001(\t\022\026\n\016account_nu" +
      "mber\030\002 \001(\t\022)\n\014account_type\030\003 \001(\0162\023.commo" +
      "n.AccountType\022\017\n\007balance\030\004 \001(\t\")\n\022GetCus" +
      "tomerRequest\022\023\n\013customer_id\030\001 \001(\t\"\340\001\n\023Ge" +
      "tCustomerResponse\022\023\n\013customer_id\030\001 \001(\t\022\022" +
      "\n\nfirst_name\030\002 \001(\t\022\021\n\tlast_name\030\003 \001(\t\022\r\n" +
      "\005email\030\004 \001(\t\022\r\n\005phone\030\005 \001(\t\022&\n\006status\030\006 " +
      "\001(\0162\026.common.CustomerStatus\022\024\n\014created_d" +
      "ate\030\007 \001(\t\0221\n\020service_response\030\010 \001(\0132\027.co" +
      "mmon.ServiceResponse\"q\n\025UpdateCustomerRe" +
      "quest\022\023\n\013customer_id\030\001 \001(\t\022\022\n\nfirst_name" +
      "\030\002 \001(\t\022\021\n\tlast_name\030\003 \001(\t\022\r\n\005email\030\004 \001(\t" +
      "\022\r\n\005phone\030\005 \001(\t\"\301\001\n\026UpdateCustomerRespon" +
      "se\022\023\n\013customer_id\030\001 \001(\t\022\022\n\nfirst_name\030\002 " +
      "\001(\t\022\021\n\tlast_name\030\003 \001(\t\022\r\n\005email\030\004 \001(\t\022\r\n" +
      "\005phone\030\005 \001(\t\022\032\n\022last_modified_date\030\006 \001(\t" +
      "\0221\n\020service_response\030\007 \001(\0132\027.common.Serv" +
      "iceResponse\".\n\027ValidateCustomerRequest\022\023" +
      "\n\013customer_id\030\001 \001(\t\"\230\001\n\030ValidateCustomer" +
      "Response\022\016\n\006exists\030\001 \001(\010\022\021\n\tfull_name\030\002 " +
      "\001(\t\022&\n\006status\030\003 \001(\0162\026.common.CustomerSta" +
      "tus\0221\n\020service_response\030\004 \001(\0132\027.common.S" +
      "erviceResponse2\342\002\n\017CustomerService\022S\n\016Cr" +
      "eateCustomer\022\037.customer.CreateCustomerRe" +
      "quest\032 .customer.CreateCustomerResponse\022" +
      "J\n\013GetCustomer\022\034.customer.GetCustomerReq" +
      "uest\032\035.customer.GetCustomerResponse\022S\n\016U" +
      "pdateCustomer\022\037.customer.UpdateCustomerR" +
      "equest\032 .customer.UpdateCustomerResponse" +
      "\022Y\n\020ValidateCustomer\022!.customer.Validate" +
      "CustomerRequest\032\".customer.ValidateCusto" +
      "merResponseB\030\n\024com.pm.grpc.customerP\001b\006p" +
      "roto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
          com.pm.grpc.common.Common.getDescriptor(),
        });
    internal_static_customer_CreateCustomerRequest_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_customer_CreateCustomerRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_customer_CreateCustomerRequest_descriptor,
        new java.lang.String[] { "FirstName", "LastName", "Email", "Phone", "DateOfBirth", "CreateDefaultAccount", "DefaultAccountType", "InitialDeposit", });
    internal_static_customer_CreateCustomerResponse_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_customer_CreateCustomerResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_customer_CreateCustomerResponse_descriptor,
        new java.lang.String[] { "CustomerId", "FirstName", "LastName", "Email", "Status", "CreatedDate", "DefaultAccount", "ServiceResponse", });
    internal_static_customer_DefaultAccountInfo_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_customer_DefaultAccountInfo_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_customer_DefaultAccountInfo_descriptor,
        new java.lang.String[] { "AccountId", "AccountNumber", "AccountType", "Balance", });
    internal_static_customer_GetCustomerRequest_descriptor =
      getDescriptor().getMessageTypes().get(3);
    internal_static_customer_GetCustomerRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_customer_GetCustomerRequest_descriptor,
        new java.lang.String[] { "CustomerId", });
    internal_static_customer_GetCustomerResponse_descriptor =
      getDescriptor().getMessageTypes().get(4);
    internal_static_customer_GetCustomerResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_customer_GetCustomerResponse_descriptor,
        new java.lang.String[] { "CustomerId", "FirstName", "LastName", "Email", "Phone", "Status", "CreatedDate", "ServiceResponse", });
    internal_static_customer_UpdateCustomerRequest_descriptor =
      getDescriptor().getMessageTypes().get(5);
    internal_static_customer_UpdateCustomerRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_customer_UpdateCustomerRequest_descriptor,
        new java.lang.String[] { "CustomerId", "FirstName", "LastName", "Email", "Phone", });
    internal_static_customer_UpdateCustomerResponse_descriptor =
      getDescriptor().getMessageTypes().get(6);
    internal_static_customer_UpdateCustomerResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_customer_UpdateCustomerResponse_descriptor,
        new java.lang.String[] { "CustomerId", "FirstName", "LastName", "Email", "Phone", "LastModifiedDate", "ServiceResponse", });
    internal_static_customer_ValidateCustomerRequest_descriptor =
      getDescriptor().getMessageTypes().get(7);
    internal_static_customer_ValidateCustomerRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_customer_ValidateCustomerRequest_descriptor,
        new java.lang.String[] { "CustomerId", });
    internal_static_customer_ValidateCustomerResponse_descriptor =
      getDescriptor().getMessageTypes().get(8);
    internal_static_customer_ValidateCustomerResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_customer_ValidateCustomerResponse_descriptor,
        new java.lang.String[] { "Exists", "FullName", "Status", "ServiceResponse", });
    com.pm.grpc.common.Common.getDescriptor();
  }

  // @@protoc_insertion_point(outer_class_scope)
}
