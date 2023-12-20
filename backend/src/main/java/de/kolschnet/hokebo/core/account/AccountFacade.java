package de.kolschnet.hokebo.core.account;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountFacade {
  AccountService accountService;

  @Autowired
  public AccountFacade(AccountService accountService) {
    this.accountService = accountService;
  }

  public AccountDto getById(Long id) {
    return accountService.throwIfNotExists(id);
  }

  public List<AccountDto> getAll() {
    return accountService.getAll();
  }

  public void createAccount(String owner, String iban) {
    accountService.create(NewAccountDto.of(owner, iban));
  }
}
