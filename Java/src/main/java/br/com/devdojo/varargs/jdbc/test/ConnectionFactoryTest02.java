package br.com.devdojo.varargs.jdbc.test;

import br.com.devdojo.varargs.jdbc.dominio.Producer;
import br.com.devdojo.varargs.jdbc.service.ProducerServiceRowSet;
import lombok.extern.log4j.Log4j2;

import java.util.List;

@Log4j2
public class ConnectionFactoryTest02 {
    public static void main(String[] args) {
        Producer producer = Producer.builder().id(16).name("RENAN UPDATE").build();

//        List<Producer> renan = ProducerServiceRowSet.findByNameJdbcRowSet("renan");
//        log.info(renan);

       ProducerServiceRowSet.updateCachedRowSet(producer);

    }
}
