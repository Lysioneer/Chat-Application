package com.chatApp.chatApplication.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(name = "/api/v1/chat")
public class ChatController {

    @GetMapping("/")
    public String temp() {

        return "Hello World!";
    }

}
