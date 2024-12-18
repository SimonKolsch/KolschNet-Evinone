package de.kolschnet.evinone.hokebo.api;

import de.kolschnet.evinone.hokebo.api.response.AccountDto;
import de.kolschnet.evinone.hokebo.api.response.NewAccountDto;
import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hokebo/v1/account")
@CrossOrigin
@SuppressWarnings("unused")
public class HokeboApi {

  @GetMapping("/get-all")
  public List<AccountDto> getAllAccounts() {
    return new ArrayList<>();
  }

  @GetMapping("/by-id/{id}")
  public AccountDto getAccountById(@PathVariable(value = "id") Long id) {
    return new AccountDto(1L, "Simon", "123456789012", null);
  }

  @GetMapping("/by-iban/{iban}")
  public AccountDto getAccountByIban(@PathVariable(value = "iban") String iban) {
    return new AccountDto(null, null, null, null);
  }

  @PostMapping("/")
  public void createAccount(@RequestBody NewAccountDto newAccountDto) {

  }

}
