package com.sagar.audit.watcher.consumer;

import com.sagar.audit.watcher.AuditMessageRepository;
import com.sagar.audit.watcher.AuditModel;
import com.sagar.audit.watcher.domain.AuditMessage;
import io.cloudevents.CloudEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.function.Consumer;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

@Component
public class AuditConsumer {

  @Autowired
  private AuditMessageRepository auditMessageRepository;
  @Bean
  public Consumer<List<Message<AuditMessage>>> consumer() {
    return s -> s.forEach(auditMessageMessage -> {
      System.out.println("data at loop--" + auditMessageMessage.getPayload());
      System.out.println("header at loop--" + auditMessageMessage.getHeaders());
    });/* -> {
      List<AuditModel> auditModelList = new ArrayList<>();
      s.forEach(auditMessage ->  {
        System.out.println("data at loop--" + auditMessage.getPayload());
        System.out.println("header at loop--" + auditMessage.getHeaders());
        auditModelList.add(new AuditModel(UUID.randomUUID().toString(), auditMessage.getPayload().getPayload()));
      });*/
      // add timestamp to check the batch db updates
     // auditMessageRepository.saveAll(auditModelList);
   // };
  }
// THis is working codef
  /*@Bean
  public Consumer<List<AuditMessage>> consumer() {
    return s -> {
      List<AuditModel> auditModelList = new ArrayList<>();
      s.forEach(auditMessage ->  {
        System.out.println("data at loop--" + auditMessage);
        auditModelList.add(new AuditModel(UUID.randomUUID().toString(), auditMessage.getPayload()));
      });
      // add timestamp to check the batch db updates
      auditMessageRepository.saveAll(auditModelList);
    };
  }*/

  //Not working for batch - working for non batch
/*  @Bean
  public Consumer<AuditMessage> consumer() {
    return auditMessage -> System.out.println("data at loop-- " +  auditMessage);
  }*/
  // This is also working for non batch
  /*@Bean
  public Consumer<Message<AuditMessage>> consumer() {
    return auditMessage -> System.out.println("data at loop-- " +  auditMessage.getPayload());
  }*/
}