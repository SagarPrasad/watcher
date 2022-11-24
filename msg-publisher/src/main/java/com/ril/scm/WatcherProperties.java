package com.ril.scm;

import java.util.ArrayList;
import java.util.List;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("watcher.msg-publish")
@Data
public class WatcherProperties {
    private String tenantId = "ajio-default";
    private boolean enabled = true;
    private String topicName = "audit";
    private String source = "fs-service";
    private String applicationName = "app-name-from-code";
    private List<String> sampleArray = new ArrayList<>();
}
