package br.com.devdojo.varargs.jdbc.test;

import br.com.devdojo.varargs.jdbc.dominio.Producer;
import br.com.devdojo.varargs.jdbc.repository.ProducerRepository;
import br.com.devdojo.varargs.jdbc.service.ProducerServiceRowSet;
import lombok.extern.log4j.Log4j2;

import java.lang.reflect.Array;
import java.util.Arrays;

@Log4j2
public class ConnectionFactoryTest03 {
    public static void main(String[] args) {
        Producer producer1 = Producer.builder().name("RENAN sereia").build();
        Producer producer2 = Producer.builder().name("sereia renan").build();
        Producer producer3 = Producer.builder().name("hugo jorge").build();
        Producer producer4= Producer.builder().name("Delega").build();

        ProducerRepository.saveTransaction(Arrays.asList(producer1,producer2,producer3,producer4));



       
    }
}
