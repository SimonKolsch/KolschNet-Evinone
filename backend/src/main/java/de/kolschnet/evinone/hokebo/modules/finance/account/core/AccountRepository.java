package de.kolschnet.evinone.hokebo.modules.finance.account.core;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

  Optional<Account> findByIban(String iban);
}
