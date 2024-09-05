package de.kolschnet.evinone.hokebo.modules.finance.account.dto;

import de.kolschnet.evinone.hokebo.common.AuditInfo;

public record AccountDto(
    Long id,
    String owner,
    String iban,
    AuditInfo auditInfo
) {

}
