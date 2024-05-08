package br.com.springboot3.integrationtests.controller.withjson;

import br.com.springboot3.config.TesteConfigs;
import br.com.springboot3.integrationtests.testcontainers.AbstractIntegrationTest;
import br.com.springboot3.integrationtests.vo.PersonVO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.*;
import org.springframework.boot.test.context.SpringBootTest;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class PersonControllerJsonTest extends AbstractIntegrationTest {

    private static RequestSpecification specification;
    private static ObjectMapper objectMapper;
    private static PersonVO person;

    @BeforeAll
    public static void setup() {
        objectMapper = new ObjectMapper();
        objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);

        person = new PersonVO();

    }

    private void mockPerson() {
        person.setFirstName("Renan");
        person.setLastName("Renan Sereia Teste");
        person.setAddress("new York City");
        person.setGender("Male");
    }

    @Test
    @Order(1)
    public void testCreate() throws JsonProcessingException {
        mockPerson();

        specification = new RequestSpecBuilder()
                .addHeader(TesteConfigs.HEADER_PARAM_ORIGIN, TesteConfigs.ORIGIN_RENAN)
                .setBasePath("/api/person/v1")
                .setPort(TesteConfigs.SERVER_PORT)
                .addFilter(new RequestLoggingFilter(LogDetail.ALL))
                .addFilter(new ResponseLoggingFilter(LogDetail.ALL))
                .build();

        String body = given()
                .spec(specification)
                .contentType(TesteConfigs.CONTENT_TYOPE_JSON)
                .body(person)
                .when()
                .post()
                .then()
                .statusCode(200)
                .extract()
                .body().asString();

        PersonVO createdPerson = objectMapper.readValue(body, PersonVO.class);
        person = createdPerson;

        assertNotNull(createdPerson);

        assertNotNull(createdPerson.getId());
        assertNotNull(createdPerson.getFirstName());
        assertNotNull(createdPerson.getLastName());
        assertNotNull(createdPerson.getAddress());
        assertNotNull(createdPerson.getGender());

        assertTrue(createdPerson.getId() > 0);

        assertEquals("Renan", createdPerson.getFirstName());
        assertEquals("Renan Sereia Teste", createdPerson.getLastName());
        assertEquals("new York City", createdPerson.getAddress());
        assertEquals("Male", createdPerson.getGender());

    }

    @Test
    @Order(2)
    public void testCreateWithWrongOrigin() throws JsonProcessingException {
        mockPerson();

        specification = new RequestSpecBuilder()
                .addHeader(TesteConfigs.HEADER_PARAM_ORIGIN, TesteConfigs.ORIGIN_OTHER)
                .setBasePath("/api/person/v1")
                .setPort(TesteConfigs.SERVER_PORT)
                .addFilter(new RequestLoggingFilter(LogDetail.ALL))
                .addFilter(new ResponseLoggingFilter(LogDetail.ALL))
                .build();

        String body = given()
                .spec(specification)
                .contentType(TesteConfigs.CONTENT_TYOPE_JSON)
                .body(person)
                .when()
                .post()
                .then()
                .statusCode(403)
                .extract()
                .body().asString();

        assertNotNull(body);
        assertEquals(TesteConfigs.ERROR, body);

    }


}
