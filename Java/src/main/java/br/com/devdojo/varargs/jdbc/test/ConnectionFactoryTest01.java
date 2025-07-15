package br.com.devdojo.varargs.jdbc.test;

import br.com.devdojo.varargs.jdbc.conn.ConnectionFactory;
import br.com.devdojo.varargs.jdbc.dominio.Producer;
import br.com.devdojo.varargs.jdbc.repository.ProducerRepository;
import br.com.devdojo.varargs.jdbc.service.ProducesService;
import lombok.extern.log4j.Log4j2;

import java.util.List;

@Log4j2
public class ConnectionFactoryTest01 {
    public static void main(String[] args) {
        Producer producer = Producer.builder().id(16).name("UPDATE").build();

////        ProducesService.delete(15);
//        for (int i = 0; i < 50; i++) {
//            ProducesService.save(producer);
//        }
//        ProducesService.update(producer);

//        List<Producer> all = ProducesService.findAll();
//        log.info(all);

//        List<Producer> all = ProducesService.findByName("Testando");
//        log.info(all);

//        ProducerRepository.showProducerMetaData();

//        ProducerRepository.showDriverMetaData();
//        ProducesService.showTypeScrollWorking();

//        log.info(ProducesService.findByNameAndToLowerCase("Testando"));
        log.info(ProducesService.findByNamePreparedStatement("renan sereia or X'='X"));
        ProducesService.updatePreparedStatement(producer);


        log.info(ProducesService.findByNameCallableStatement("renan sereia"));


    }
}
