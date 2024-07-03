package com.geometry.config.openapi;

import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ConditionalOnExpression("${springdoc.api-docs.enabled}")
@PropertySource(value = "classpath:swagger-messages.yml", factory = SwaggerMessagesPropertySourceFactory.class)
public class OpenApiConfiguration {
}
