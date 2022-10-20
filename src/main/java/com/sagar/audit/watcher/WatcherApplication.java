package com.sagar.audit.watcher;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.function.context.config.ContextFunctionCatalogAutoConfiguration;

@SpringBootApplication(exclude = ContextFunctionCatalogAutoConfiguration.class)
public class WatcherApplication {
	public static void main(String[] args) {
		SpringApplication.run(WatcherApplication.class, args);
	}
}
