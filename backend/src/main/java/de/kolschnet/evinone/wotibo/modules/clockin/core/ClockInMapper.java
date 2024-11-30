package de.kolschnet.evinone.wotibo.modules.clockin.core;

import de.kolschnet.evinone.hokebo.common.AuditInfo;
import de.kolschnet.evinone.hokebo.common.util.StatusFlags;
import de.kolschnet.evinone.hokebo.modules.finance.account.core.Account;
import de.kolschnet.evinone.hokebo.modules.finance.account.dto.AccountDto;
import de.kolschnet.evinone.hokebo.modules.finance.account.dto.NewAccountDto;
import de.kolschnet.evinone.wotibo.modules.clockin.dto.ClockInDto;
import de.kolschnet.evinone.wotibo.modules.clockin.dto.NewClockInDto;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class ClockInMapper {

  public ClockInDto toClockInDto(ClockIn clockIn) {
    return new ClockInDto(
        clockIn.getId(),
        clockIn.getOwner(),
        clockIn.getClockIn(),
        clockIn.getStatusFlag(),
        new AuditInfo(
            clockIn.getCreatedOn(),
            clockIn.getCreatedBy(),
            clockIn.getLastModifiedOn(),
            clockIn.getLastModifiedBy()
        )
    );
  }

  public List<ClockInDto> toClockInList(List<ClockIn> clockInList) {
    return clockInList.stream().map(this::toClockInDto).toList();
  }

  public ClockIn toClockInCreation(NewClockInDto newClockInDto) {
    ClockIn clockIn = new ClockIn();

    clockIn.setOwner(newClockInDto.owner());
    clockIn.setClockIn(newClockInDto.clockIn());
    clockIn.setStatusFlag(StatusFlags.OPEN);

    return clockIn;
  }
}
