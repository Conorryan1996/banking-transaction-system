package com.pm.transactionservice.dto;

public class TransactionResponseDTO {

    private String id;
    private String accountId;
    private String customerId;
    private String targetAccountId;
    private String transactionType;
    private String amount;
    private String description;
    private String referenceNumber;
    private String status;
    private String previousBalance;
    private String newBalance;
    private String processedDate;
    private String scheduledDate;

    // Getters and setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getAccountId() { return accountId; }
    public void setAccountId(String accountId) { this.accountId = accountId; }

    public String getCustomerId() { return customerId; }
    public void setCustomerId(String customerId) { this.customerId = customerId; }

    public String getTargetAccountId() { return targetAccountId; }
    public void setTargetAccountId(String targetAccountId) { this.targetAccountId = targetAccountId; }

    public String getTransactionType() { return transactionType; }
    public void setTransactionType(String transactionType) { this.transactionType = transactionType; }

    public String getAmount() { return amount; }
    public void setAmount(String amount) { this.amount = amount; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getReferenceNumber() { return referenceNumber; }
    public void setReferenceNumber(String referenceNumber) { this.referenceNumber = referenceNumber; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public String getPreviousBalance() { return previousBalance; }
    public void setPreviousBalance(String previousBalance) { this.previousBalance = previousBalance; }

    public String getNewBalance() { return newBalance; }
    public void setNewBalance(String newBalance) { this.newBalance = newBalance; }

    public String getProcessedDate() { return processedDate; }
    public void setProcessedDate(String processedDate) { this.processedDate = processedDate; }

    public String getScheduledDate() { return scheduledDate; }
    public void setScheduledDate(String scheduledDate) { this.scheduledDate = scheduledDate; }
}