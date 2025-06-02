package com.pm.apigateway.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import reactor.core.publisher.Mono;

@Configuration
@Slf4j
public class GatewayConfig {
    
    @Bean
    @Order(-1)
    public GlobalFilter customGlobalFilter() {
        return (exchange, chain) -> {
            log.info("Request Path: {}", exchange.getRequest().getPath());
            log.info("Request Method: {}", exchange.getRequest().getMethod());
            log.info("Request Headers: {}", exchange.getRequest().getHeaders());
            
            return chain.filter(exchange).then(Mono.fromRunnable(() -> {
                log.info("Response Status Code: {}", exchange.getResponse().getStatusCode());
            }));
        };
    }
}