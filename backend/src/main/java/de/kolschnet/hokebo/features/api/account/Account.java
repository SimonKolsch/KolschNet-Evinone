package de.kolschnet.hokebo.features.api.account;

import de.kolschnet.hokebo.common.AuditInfo;
import de.kolschnet.hokebo.core.account.AccountDto;
import java.util.List;

public record Account(Long id, String owner, String iban, AuditInfo auditInfo) {
  static Account of(AccountDto accountDto) {
    return new Account(
        accountDto.id(),
        accountDto.owner(),
        accountDto.iban(),
        new AuditInfo(
            accountDto.createdDate(),
            accountDto.createdBy(),
            accountDto.lastModifiedDate(),
            accountDto.lastModifiedBy()
        )
    );
  }

  static List<Account> of(List<AccountDto> accountDtoList) {
    return accountDtoList.stream().map(Account::of).toList();
  }
}
