package com.sagar.audit.watcher;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sagar.audit.watcher.domain.AuditMessage;
import com.sagar.audit.watcher.repo.AuditMessageRepository;
import io.cloudevents.CloudEvent;
import io.cloudevents.core.data.PojoCloudEventData;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;
import io.cloudevents.jackson.PojoCloudEventDataMapper;

import static io.cloudevents.core.CloudEventUtils.mapData;


@Component
public class MsgStreamListener {
  @Autowired
  AuditMessageRepository auditMessageRepository;
  @Autowired
  ObjectMapper objectMapper;

  //@StreamListener("audit")
  public void handleAuditMsg(@Payload CloudEvent msg, @Headers Map<String, Object> headers) {
    //System.out.println("msg recived count" + msgList.size());
    //msgList.stream().forEach(msg -> {
      PojoCloudEventData<AuditMessage> cloudEventData = mapData(msg, PojoCloudEventDataMapper.from(objectMapper, AuditMessage.class));
      System.out.println(System.currentTimeMillis() + " -- msg data name " + cloudEventData.getValue().getName());
      System.out.println(System.currentTimeMillis() + " -- msg data name " + cloudEventData.getValue());
      System.out.println(System.currentTimeMillis() + " -- msg data name " + cloudEventData);
    //});
    //auditMessageRepository.save(cloudEventData.getValue());
    //headers.get(KafkaHeaders.RECEIVED_PARTITION_ID), headers.get(KafkaHeaders.OFFSET));
  }

  // Do we need this or we should use the functional bean to read the message
/*
  @Bean
  public ListenerContainerCustomizer<AbstractMessageListenerContainer<?, ?>> customizer() {
    return (container, dest, group) -> container.getContainerProperties().setIdleBetweenPolls(10000);
  }
*/

}
