package de.kolschnet.evinone.hokebo.modules.finance.account.value.facade;

import de.kolschnet.evinone.hokebo.modules.finance.account.value.core.AccountValueService;
import de.kolschnet.evinone.hokebo.modules.finance.account.value.dto.AccountValueDto;
import de.kolschnet.evinone.hokebo.modules.finance.account.value.dto.NewAccountValue;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountValueFacade {

  AccountValueService accountValueService;

  @Autowired
  public AccountValueFacade(AccountValueService accountValueService) {
    this.accountValueService = accountValueService;
  }

  public List<AccountValueDto> getAllByAccountId(Long accountId) {
    return accountValueService.getAllByAccountId(accountId);
  }

  public AccountValueDto getCurrentValidByAccountId(Long accountId) {
    return accountValueService.getCurrentValidByAccountId(accountId);
  }

  public Long createAccountValue(NewAccountValue newAccountValue) {
    return accountValueService.create(newAccountValue);
  }

}
