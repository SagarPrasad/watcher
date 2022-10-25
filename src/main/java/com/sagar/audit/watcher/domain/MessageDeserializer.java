package com.sagar.audit.watcher.domain;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import org.apache.kafka.common.errors.SerializationException;
import org.apache.kafka.common.serialization.Deserializer;

public class MessageDeserializer implements Deserializer<AuditMessage> {

  private final ObjectMapper objectMapper = new ObjectMapper();

  @Override
  public AuditMessage deserialize(String topic, byte[] data) {
    try {
      return objectMapper.readValue(data, AuditMessage.class);
    } catch (IOException e) {
      throw new SerializationException(e);
    }
  }
}
