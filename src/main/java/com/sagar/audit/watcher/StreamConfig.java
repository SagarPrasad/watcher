package com.sagar.audit.watcher;


import com.sagar.audit.watcher.domain.AuditMessage;
import com.sagar.audit.watcher.producer.AuditMsgStream;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.context.annotation.Configuration;

//@Configuration
//@EnableBinding(AuditMsgStream.class)
public class StreamConfig {
  public static void main(String[] args) {
    List<AuditMessage> auditMessages = new ArrayList<>();
    for (int i=0; i < 10; i++) {
      auditMessages.add(new AuditMessage(UUID.randomUUID().toString(), i + " Msg"));
    }
    System.out.println(auditMessages);
  }
}
