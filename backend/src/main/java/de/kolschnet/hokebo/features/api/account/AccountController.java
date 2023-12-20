package de.kolschnet.hokebo.features.api.account;

import de.kolschnet.hokebo.core.account.AccountDto;
import de.kolschnet.hokebo.core.account.AccountFacade;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bank/account")
@Transactional
@RequiredArgsConstructor
@CrossOrigin
@SuppressWarnings("unused")
public class AccountController {

  AccountFacade accountFacade;

  @Autowired
  public AccountController(AccountFacade accountFacade) {
    this.accountFacade = accountFacade;
  }

  @GetMapping("/get-all")
  public List<Account> getAllAccounts() {
    return Account.of(accountFacade.getAll());
  }

  @GetMapping("/by-id/{id}")
  public Account getAccountById(@PathVariable(value = "id") Long id) {
    return Account.of(accountFacade.getById(id));
  }

  @PostMapping("/")
  public void createAccount(@RequestBody NewAccount newAccount) {
    accountFacade.createAccount(newAccount.owner(), newAccount.iban());
  }

}
