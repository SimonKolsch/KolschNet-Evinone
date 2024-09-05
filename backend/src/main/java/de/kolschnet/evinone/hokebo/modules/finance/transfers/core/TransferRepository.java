package de.kolschnet.evinone.hokebo.modules.finance.transfers.core;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransferRepository extends JpaRepository<Transfer, Long> {

  List<Transfer> findAllByCreditAccountId(Long creditAccountId);

  List<Transfer> findAllByDebitAccountId(Long debitAccountId);
}
