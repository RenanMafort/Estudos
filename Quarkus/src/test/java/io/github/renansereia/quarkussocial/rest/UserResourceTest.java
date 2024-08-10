package io.github.renansereia.quarkussocial.rest;

import io.github.renansereia.quarkussocial.rest.dto.CreateUserRequestDTO;
import io.quarkus.test.common.http.TestHTTPResource;
import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;
import io.restassured.mapper.ObjectMapperType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.*;

import java.net.URI;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@QuarkusTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class UserResourceTest {

    @TestHTTPResource("/users")
    URI apiUrl;

    @Test
    @DisplayName("should create an user successfully")
    @Order(1)
    void createUser() {
        CreateUserRequestDTO createUserRequestDTO = new CreateUserRequestDTO();
        createUserRequestDTO.setName("Renan Mafort Sereia");
        createUserRequestDTO.setAge(22);


        Response response = given()
                .contentType(ContentType.JSON)
                .body(createUserRequestDTO, ObjectMapperType.GSON)
                .when()
                .post("/users")
                .then()
                .extract()
                .response();

        assertEquals(201,response.getStatusCode());
        assertNotNull(response.jsonPath().getString("id"));
    }

    @Test
    @DisplayName("should return error when json is not valid")
    @Order(2)
    void createUserValidationError() {
        CreateUserRequestDTO createUserRequestDTO = new CreateUserRequestDTO();
        createUserRequestDTO.setName(null);
        createUserRequestDTO.setAge(null);


        Response response = given()
                .contentType(ContentType.JSON)
                .body(createUserRequestDTO, ObjectMapperType.GSON)
                .when()
                .post("/users")
                .then()
                .extract()
                .response();

        assertEquals(422, response.getStatusCode());
        var listErrors = response.jsonPath().getList("errors", Map.class);
        assertNotNull(listErrors.get(0).get("message"));
        assertNotNull(listErrors.get(1).get("message"));
        assertEquals("Age is required",listErrors.get(1).get("message"));
        assertEquals("Name is required",listErrors.get(0).get("message"));
    }

    @Test
    @Order(3)
    void listAllUsers() {
        given()
                .contentType(ContentType.JSON)
                .when()
                .get(apiUrl)
                .then()
                .statusCode(200)
                .body("size()", Matchers.is(1));
    }

    @Test
    void deleteById() {
    }

    @Test
    void update() {
    }
}