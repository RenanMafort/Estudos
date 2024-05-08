package com.sereia.renan.paymentservice.config;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.apache.kafka.clients.admin.AdminClientConfig;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.KafkaAdmin;

import java.util.HashMap;

@RequiredArgsConstructor
@Log4j2
@Configuration
public class KafkaConfigAdmin {

    private final KafkaProperties properties;

    @Bean
    public KafkaAdmin kafkaAdmin(){
        var config = new HashMap<String,Object>();
        config.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG,properties.getBootstrapServers());
        return new KafkaAdmin(config);
    }

    @Bean
    public KafkaAdmin.NewTopics newTopics(){
        return new KafkaAdmin.NewTopics(
                TopicBuilder.name("payment-topic").partitions(1).build()
        );
    }
}
