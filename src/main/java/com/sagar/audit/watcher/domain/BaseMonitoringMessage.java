package com.sagar.audit.watcher.domain;

public class BaseMonitoringMessage {
    // read from config
    private String tenantId;
    private String env;
    // override in response processing
    private String sourceSystem;
    // read from the span
    private String correlationId;
}
