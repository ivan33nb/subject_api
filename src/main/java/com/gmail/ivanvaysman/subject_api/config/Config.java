package com.gmail.ivanvaysman.subject_api.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

  @Bean
  public ObjectMapper objectMapper() {
    ObjectMapper om = new ObjectMapper();
    om.findAndRegisterModules();
    return om;
  }
}
