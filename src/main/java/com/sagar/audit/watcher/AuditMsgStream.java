package com.sagar.audit.watcher;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.SubscribableChannel;
import org.springframework.messaging.MessageChannel;


public interface AuditMsgStream {
  String INPUT = "audit";
  String OUTPUT = "audit";

  @Input(INPUT)
  SubscribableChannel recieveMsg();

  @Output(OUTPUT)
  MessageChannel sendMsg();

}
//TODO: check for batch / group / DLQ / etc
//TODO: change to cloud event
