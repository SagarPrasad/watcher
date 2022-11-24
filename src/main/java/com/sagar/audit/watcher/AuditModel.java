package com.sagar.audit.watcher;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "audit")
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper=false)
public class AuditModel {

  public AuditModel(String id, String name) {
    this.id = id;
    this.name = name;
  }

  @Id
  @Column(name = "ID", nullable = false)
  private String id;
  @Column(name = "NAME")
  private String name;
  @Column(name = "CREATED_AT", nullable = false, updatable = false)
  @CreationTimestamp
  private Date created_at;

}
