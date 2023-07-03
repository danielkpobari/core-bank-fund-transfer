package com.corebank.corebankfundtransfer.model.dto.reponse;

import lombok.Data;

@Data
public class FundTransferResponse {
    private String transactionId;
    private String message;
}
