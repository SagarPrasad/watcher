package com.sagar.audit.watcher;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.cloudevents.CloudEvent;
import io.cloudevents.core.data.PojoCloudEventData;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;
import io.cloudevents.jackson.PojoCloudEventDataMapper;

import static io.cloudevents.core.CloudEventUtils.mapData;


@Component
public class StreamListner {
  @Autowired
  ObjectMapper objectMapper;

  @StreamListener(AuditMsgStream.INPUT)
  public void handleAuditMsg(@Payload CloudEvent msg, @Headers Map<String, Object> headers) {
    System.out.println("msg recived " + msg);
    PojoCloudEventData<AuditMessage> cloudEventData = mapData(msg, PojoCloudEventDataMapper.from(objectMapper, AuditMessage.class));
    System.out.println("msg data name " + cloudEventData.getValue().getName());
        //headers.get(KafkaHeaders.RECEIVED_PARTITION_ID), headers.get(KafkaHeaders.OFFSET));
  }

}
