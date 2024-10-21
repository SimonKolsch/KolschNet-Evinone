package de.kolschnet.evinone.hokebo.modules.finance.account.value.core;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreRemove;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;


@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "account_value", schema = "hokebo")
public class AccountValue {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @CreatedBy
  @Column(nullable = false)
  private Long createdBy;

  @CreatedDate
  @Column(nullable = false)
  private Instant createdOn;

  @Column(nullable = false)
  @Setter
  private Long accountId;

  @Column(nullable = false)
  @Setter
  private BigDecimal value;

  @Column(nullable = false, length = 3)
  @Setter
  private String currency;

  @Column(nullable = false)
  @Setter
  private LocalDate accountingDate;

  @PrePersist
  public void onPrePersist() {
    audit("INSERT");
  }

  @PreUpdate
  public void onPreUpdate() {
    audit("UPDATE");
  }

  @PreRemove
  public void onPreRemove() {
    audit("DELETE");
  }

  private void audit(String operation) {
    System.out.println(operation);
    createdOn = Instant.now();
    createdBy = 10L;
  }
}
