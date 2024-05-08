package br.com.springboot3.integrationtests.swagger;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.*;

import br.com.springboot3.config.TesteConfigs;
import br.com.springboot3.integrationtests.testcontainers.AbstractIntegrationTest;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class SwaggerIntegrationTest extends AbstractIntegrationTest {

    @Test
    public void shouldDisplaySwaggerUiPage() {
        String body = given()
                .basePath("/swagger-ui/index.html")
                .port(TesteConfigs.SERVER_PORT)
                .when()
                .get()
                .then()
                .statusCode(200)
                .extract()
                .body().asString();

        assertTrue(body.contains("Swagger UI"));
    }


}
