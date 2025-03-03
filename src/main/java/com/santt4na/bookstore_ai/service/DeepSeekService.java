package com.santt4na.bookstore_ai.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.json.JSONObject;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class DeepSeekService {

   private final WebClient webClient;
   private final ObjectMapper objectMapper = new ObjectMapper();

   // Use a qualifier para especificar o bean correto
   public DeepSeekService(
         @org.springframework.beans.factory.annotation.Qualifier("deepseekWebClient") WebClient deepseekWebClient) {
      this.webClient = deepseekWebClient;
   }

   public String askQuestion(String question) {
      try {
         ObjectNode message = objectMapper.createObjectNode();
         message.put("role", "user");
         message.put("content", question);

         ArrayNode messages = objectMapper.createArrayNode();
         messages.add(message);

         ObjectNode requestBody = objectMapper.createObjectNode();
         requestBody.put("model", "deepseek-chat");
         requestBody.set("messages", messages);
         requestBody.put("max_tokens", 200);
         requestBody.put("temperature", 0.7);

         String response = webClient.post()
               .bodyValue(requestBody.toString())
               .retrieve()
               .bodyToMono(String.class)
               .block();

         JSONObject responseJson = new JSONObject(response);
         return responseJson.getJSONArray("choices")
               .getJSONObject(0)
               .getJSONObject("message")
               .getString("content");

      } catch (Exception e) {
         e.printStackTrace();
         return "Erro ao processar a pergunta: " + e.getMessage();
      }
   }
}