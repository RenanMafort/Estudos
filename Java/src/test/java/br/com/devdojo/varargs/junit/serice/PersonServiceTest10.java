package br.com.devdojo.varargs.junit.serice;

import br.com.devdojo.varargs.junit.dominio.Person;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PersonServiceTest10 {
    private Person person ;
    private Person personNotAdult ;

    private PersonService personService;
    @BeforeEach
    void setUp(){
        this.person = new Person(18);
        this.personNotAdult = new Person(15);
        this.personService = new PersonService();
    }

    @Test
    @DisplayName("isAdult_ReturnFalse_WhenAgeIsLowerThen18")
    void isAdult_ReturnFalse_WhenAgeIsLowerThen18() {
        Assertions.assertEquals(Boolean.FALSE, personService.isAdult(personNotAdult));
        Assertions.assertFalse(personService.isAdult(personNotAdult));
    }

    @Test
    @DisplayName("isAdult_ReturnFalse_WhenAgeIsLowerThen18")
    void isAdult_ReturnTrue_WhenAgeIsGreatOrEqual18() {
        Assertions.assertEquals(Boolean.TRUE, personService.isAdult(person));
        Assertions.assertTrue(personService.isAdult(person));
    }

    @Test
    @DisplayName("Should throw NullPointerException with message when person is null")
    void isAdult_ShouldThrowException_WhenPersonIsNull(){
        Assertions.assertThrows(NullPointerException.class,() -> this.personService.isAdult(null));
        Assertions.assertThrows(NullPointerException.class,() -> this.personService.isAdult(null),"Person can't be null");
    }
    @Test
    @DisplayName("filterRemovingNotAdult should return only adults")
    void filterRemovingNotAdult() {
        List<Person> people = List.of(
                new Person(12),
                new Person(19),
                new Person(21),
                new Person(12)
        );

        List<Person> adults = personService.filterRemovingNotAdult(people);

        Assertions.assertEquals(2, adults.size());
        Assertions.assertTrue(adults.stream().anyMatch(person -> person.getAge() == 19));
        Assertions.assertTrue(adults.stream().anyMatch(person -> person.getAge() == 21));
    }

    @Test
    @DisplayName("filterRemovingNotAdult should return only one adult")
    void filterRemovingNotAdult2() {
        List<Person> people = List.of(
                new Person(12),
                new Person(21),
                new Person(12)
        );

        List<Person> adults = personService.filterRemovingNotAdult(people);

        Assertions.assertEquals(1, adults.size());
        Assertions.assertTrue(adults.stream().anyMatch(person -> person.getAge() == 21));
    }

    @Test
    @DisplayName("filterRemovingNotAdult should return no adults")
    void filterRemovingNotAdult3() {
        List<Person> people = List.of(
                new Person(12),
                new Person(12)
        );

        List<Person> adults = personService.filterRemovingNotAdult(people);

        Assertions.assertEquals(0, adults.size());
    }

    @Test
    @DisplayName("filterRemovingNotAdult should return all adults")
    void filterRemovingNotAdult_AllAdults() {
        List<Person> people = List.of(
                new Person(18),
                new Person(19),
                new Person(21)
        );

        List<Person> adults = personService.filterRemovingNotAdult(people);

        Assertions.assertEquals(3, adults.size());
        Assertions.assertTrue(adults.stream().anyMatch(person -> person.getAge() == 18));
        Assertions.assertTrue(adults.stream().anyMatch(person -> person.getAge() == 19));
        Assertions.assertTrue(adults.stream().anyMatch(person -> person.getAge() == 21));
    }

    @Test
    @DisplayName("filterRemovingNotAdult should return an empty list when input is empty")
    void filterRemovingNotAdult_EmptyList() {
        List<Person> people = new ArrayList<>();

        List<Person> adults = personService.filterRemovingNotAdult(people);

        Assertions.assertEquals(0, adults.size());
    }
}