package com.example.demo;

import io.swagger.v3.oas.models.PathItem;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfiguration {

  public static final String CUSTOM_DESCRIPTION = "REPRO_932";

  @Bean
  public GroupedOpenApi publicApi() {
    return GroupedOpenApi
        .builder()
        .group("public")
        .addOpenApiCustomiser(api -> api.getPaths().values().stream()
            .map(PathItem::getGet)
            .forEach(param -> param.setDescription(CUSTOM_DESCRIPTION)))
        .pathsToMatch("/**")
        .build();
  }
}
