package com.example.jsonconsumer.listener;

import com.example.jsonconsumer.model.Payment;
import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Log4j2
@Component
public class JsonListener {

    @KafkaListener(topics = "payment-topic",groupId = "create-group", containerFactory = "jsonContainerFactory")
    public void antiFraud(@Payload Payment payment){
        log.info("Recebi o payment - {}",payment.toString());
        log.info("Compra aprovada.....");
    }

    @KafkaListener(topics = "payment-topic",groupId = "pdf-group", containerFactory = "jsonContainerFactory")
    public void pdfGenerator(@Payload Payment payment){
        log.info("Gerando o PDF do payment - {}",payment.getId());
        log.info("Compra aprovada.....");
    }

    @KafkaListener(topics = "payment-topic",groupId = "pdf-group", containerFactory = "jsonContainerFactory")
    public void emailGroup(){
        log.info("Enviando email...");
    }
}
