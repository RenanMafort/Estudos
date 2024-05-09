package br.com.sereia.renan.chatgptspringbootintegration.controller;

import br.com.sereia.renan.chatgptspringbootintegration.response.ChatGptResponse;
import br.com.sereia.renan.chatgptspringbootintegration.service.ChatGptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bot")
public class ChatGPTController {

    @Autowired
    private ChatGptService service;

    @GetMapping("/chat")
    public ChatGptResponse chat(@RequestParam("content") String content){
        return service.chat(content);
    }
}
