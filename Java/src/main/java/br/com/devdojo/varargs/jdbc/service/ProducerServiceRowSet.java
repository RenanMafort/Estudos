package br.com.devdojo.varargs.jdbc.service;

import br.com.devdojo.varargs.jdbc.dominio.Producer;
import br.com.devdojo.varargs.jdbc.repository.ProducerRepository;
import br.com.devdojo.varargs.jdbc.repository.ProducerRepositoryRowSet;

import java.util.List;

public class ProducerServiceRowSet {

    public static void saveTransaction(List<Producer> producer) {
        ProducerRepository.saveTransaction(producer);
    }
    public static List<Producer> findByNameJdbcRowSet(String name){
      return   ProducerRepositoryRowSet.findByNameJdbcRowSet(name);
    }
    public static void updateJdbcRowSet(Producer producer){
        ProducerRepositoryRowSet.updateJdbcRowSet(producer);
    }

    public static void updateCachedRowSet(Producer producer){
        ProducerRepositoryRowSet.updateCachedRowSet(producer);
    }

}
