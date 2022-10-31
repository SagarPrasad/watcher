package com.sagar.audit.watcher;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sagar.audit.watcher.domain.AuditMessage;
import io.cloudevents.CloudEvent;
import io.cloudevents.CloudEventData;
import io.cloudevents.core.builder.CloudEventBuilder;
import io.cloudevents.core.data.PojoCloudEventData;
import java.net.URI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.function.cloudevent.CloudEventMessageBuilder;
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

  @PostMapping("/publish")
  public String postMessage(@RequestBody String msg) {
    AuditMessage auditMessage = new AuditMessage();
    auditMessage.setName(msg);
   /* CloudEvent event = CloudEventBuilder.v1()
        .withId("hello")
        .withType("example.kafka")
        .withData("application/json", new CloudEventData())
        .withSource(URI.create("http://localhost"))
            .withDataContentType("application/json")
        .build();*/
    Message event = CloudEventMessageBuilder.withData(auditMessage).setId("123456")
				.setSource(URI.create("https://spring.cloudevenets.sample")).build();
    boolean sent = streamBridge.send("producer-out-0", event);
    return "done";
  }


  private static final <T> Message<T> message(T val) {
    return MessageBuilder.withPayload(val).build();
  }
}
