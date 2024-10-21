package de.kolschnet.evinone.wotibo.modules.timetable.core;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
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
@Table(name = "timetable", schema = "wotibo")
public class Timetable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false)
  private Long id;

  @NotNull
  @Column(name = "owner", nullable = false, length = Integer.MAX_VALUE)
  private String owner;

  @NotNull
  @Column(name = "work_start", nullable = false)
  private Instant workStart;

  @NotNull
  @Column(name = "work_end", nullable = false)
  private Instant workEnd;

  @NotNull
  @Column(name = "work_time", nullable = false)
  private Integer workTime;

  @NotNull
  @Column(name = "pause_time", nullable = false)
  private Integer pauseTime;

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