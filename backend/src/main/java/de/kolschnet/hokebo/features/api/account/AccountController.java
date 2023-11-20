package de.kolschnet.hokebo.features.api.account;

import de.kolschnet.hokebo.common.AuditInfo;
import de.kolschnet.hokebo.core.account.AccountFacade;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bank/account")
@Transactional
@RequiredArgsConstructor
@SuppressWarnings("unused")
public class AccountController {

  AccountFacade accountFacade;

  @Autowired
  public AccountController(AccountFacade accountFacade) {
    this.accountFacade = accountFacade;
  }

  @GetMapping("/get-all")
  public List<Account> getAllAccounts() {
    return new ArrayList<>();
  }

  @GetMapping("/by-id/{id}")
  public Account getAccountById(@PathVariable(value = "id") Long id) {
    return Account.of(accountFacade.getById(id));
  }

}
