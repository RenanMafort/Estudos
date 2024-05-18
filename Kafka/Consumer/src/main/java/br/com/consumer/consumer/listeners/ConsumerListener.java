package br.com.consumer.consumer.listeners;

import br.com.consumer.consumer.custom.StrConsumerCustomListenner;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

@Component
@Log4j2
public class ConsumerListener {

    @StrConsumerCustomListenner(groupId = "group-1",topics = "meu-topico-producer")
    public void create(String message) throws Exception{
        log.info("CREATE ::: Received message - {}", message);
        throw new Exception("ERROR");
    }

    @StrConsumerCustomListenner(groupId = "group-2")
    public void log(String message){
        log.info("LOG ::: Received message - {}", message);
    }

    @StrConsumerCustomListenner(groupId = "group-1",containerFactory = "validMessageContainerFactory2")
    public void history(String message){
        log.info("HISTORY ::: Received message - {}", message);
    };
}
