package com.santt4na.bookstore_ai.controller;

import com.santt4na.bookstore_ai.service.DeepSeekService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeepSeekController {

   @Autowired
   private DeepSeekService deepSeekService;

   @GetMapping("/ask")
   public String askQuestion(@RequestParam String question) {
      return deepSeekService.askQuestion(question);
   }
}