package de.kolschnet.evinone.hokebo.jobs;

import de.kolschnet.evinone.hokebo.modules.finance.account.facade.AccountFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountValueCalculation {

  private final AccountFacade accountFacade;

  @Autowired
  public AccountValueCalculation(AccountFacade accountFacade) {
    this.accountFacade = accountFacade;
  }
}
