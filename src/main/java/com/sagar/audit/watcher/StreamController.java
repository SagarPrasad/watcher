package com.sagar.audit.watcher;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sagar.audit.watcher.domain.AuditMessage;
import com.sagar.audit.watcher.repo.AuditMessageRepository;
import io.cloudevents.CloudEvent;
import io.cloudevents.core.builder.CloudEventBuilder;
import io.cloudevents.core.data.PojoCloudEventData;
import io.micrometer.core.annotation.Timed;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StreamController {
  @Autowired
  ObjectMapper objectMapper;

  @Autowired
  StreamBridge streamBridge;

  @Autowired
  AuditMessageRepository auditMessageRepository;

  @PostMapping("/publish")
  public String postMessage(@RequestBody String msg) {
    AuditMessage auditMessage = new AuditMessage();
    auditMessage.setName(msg);
    CloudEvent event = CloudEventBuilder.v1()
        .withId("hello")
        .withType("example.kafka")
        .withData("application/json", PojoCloudEventData.wrap(auditMessage, objectMapper::writeValueAsBytes))
        .withSource(URI.create("http://localhost"))
        .build();
    //boolean sent = streamBridge.send("producer-out-0", message(event));
    //insertIntoDB();
    return "done";
  }

/*  @Timed
  private void insertIntoDB() {
    System.out.println("Starting Inserting all 10000 rec");
    for (int i=0; i < 10000; i++) {
      AuditMessage auditMessage = new AuditMessage(UUID.randomUUID().toString(), "msg_" + i);
      auditMessageRepository.save(auditMessage);
    }
    System.out.println("Inserted all 10000 rec");
  }*/

  @Timed
  private void insertIntoDB() {
    System.out.println("Starting Inserting all 10000 rec");
    long t = System.currentTimeMillis();
    List<AuditMessage> auditMessageList = new ArrayList<>();
    for (int i=0; i < 10000; i++) {
      AuditMessage auditMessage = new AuditMessage();
      auditMessage.setName("msg_" + i);
      auditMessageList.add(auditMessage);
    }
    auditMessageRepository.saveAll(auditMessageList);
    System.out.println("Inserted all 10000 rec - " + (System.currentTimeMillis() - t));
  }

  private static final <T> Message<T> message(T val) {
    return MessageBuilder.withPayload(val).build();
  }
}
