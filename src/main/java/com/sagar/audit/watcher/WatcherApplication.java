package com.sagar.audit.watcher;

import com.sagar.audit.watcher.domain.AuditMessage;
import java.util.List;
import java.util.UUID;
import java.util.function.Consumer;
import java.util.function.Supplier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.function.context.config.ContextFunctionCatalogAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication//(exclude = ContextFunctionCatalogAutoConfiguration.class)
@EnableScheduling
public class WatcherApplication {
	public static void main(String[] args) {
		SpringApplication.run(WatcherApplication.class, args);
	}

	/*@Bean
	public Supplier<AuditMessage> producer() {
		return () -> new AuditMessage(UUID.randomUUID().toString(), "Sagar");
	}*/

}
