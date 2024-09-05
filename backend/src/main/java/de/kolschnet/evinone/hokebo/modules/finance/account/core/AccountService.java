package de.kolschnet.evinone.hokebo.modules.finance.account.core;

import de.kolschnet.evinone.hokebo.common.exceptions.EntityNotExists;
import de.kolschnet.evinone.hokebo.common.exceptions.HttpException;
import de.kolschnet.evinone.hokebo.modules.finance.account.dto.AccountDto;
import de.kolschnet.evinone.hokebo.modules.finance.account.dto.NewAccountDto;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

  AccountRepository accountRepository;

  AccountMapper accountMapper;

  @Autowired
  public AccountService(AccountRepository accountRepository, AccountMapper accountMapper) {
    this.accountRepository = accountRepository;
    this.accountMapper = accountMapper;
  }

  public List<AccountDto> getAll() {
    return accountMapper.toAccountDtoList(accountRepository.findAll());
  }

  public Long create(NewAccountDto newAccountDto) {
    
    return accountRepository.saveAndFlush(accountMapper.toAccountCreation(newAccountDto)).getId();
  }

  public AccountDto throwIfIdNotExists(Long id) throws EntityNotExists {
    Optional<Account> entity = accountRepository.findById(id);
    if (entity.isEmpty()) {
      throw new EntityNotExists("Entity does not exist!", getInfoForException("Id", id));
    }
    return accountMapper.toAccountDto(entity.get());
  }

  public AccountDto throwIfIbanNotExists(String iban) throws EntityNotExists  {
    Optional<Account> entity = accountRepository.findByIban(iban);
    if (entity.isEmpty()) {
      throw new EntityNotExists("Entity does not exist!", getInfoForException("Iban", iban));
    }
    return accountMapper.toAccountDto(entity.get());
  }

  protected HttpException.Info getInfoForException(String type, Object id) {
    return HttpException.info("ClassName", this.getClass().getSimpleName())
        .and(type + ": ", id);
  }
}
