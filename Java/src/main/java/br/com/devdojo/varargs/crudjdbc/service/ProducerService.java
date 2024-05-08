package br.com.devdojo.varargs.crudjdbc.service;

import br.com.devdojo.varargs.crudjdbc.dominio.Producer;
import br.com.devdojo.varargs.crudjdbc.repository.ProducerRepository;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class ProducerService {
    private static final Scanner SCANNER = new Scanner(System.in);
    public static void buildMenu(int op){
        switch (op){
            case 1 -> findByName();
            case 2 -> delete();
            case 3-> save();
            case 4-> update();
            default-> throw new IllegalArgumentException("Not a valid option");
        }

    }



    private static void findByName(){
        System.out.println("Type the name or empty to all");
        String name = SCANNER.nextLine();
        ProducerRepository.findByName(name)
                .forEach( p ->  System.out.printf("[%d] -  | %s%n",p.getId(),p.getName()));

    }

    private static void delete(){
        System.out.println("Type one of the ids below to delete");
        findByName();
        int id = Integer.parseInt(SCANNER.nextLine());
        System.out.println("Are you sure? S/N");
        String choice = SCANNER.nextLine();
        if ("s".equalsIgnoreCase(choice)){
            ProducerRepository.delete(id);
        }
    }

    private static void save(){
        System.out.println("Type the name of the producer");
        String name = SCANNER.nextLine();
        Producer build = Producer.builder().name(name).build();
        ProducerRepository.save(build);

    }

    private static void update() {
        System.out.printf("Type the id of the object you want to update");
        Optional<Producer> byId = ProducerRepository.findById(Integer.parseInt(SCANNER.nextLine()));
        if (byId.isEmpty()){
            System.out.println("Producer not found");
            return;
        }

        Producer producer = byId.get();
        System.out.println("Type the new nme or enter to keep the same");
        String name = SCANNER.nextLine();
        name = name.isEmpty() ? producer.getName() : name;
        Producer build = Producer.builder().id(producer.getId()).name(name).build();
        ProducerRepository.update(build);
    }
}
