package de.kolschnet.evinone.hokebo.api.response;

import de.kolschnet.evinone.hokebo.common.AuditInfo;

public record AccountDto(
    Long id,
    String owner,
    String iban,
    AuditInfo auditInfo
) {

}
