package com.example.aops.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AnswerController {
    @GetMapping("/answer")
    public String answer(){
        return "Hello World";
    }
    @GetMapping("/ans")
    public String an11(){
        return "Thank you";
    }
}
