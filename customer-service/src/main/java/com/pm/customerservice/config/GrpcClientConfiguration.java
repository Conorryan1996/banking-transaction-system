package com.pm.customerservice.config;

import net.devh.boot.grpc.client.interceptor.GrpcGlobalClientInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;
import io.grpc.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Configuration
public class GrpcClientConfiguration {

    private static final Logger logger = LoggerFactory.getLogger(GrpcClientConfiguration.class);

    @GrpcGlobalClientInterceptor
    ClientInterceptor logGrpcInterceptor() {
        return new ClientInterceptor() {
            @Override
            public <ReqT, RespT> ClientCall<ReqT, RespT> interceptCall(
                    MethodDescriptor<ReqT, RespT> method,
                    CallOptions callOptions,
                    Channel next) {

                logger.debug("gRPC call: {}", method.getFullMethodName());
                return next.newCall(method, callOptions);
            }
        };
    }
}