package com.sagar.audit.watcher.consumer;

import com.sagar.audit.watcher.domain.AuditMessage;
import io.cloudevents.CloudEvent;
import java.util.List;
import java.util.UUID;
import java.util.function.Consumer;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class AuditConsumer {
  @Bean
  public Consumer<List<AuditMessage>> consumer() {
    String thread = UUID.randomUUID().toString();
    return s -> s.forEach(auditMessage -> System.out.println("data at loop--" + thread + " -- " + auditMessage));
  }
}