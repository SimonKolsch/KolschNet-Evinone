package de.kolschnet.evinone.wotibo.modules.clockin.dto;

import de.kolschnet.evinone.hokebo.common.AuditInfo;
import de.kolschnet.evinone.hokebo.common.util.StatusFlags;
import java.time.Instant;

public record ClockInDto(
    Long id,
    String owner,
    Instant clockIn,
    StatusFlags statusFlags,
    AuditInfo auditInfo
) {

}
