package com.pm.fraudservice.kafka;

import com.pm.fraudservice.service.FraudDetectionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class TransactionEventConsumer {
    
    private final FraudDetectionService fraudDetectionService;
    
    @KafkaListener(topics = "transaction-events", groupId = "fraud-service")
    public void consumeTransactionEvent(
            @Payload TransactionEvent event,
            @Header(KafkaHeaders.RECEIVED_TOPIC) String topic,
            @Header(KafkaHeaders.RECEIVED_PARTITION) int partition,
            @Header(KafkaHeaders.OFFSET) long offset,
            Acknowledgment acknowledgment) {
        
        log.info("Received transaction event: {} from topic: {}, partition: {}, offset: {}", 
                event.getTransactionId(), topic, partition, offset);
        
        try {
            // Process the transaction event
            fraudDetectionService.processTransactionEvent(event);
            
            // Acknowledge the message
            acknowledgment.acknowledge();
            
            log.info("Successfully processed transaction event: {}", event.getTransactionId());
        } catch (Exception e) {
            log.error("Error processing transaction event: {}", event.getTransactionId(), e);
            // In production, implement retry logic or dead letter queue
            // For now, acknowledge to avoid reprocessing
            acknowledgment.acknowledge();
        }
    }
}