package de.kolschnet.evinone.wotibo.modules.clockin.core;

import de.kolschnet.evinone.hokebo.common.exceptions.EntityNotExists;
import de.kolschnet.evinone.hokebo.common.exceptions.HttpException;
import de.kolschnet.evinone.wotibo.modules.clockin.dto.ClockInDto;
import de.kolschnet.evinone.wotibo.modules.clockin.dto.NewClockInDto;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClockInService {

  ClockInRepository clockInRepository;

  ClockInMapper clockInMapper;

  @Autowired
  public ClockInService(ClockInRepository clockInRepository, ClockInMapper clockInMapper) {
    this.clockInRepository = clockInRepository;
    this.clockInMapper = clockInMapper;
  }

  public List<ClockInDto> getAll() {
    return clockInMapper.toClockInList(clockInRepository.findAll());
  }

  public Long create(NewClockInDto newClockInDto) {
    return clockInRepository.saveAndFlush(clockInMapper.toClockInCreation(newClockInDto)).getId();
  }

  public ClockInDto throwIfIdNotExists(Long id) throws EntityNotExists {
    Optional<ClockIn> entity = clockInRepository.findById(id);
    if (entity.isEmpty()) {
      throw new EntityNotExists("Entity does not exist!", getInfoForException("Id", id));
    }
    return clockInMapper.toClockInDto(entity.get());
  }

  protected HttpException.Info getInfoForException(String type, Object id) {
    return HttpException.info("ClassName", this.getClass().getSimpleName())
        .and(type + ": ", id);
  }
}
