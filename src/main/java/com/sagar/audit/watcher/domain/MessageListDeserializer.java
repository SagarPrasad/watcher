package com.sagar.audit.watcher.domain;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import org.apache.kafka.common.errors.SerializationException;
import org.apache.kafka.common.serialization.Deserializer;

public class MessageListDeserializer implements Deserializer<List<AuditMessage>> {

  private final ObjectMapper objectMapper = new ObjectMapper();

  @Override
  public List<AuditMessage> deserialize(String topic, byte[] data) {
    try {
      objectMapper.enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);
      List<AuditMessage> auditMessages = objectMapper.readValue(data,
      new TypeReference<List<AuditMessage>>() {
      });
      //List<AuditMessage> auditMessages = Arrays.asList(objectMapper.readValue(data, AuditMessage[].class));
      if (auditMessages.size() > 1) {
        System.out.println("size --- " + auditMessages.size());
      }
      return auditMessages;
    } catch (IOException e) {
      throw new SerializationException(e);
    }
  }
}
