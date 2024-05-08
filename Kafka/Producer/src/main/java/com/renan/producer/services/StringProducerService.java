package com.renan.producer.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
@Log4j2
public class StringProducerService {
    private final KafkaTemplate<String,String> kafkaTemplate;

    public void sendMessage(String message){
        log.info("Enviando a mensagem - {}", message);
        kafkaTemplate.send("str-topic",message);
//                .addCallback(
//                success -> {
//                    if (success != null){
//                        log.info("Send Message With Sucess - {}",message);
//                        log.info("Partition - {}, OffSet - {}",
//                                success.getRecordMetadata().partition(),
//                                success.getRecordMetadata().offset());
//                    }
//                },
//                error -> log.info("Send Message With Error - {}",message)
//        );
    }
}
