package com.codecraft.java.components;

import lombok.Data;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
@ToString
@Data
@ConfigurationProperties(prefix = "app.default")
public class DefaultProperties {
    private String defaultUsername;
    private String defaultPassword;
    private Integer initialDelay;
}
