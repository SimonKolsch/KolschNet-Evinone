package de.kolschnet.hokebo.core.account;

import java.time.Instant;

public record AccountDto (
    Long id,

    Long createdBy,

    Instant createdDate,

    Long lastModifiedBy,

    Instant lastModifiedDate,

    String owner,
    String iban) {

    static AccountDto of(AccountEntity account) {
        return new AccountDto(
            account.getId(),
            account.getCreatedBy(),
            account.getCreatedDate(),
            account.getLastModifiedBy(),
            account.getLastModifiedDate(),
            account.getOwner(),
            account.getIban()
        );
    }
}
