package com.sagar.audit.watcher.producer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sagar.audit.watcher.domain.AuditMessage;
import io.cloudevents.CloudEvent;
import io.cloudevents.core.builder.CloudEventBuilder;
import io.cloudevents.core.data.PojoCloudEventData;
import java.net.URI;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class AuditServiceImpl implements AuditService {

  //@Autowired
  AuditMsgStream auditMsgStream;

  @Autowired
  ObjectMapper objectMapper;


  @Override
  public boolean sendData(String data) {
    AuditMessage auditMessage = new AuditMessage();
    auditMessage.setName(UUID.randomUUID().toString());
    CloudEvent event = CloudEventBuilder.v1()
        .withId("hello")
        .withType("example.kafka")
        .withData("application/json", PojoCloudEventData.wrap(auditMessage, objectMapper::writeValueAsBytes))
        .withSource(URI.create("http://localhost"))
        .build();
    return auditMsgStream.sendMsg().send(message(event));
  }
  private static final <T> Message<T> message(T val) {
    return MessageBuilder.withPayload(val).build();
  }
}
