package com.renan.producer.services;

import com.renan.producer.model.People;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
@Log4j2
public class StringProducerService {
    private final KafkaTemplate<String,People> kafkaTemplate;

    public void sendMessage(People message){
        log.info("Enviando a mensagem - {}", message);
        kafkaTemplate.send("str-topic",message);
        kafkaTemplate.send("meu-topico-producer",message);
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
