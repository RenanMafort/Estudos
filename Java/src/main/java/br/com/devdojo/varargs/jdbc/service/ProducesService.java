package br.com.devdojo.varargs.jdbc.service;

import br.com.devdojo.varargs.jdbc.dominio.Producer;
import br.com.devdojo.varargs.jdbc.repository.ProducerRepository;

import java.util.List;

public class ProducesService {

    public static void save(Producer producer){
        ProducerRepository.save(producer);
    }

    public static void delete(Integer id,Integer id2){
        if (id <=0){
            throw new IllegalArgumentException("Invalid value for id");
        }
        ProducerRepository.delete(id,id2);
    }

    public static void delete(Integer id){
        requireValidId(id);
        ProducerRepository.delete(id);
    }

    public static void update(Producer producer){
        requireValidId(producer.getId());
        ProducerRepository.update(producer);
    }

    public static void updatePreparedStatement(Producer producer){
        requireValidId(producer.getId());
        ProducerRepository.updatePreparedStatement(producer);
    }
    private static void requireValidId(Integer id ){
        if (id == null || id <=0){
            throw new IllegalArgumentException("Invalid value for id");
        }
    }

    public static List<Producer> findAll(){
        return ProducerRepository.findAll();
    }

    public static List<Producer> findByName(String name){
        return ProducerRepository.findByName(name);
    }

    public static List<Producer> findByNamePreparedStatement(String name){
        return ProducerRepository.findByNamePreparedStatement(name);
    }
    public static List<Producer> findByNameCallableStatement(String name){
        return ProducerRepository.findByNameCallableStatement(name);
    }

    public static void showProducerMetaData(){
         ProducerRepository.showProducerMetaData();
    }

    public static void showDriverMetaData(){
        ProducerRepository.showDriverMetaData();
    }
    public static void showTypeScrollWorking(){
        ProducerRepository.showTypeScrollWorking();
    }

    public static List<Producer> findByNameAndToLowerCase(String name){
        return ProducerRepository.findByNameAndToLowerCase(name);
    }

    public static List<Producer> findByNameOrInsertWhenNotFound(String name){
        return ProducerRepository.findByNameOrInsertWhenNotFound(name);
    }
}
