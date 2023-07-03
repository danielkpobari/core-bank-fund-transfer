package com.corebank.corebankfundtransfer.model.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class FundTransfer {
    private Long id;
    private String transactionReference;
    private String fromAccount;
    private String toAccount;
    private BigDecimal amount;
    private String status;
}
