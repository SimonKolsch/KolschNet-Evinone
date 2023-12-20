package de.kolschnet.hokebo.core.account;
public record NewAccountDto(
    String owner, String iban) {

    static NewAccountDto of(String owner, String iban) {
        return new NewAccountDto(
            owner,
            iban
        );
    }
}
