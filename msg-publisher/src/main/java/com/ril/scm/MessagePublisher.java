package com.ril.scm;

import java.net.URI;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.function.cloudevent.CloudEventMessageBuilder;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.messaging.Message;

public class MessagePublisher {
  @Autowired
  StreamBridge streamBridge;

  @Autowired
  WatcherProperties watcherProperties;

  @Value("${a.b}")
  private String producerBinderName;

  public boolean sendMsg(Map<String, String> header) {
    CloudEventMessageBuilder<String> stringCloudEventMessageBuilder = CloudEventMessageBuilder
            .withData("auditMessage")
            .setId("123456")
            .setSource(watcherProperties.getSource())
            .setHeader("queue", "name");
    updateMap(stringCloudEventMessageBuilder, header);
    Message<String> event = stringCloudEventMessageBuilder.build();
    return streamBridge.send(producerBinderName, event);
  }

  private void updateMap(CloudEventMessageBuilder<String> msgBuilder, Map<String, String> header) {
    if (null != header && header.size() > 0) {
      // loop header and update
      //header.entrySet().
      //msgBuilder.setHeader()
      // How to read the msg headers for cloud events.
    }
  }
}
