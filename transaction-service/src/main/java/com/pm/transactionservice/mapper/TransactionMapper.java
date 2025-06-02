package com.pm.transactionservice.mapper;

import com.pm.transactionservice.dto.TransactionResponseDTO;
import com.pm.transactionservice.model.Transaction;

public class TransactionMapper {

    public static TransactionResponseDTO toDTO(Transaction transaction) {
        TransactionResponseDTO dto = new TransactionResponseDTO();
        dto.setId(transaction.getId().toString());
        dto.setAccountId(transaction.getAccountId().toString());
        dto.setCustomerId(transaction.getCustomerId().toString());
        if (transaction.getTargetAccountId() != null) {
            dto.setTargetAccountId(transaction.getTargetAccountId().toString());
        }
        dto.setTransactionType(transaction.getTransactionType().toString());
        dto.setAmount(transaction.getAmount().toString());
        dto.setDescription(transaction.getDescription());
        dto.setReferenceNumber(transaction.getReferenceNumber());
        dto.setStatus(transaction.getStatus().toString());
        dto.setPreviousBalance(transaction.getPreviousBalance().toString());
        dto.setNewBalance(transaction.getNewBalance().toString());
        dto.setProcessedDate(transaction.getProcessedDate().toString());
        if (transaction.getScheduledDate() != null) {
            dto.setScheduledDate(transaction.getScheduledDate().toString());
        }
        return dto;
    }
}