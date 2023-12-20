package de.kolschnet.hokebo.core.account;

import de.kolschnet.hokebo.common.exceptions.EntityNotExists;
import de.kolschnet.hokebo.common.exceptions.HttpException;
import java.util.List;
import java.util.Optional;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

  AccountRepository accountRepository;

  @Autowired
  public AccountService(AccountRepository accountRepository) {
    this.accountRepository = accountRepository;
  }

  public AccountDto throwIfNotExists(Long id) {
    Optional<AccountEntity> entity = accountRepository.findById(id);
    if (entity.isEmpty()) {
      throw new EntityNotExists("Entity does not exist!", getInfoForException(id));
    }
    return AccountDto.of(entity.get());
  }

  protected HttpException.Info getInfoForException(Long id) {
    return HttpException.info("ClassName", this.getClass().getSimpleName())
        .and("Id", id);
  }

  public List<AccountDto> getAll() {
    return AccountDto.of(accountRepository.findAll());
  }

  public void create(NewAccountDto newAccountDto) {
    AccountEntity accountEntity = new AccountEntity();
    accountEntity.setIban(newAccountDto.iban());
    accountEntity.setOwner(newAccountDto.owner());
    accountRepository.saveAndFlush(accountEntity);
  }
}
