package de.kolschnet.evinone.hokebo.modules.finance.account.value.dto;

import java.math.BigDecimal;

public record NewAccountValue(
    Long accountId,
    BigDecimal value,
    String currency
) {}
