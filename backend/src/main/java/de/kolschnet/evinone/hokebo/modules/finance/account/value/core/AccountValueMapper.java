package de.kolschnet.evinone.hokebo.modules.finance.account.value.core;

import de.kolschnet.evinone.hokebo.common.AuditInfo;
import de.kolschnet.evinone.hokebo.modules.finance.account.value.dto.AccountValueDto;
import de.kolschnet.evinone.hokebo.modules.finance.account.value.dto.NewAccountValue;
import java.time.LocalDate;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class AccountValueMapper {

  public AccountValueDto toAccountValueDto(AccountValue accountValue) {
    return new AccountValueDto(
        accountValue.getId(),
        accountValue.getAccountId(),
        accountValue.getValue(),
        accountValue.getCurrency(),
        accountValue.getAccountingDate(),
        new AuditInfo(
            accountValue.getCreatedOn(),
            accountValue.getCreatedBy(),
            null,
            null
        )
    );
  }

  public List<AccountValueDto> toAccountValueDtoList(List<AccountValue> accountValues) {
    return accountValues.stream().map(this::toAccountValueDto).toList();
  }

  public AccountValue toAccountValueCreation(NewAccountValue newAccountValue) {
    AccountValue accountValue = new AccountValue();
    accountValue.setAccountId(newAccountValue.accountId());
    accountValue.setValue(newAccountValue.value());
    accountValue.setCurrency(newAccountValue.currency());
    accountValue.setAccountingDate(LocalDate.now());
    return accountValue;
  }

}
