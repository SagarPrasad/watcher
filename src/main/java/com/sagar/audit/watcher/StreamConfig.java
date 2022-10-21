package com.sagar.audit.watcher;


import io.cloudevents.CloudEvent;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import org.flywaydb.core.internal.util.JsonUtils;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableBinding(AuditMsgStream.class)
public class StreamConfig {

  // TODO: Add Conditional Config

  /*@Bean
  public Supplier<String> sendData() {
    return () -> UUID.randomUUID().toString();
  }

  @Bean
  public Consumer<String> receiveData() {
    return s -> System.out.println("data consumed : " +  s);
  }*/

  /*@Bean
  public Consumer<List<CloudEvent>> consumer() {
    return list -> list.forEach(msg -> System.out.println(msg));
  }*/

}
