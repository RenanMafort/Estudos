package br.com.devdojo.varargs.junit.serice;

import br.com.devdojo.varargs.junit.dominio.Person;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;


class PersonServiceTest {
    private Person adult;
    private Person notAdult;
    private PersonService personService;
    @BeforeEach
    public void setUp(){
        adult = new Person(18);
        notAdult = new Person(15);
        personService = new PersonService();
    }

    @Test
    @DisplayName("A person should be not adut when age is lower than 18")
    void isAdult_ReturnFalse_WhenAgeIsLowerThen18() {
        Assertions.assertFalse(personService.isAdult(notAdult));
    }

    @Test
    @DisplayName("A person should be not adut when age is greater or equals than 18")
    void isAdult_ReturnTrue_WhenAgeIsGreaterOrEqualsThen18() {
        Assertions.assertEquals(true,personService.isAdult(adult));
    }

    @Test
    @DisplayName("Should throw NullPointerException with message when person is null")
    void isAdult_ShouldThrowException_WhenPersonIsNull() {
        Assertions.assertThrows(NullPointerException.class,
                () -> personService.isAdult(null),"Person can't be null");
    }
    @Test
    @DisplayName("Should return list with only adults")
    void filterRemovingNotAdult_ReturnListWithAdultOnly_WhenListOfPersonWithAdultsIsPassed() {
        Person person1 = new Person(17);
        Person person2 = new Person(18);
        Person person3 = new Person(12);
        Person person4 = new Person(21);
        List<Person> personList = List.of(person1, person2, person3, person4);
        Assertions.assertEquals(2,personService.filterRemovingNotAdult(personList).size());
    }

}