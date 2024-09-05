package de.kolschnet.evinone.hokebo.modules.finance.account.value.core;

import de.kolschnet.evinone.hokebo.modules.finance.account.facade.AccountFacade;
import de.kolschnet.evinone.hokebo.modules.finance.account.value.dto.AccountValueDto;
import de.kolschnet.evinone.hokebo.modules.finance.account.value.dto.NewAccountValue;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class AccountValueService {

  private final AccountValueRepository accountValueRepository;

  private final AccountValueMapper accountValueMapper;

  private final AccountFacade accountFacade;

  public AccountValueService(AccountValueRepository accountValueRepository, AccountValueMapper accountValueMapper,
      AccountFacade accountFacade) {
    this.accountValueRepository = accountValueRepository;
    this.accountValueMapper = accountValueMapper;
    this.accountFacade = accountFacade;
  }

  public List<AccountValueDto> getAllByAccountId(Long accountId) {
    return accountValueMapper.toAccountValueDtoList(accountValueRepository.getAllByAccountId(accountId));
  }

  public AccountValueDto getCurrentValidByAccountId(Long accountId) {
    return accountValueMapper.toAccountValueDto(accountValueRepository.findFirstByAccountIdOrderByAccountingDateDesc(accountId));
  }

  public Long create(NewAccountValue newAccountValue) {
    accountFacade.validateAccountId(newAccountValue.accountId());
    return accountValueRepository.saveAndFlush(accountValueMapper.toAccountValueCreation(newAccountValue)).getId();
  }

}
