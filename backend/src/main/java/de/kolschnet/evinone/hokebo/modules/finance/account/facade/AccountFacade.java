package de.kolschnet.evinone.hokebo.modules.finance.account.facade;

import de.kolschnet.evinone.hokebo.common.exceptions.EntityNotExists;
import de.kolschnet.evinone.hokebo.modules.finance.account.core.AccountService;
import de.kolschnet.evinone.hokebo.modules.finance.account.dto.AccountDto;
import de.kolschnet.evinone.hokebo.modules.finance.account.dto.NewAccountDto;
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

  public AccountDto getById(Long id) throws EntityNotExists {
    return accountService.throwIfIdNotExists(id);
  }

  public void validateAccountId(Long id) throws EntityNotExists  {
    accountService.throwIfIdNotExists(id);
  }

  public AccountDto getByIban(String iban) throws EntityNotExists  {
    return accountService.throwIfIbanNotExists(iban);
  }

  public List<AccountDto> getAll() {
    return accountService.getAll();
  }

  public Long createAccount(NewAccountDto newAccountDto) {
    return accountService.create(newAccountDto);
  }
}
