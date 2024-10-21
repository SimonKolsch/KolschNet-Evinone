package de.kolschnet.evinone.wotibo.modules.clockin.dto;

import java.time.Instant;

public record NewClockInDto(
    String owner,
    Instant clockIn
) {
}
