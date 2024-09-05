package de.kolschnet.evinone.hokebo.modules.finance.account.value.core;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountValueRepository extends JpaRepository<AccountValue, Long> {

  List<AccountValue> getAllByAccountId(Long accountId);

  AccountValue findFirstByAccountIdOrderByAccountingDateDesc(Long accountId);
}
