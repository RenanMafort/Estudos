package br.com.springboot3.unittests.mockito.services;

import br.com.springboot3.data.vo.v1.PersonVO;
import br.com.springboot3.repositories.PersonRepositorie;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@ExtendWith(MockitoExtension.class)
public class PersonServices {

    @InjectMocks
    br.com.springboot3.services.PersonServices personServices;

    @Mock
    PersonRepositorie repositorie;


    @BeforeEach
    void setUpMocks() throws Exception {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testFindById(){
        var result = personServices.findById(5L);
//        List<PersonVO> all = personServices.findAll();

       assertNotNull(result);
       assertNotNull(result.getKey());
       assertNotNull(result.getLinks());
        System.out.println(result);
       assertTrue(result.toString().contains(""));

    }

    @Test
    void testFindAll(){
        fail("Not yet implemented");
    }
}
