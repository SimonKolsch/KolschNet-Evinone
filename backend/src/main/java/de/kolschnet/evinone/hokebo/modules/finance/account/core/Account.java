package de.kolschnet.evinone.hokebo.modules.finance.account.core;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreRemove;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
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
@Table(name = "account", schema = "public")
public class Account {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

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

  @Column(nullable = false)
  @Setter
  private String owner;

  @Column(nullable = false, length = 22)
  @Setter
  private String iban;

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
