package com.sereia.renan.paymentservice.config;

import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

import java.io.Serializable;
import java.util.HashMap;

@RequiredArgsConstructor
@Configuration
public class JsonProducerConfig {

    private final KafkaProperties properties;

    @Bean
    public ProducerFactory jsonProducerFactory(){
        var config = new HashMap<String, Object>();
        config.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,properties.getBootstrapServers());
        config.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        config.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
        return new DefaultKafkaProducerFactory(config,new StringSerializer(),new JsonSerializer());
    }

    @Bean
    public KafkaTemplate<String,Serializable> jsonKafkaTemplate(ProducerFactory json){
        return new KafkaTemplate<>(json);
    }
}
