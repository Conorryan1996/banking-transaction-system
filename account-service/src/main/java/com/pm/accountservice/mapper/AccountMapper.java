package com.pm.accountservice.mapper;

import com.pm.accountservice.dto.AccountResponseDTO;
import com.pm.accountservice.model.Account;

public class AccountMapper {

    public static AccountResponseDTO toDTO(Account account) {
        AccountResponseDTO dto = new AccountResponseDTO();
        dto.setId(account.getId().toString());
        dto.setAccountNumber(account.getAccountNumber());
        dto.setCustomerId(account.getCustomerId().toString());
        dto.setAccountType(account.getAccountType().toString());
        dto.setBalance(account.getBalance().toString());
        dto.setStatus(account.getStatus().toString());
        dto.setCreatedDate(account.getCreatedDate().toString());
        return dto;
    }
}