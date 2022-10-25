package com.sagar.audit.watcher.producer;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.SubscribableChannel;
import org.springframework.messaging.MessageChannel;


public interface AuditMsgStream {
  String OUTPUT = "audit";

  @Output(OUTPUT)
  MessageChannel sendMsg();

}
//TODO: check for batch / group / DLQ / etc
