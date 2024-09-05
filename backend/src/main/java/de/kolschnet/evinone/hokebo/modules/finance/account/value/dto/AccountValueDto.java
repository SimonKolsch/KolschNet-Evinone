package de.kolschnet.evinone.hokebo.modules.finance.account.value.dto;

import de.kolschnet.evinone.hokebo.common.AuditInfo;
import java.math.BigDecimal;
import java.time.LocalDate;

public record AccountValueDto(
    Long id,
    Long accountId,
    BigDecimal value,
    String currency,
    LocalDate accountingDate,
    AuditInfo auditInfo
) {}
