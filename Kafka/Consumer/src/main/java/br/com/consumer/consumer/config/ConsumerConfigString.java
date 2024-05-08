package br.com.consumer.consumer.config;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.listener.RecordInterceptor;

import java.util.Date;
import java.util.HashMap;

@Configuration
@RequiredArgsConstructor
@Log4j2
public class ConsumerConfigString {
    private final KafkaProperties properties;

    @Bean
    public ConsumerFactory<String,String> consumerFactory(){
        var configs = new HashMap<String,Object>();
        configs.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,properties.getBootstrapServers());
        configs.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        configs.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        return new DefaultKafkaConsumerFactory<>(configs);
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String,String> consumer(ConsumerFactory<String,String> consumerFactory){
        var config = new ConcurrentKafkaListenerContainerFactory<String,String>();
        config.setConsumerFactory(consumerFactory);
        return  config;
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String,String> validMessageContainerFactory2(ConsumerFactory<String,String> consumerFactory){
        var config = new ConcurrentKafkaListenerContainerFactory<String,String>();
        config.setConsumerFactory(consumerFactory);
        config.setRecordInterceptor(validMesage());
        return  config;
    }

//    Antes de chamar o listenner, a mensagem que chegou é validada
    private RecordInterceptor<String, String> validMesage() {
        return (record, consumer) -> {
            log.error("RECORD - " + record);
            log.error("CONSUMER - " + consumer);
            if (record.value().contains("Teste")){
                log.info("Possui a palavra teste");
                log.info(new Date(record.timestamp()));
                return record;
            }
            return record;
        };
    }
}
