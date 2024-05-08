package br.com.devdojo.varargs.junit.test;

import br.com.devdojo.varargs.junit.dominio.Person;
import br.com.devdojo.varargs.junit.serice.PersonService;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class PersonServiceTest01 {
    public static void main(String[] args) {
        Person person = new Person(15);
        PersonService personService = new PersonService();
        log.info("is Adult '{}'",personService.isAdult(person));

    }
}
