package com.sagar.audit.watcher;


import org.springframework.cloud.stream.annotation.EnableBinding;
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

}
