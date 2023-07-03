package com.corebank.corebankfundtransfer.repository;

import com.corebank.corebankfundtransfer.model.entity.FundTransferEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FundTransferRepository extends JpaRepository<FundTransferEntity, Long> {
}
