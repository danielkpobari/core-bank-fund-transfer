package com.corebank.corebankfundtransfer.service;

import com.corebank.corebankfundtransfer.model.TransactionStatus;
import com.corebank.corebankfundtransfer.model.dto.FundTransfer;
import com.corebank.corebankfundtransfer.model.dto.reponse.FundTransferResponse;
import com.corebank.corebankfundtransfer.model.dto.request.FundTransferRequest;
import com.corebank.corebankfundtransfer.model.entity.FundTransferEntity;
import com.corebank.corebankfundtransfer.model.mapper.FundTransferMapper;
import com.corebank.corebankfundtransfer.repository.FundTransferRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Slf4j
@RequiredArgsConstructor
@Service
public class FundTransferService {
    private final FundTransferRepository fundTransferRepository;

    private FundTransferMapper mapper = new FundTransferMapper();

    public FundTransferResponse fundTransfer(FundTransferRequest request) {
        log.info("Sending fund transfer request {}" + request.toString());
        FundTransferEntity entity = new FundTransferEntity();
        BeanUtils.copyProperties(request, entity);
        entity.setStatus(TransactionStatus.PENDING);
        FundTransferEntity optFundTransfer = fundTransferRepository.save(entity);
        FundTransferResponse fundTransferResponse = new FundTransferResponse();
        fundTransferResponse.setTransactionId(UUID.randomUUID().toString());
        fundTransferResponse.setMessage("Success");
        return fundTransferResponse;
    }
    public List<FundTransfer> readAllTransfers(Pageable pageable) {
        return mapper.convertToDtoList(fundTransferRepository.findAll(pageable).getContent());
    }


}
