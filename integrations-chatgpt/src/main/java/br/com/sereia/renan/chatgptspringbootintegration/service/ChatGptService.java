package br.com.sereia.renan.chatgptspringbootintegration.service;

import br.com.sereia.renan.chatgptspringbootintegration.request.ChatGptRequest;
import br.com.sereia.renan.chatgptspringbootintegration.response.ChatGptResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.logging.Logger;

@Service
public class ChatGptService {

    private Logger logger = Logger.getLogger(ChatGptService.class.getName());


    @Value("${openai.model}")
    private String model;
    @Value("${openai.api.url}")
    private String url;

    @Autowired
    RestTemplate template;

    public ChatGptResponse chat(String content) {
        logger.info("Starting Content");
        ChatGptRequest request = new ChatGptRequest(model, content);
        logger.info("Processing Content");
        return template.postForObject(url, request, ChatGptResponse.class);


    }
}
