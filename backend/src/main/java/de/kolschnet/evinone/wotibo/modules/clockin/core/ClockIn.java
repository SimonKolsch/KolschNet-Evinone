package de.kolschnet.evinone.wotibo.modules.clockin.core;

import de.kolschnet.evinone.hokebo.common.util.StatusFlags;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import java.time.Instant;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "clock_in", schema = "wotibo")
public class ClockIn {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false)
  private Long id;

  @Setter
  @NotNull
  @Column(name = "owner", nullable = false, length = Integer.MAX_VALUE)
  private String owner;

  @Setter
  @NotNull
  @Column(name = "clock_in", nullable = false)
  private Instant clockIn;

  @Setter
  @NotNull
  @Column(name = "status_flag", nullable = false)
  @Enumerated(EnumType.STRING)
  private StatusFlags statusFlag;

  @CreatedBy
  @Column(nullable = false)
  private Long createdBy;

  @CreatedDate
  @Column(nullable = false)
  private Instant createdOn;

  @LastModifiedBy
  private Long lastModifiedBy;

  @LastModifiedDate
  private Instant lastModifiedOn;

}