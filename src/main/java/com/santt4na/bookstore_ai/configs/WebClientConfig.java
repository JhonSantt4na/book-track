package com.santt4na.bookstore_ai.configs;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {

   @Value("${deepseek.api.key}")
   private String apiKey;

   @Bean(name = "deepseekWebClient")
   public WebClient deepseekWebClient() {
      return WebClient.builder()
            .baseUrl("https://api.deepseek.com/v1/chat/completions")
            .defaultHeader("Authorization", "Bearer " + apiKey)
            .defaultHeader("Content-Type", "application/json")
            .build();
   }
}