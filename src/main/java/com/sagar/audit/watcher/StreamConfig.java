package com.sagar.audit.watcher;


import com.sagar.audit.watcher.domain.AuditMessage;
import com.sagar.audit.watcher.producer.AuditMsgStream;
import io.micrometer.core.aop.TimedAspect;
import io.micrometer.core.instrument.MeterRegistry;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.springframework.cloud.function.cloudevent.CloudEventHeaderEnricher;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
//@EnableBinding(AuditMsgStream.class)
public class StreamConfig {
    @Bean
    public TimedAspect timedAspect(MeterRegistry registry) {
        return new TimedAspect(registry);
    }
    /*@Bean
    public CloudEventMessageConverter cloudEventMessageConverter() {
        return new CloudEventMessageConverter();
    }
    @Bean
    public CloudEventHeaderEnricher cloudEventEnricher() {
        return messageBuilder -> messageBuilder.setSource("http://spring.io/cloudevent")
                .setType("sample").setId("987654")
                .setDataContentType("application/json")
                .setSpecVersion(SpecVersion.V1.toString());
    }*/
}
