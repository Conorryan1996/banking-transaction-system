package com.pm.transactionservice.kafka;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Slf4j
@Service
@RequiredArgsConstructor
public class TransactionEventProducer {
    
    private static final String TOPIC_NAME = "transaction-events";
    
    private final KafkaTemplate<String, TransactionEvent> kafkaTemplate;
    
    public void sendTransactionEvent(TransactionEvent event) {
        log.info("Sending transaction event to Kafka: {}", event.getTransactionId());
        
        CompletableFuture<SendResult<String, TransactionEvent>> future = 
            kafkaTemplate.send(TOPIC_NAME, event.getTransactionId().toString(), event);
        
        future.whenComplete((result, ex) -> {
            if (ex != null) {
                log.error("Failed to send transaction event: {}", event.getTransactionId(), ex);
            } else {
                log.info("Successfully sent transaction event: {} with offset: {}", 
                    event.getTransactionId(), result.getRecordMetadata().offset());
            }
        });
    }
}