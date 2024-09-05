package de.kolschnet.evinone.hokebo.modules.finance.account.core;

import de.kolschnet.evinone.hokebo.common.AuditInfo;
import de.kolschnet.evinone.hokebo.modules.finance.account.dto.AccountDto;
import de.kolschnet.evinone.hokebo.modules.finance.account.dto.NewAccountDto;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class AccountMapper {

  public AccountDto toAccountDto(Account account) {
    return new AccountDto(
        account.getId(),
        account.getOwner(),
        account.getIban(),
        new AuditInfo(
            account.getCreatedOn(),
            account.getCreatedBy(),
            account.getLastModifiedOn(),
            account.getLastModifiedBy()
        )
    );
  }

  public List<AccountDto> toAccountDtoList(List<Account> accountList) {
    return accountList.stream().map(this::toAccountDto).toList();
  }

  public Account toAccountCreation(NewAccountDto newAccountDto) {
    Account account = new Account();
    account.setIban(newAccountDto.iban());
    account.setOwner(newAccountDto.owner());
    return account;
  }
}
