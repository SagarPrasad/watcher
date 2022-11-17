package com.sagar.audit.watcher.domain;

import java.util.Date;
import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper=false)
public class AuditMessage extends BaseMonitoringMessage {

  // read from the caller method.
  private String serviceName;
  private String operationName;

  // Auto Populated
  private Date createdAt;

  // TObe set manually
  private String destinationSystem;
  private Date msgTime;
  private String businessKey;
  private String businessIdentifier;
  private String payload;

  // can be filled from utility
  private String topicName;


  /// Can be a separate message and conditionally activated
  // Alert or Audit
  private String type;
  //failed or succcess or ...
  private String status;
  // status code
  private String statusCode;

  private Map meta;

}
