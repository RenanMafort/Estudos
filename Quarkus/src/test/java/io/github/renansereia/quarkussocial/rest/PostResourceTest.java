package io.github.renansereia.quarkussocial.rest;

import io.github.renansereia.quarkussocial.domain.model.Followers;
import io.github.renansereia.quarkussocial.domain.model.User;
import io.github.renansereia.quarkussocial.domain.repository.FollowerRepository;
import io.github.renansereia.quarkussocial.domain.repository.UserRepository;
import io.github.renansereia.quarkussocial.rest.dto.CreatePostRequestDTO;
import io.quarkus.test.common.http.TestHTTPEndpoint;
import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;
import io.restassured.mapper.ObjectMapperType;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

@QuarkusTest
@TestHTTPEndpoint(PostResource.class)
class PostResourceTest {

    @Inject
    UserRepository userRepository;

    @Inject
    FollowerRepository followerRepository;
    Long userId;
    Long followId;

    @BeforeEach
    @Transactional
    void setUp(){
        User user = new User();
        user.setName("Renan Mafort Sereia");
        user.setAge(22);
        this.userRepository.persist(user);
        this.userId = user.getId();

        User userSeguidor = new User();
        userSeguidor.setName("Outro seguidor");
        userSeguidor.setAge(22);
        this.userRepository.persist(userSeguidor);
        this.followId = userSeguidor.getId();

        Followers followers = new Followers();
        followers.setUser(user);
        followers.setFollower(userSeguidor);
        this.followerRepository.persist(followers);
    }

    @Test
    @DisplayName("should create a post for a user")
    public void createPostTest(){
        var request = new CreatePostRequestDTO();
        request.setMessage("Some text");

        given()
                .contentType(ContentType.JSON)
                .body(request, ObjectMapperType.GSON)
                .pathParam("userId",this.userId)
                .when()
                .post()
                .then()
                .statusCode(201);
    }

    @Test
    @DisplayName("should return 404 when trying to make a post for an inexistent user")
    public void postForAnInexistenteUserTest(){
        var request = new CreatePostRequestDTO();
        request.setMessage("Some text");

        given()
                .contentType(ContentType.JSON)
                .body(request, ObjectMapperType.GSON)
                .pathParam("userId",848)
                .when()
                .post()
                .then()
                .statusCode(404);
    }


    @Test
    @DisplayName("should return 404 when user doesn't exist")
    public void listPostUserNotFund(){
        var userInexistente = 1000;
        given()
                .pathParam("userId",userInexistente)
                .when()
                .get()
                .then()
                .statusCode(404);
    }



    @Test
    @DisplayName("should return 400 when followid header is not present")
    public void listPostfollowIdNotPresent(){
        given()
                .pathParam("userId",this.userId)
                .when()
                .get()
                .then()
                .statusCode(400)
                .body(Matchers.is("No headers present"));

    }

    @Test
    @DisplayName("should return 404 when followid is not found")
    public void listPostfollowIdNotFound(){
        given()
                .pathParam("userId",this.userId)
                .header("followerId",22)
                .when()
                .get()
                .then()
                .statusCode(404)
                .body(Matchers.is("No follow found"));
    }

    @Test
    @DisplayName("should return 403 when not a follower")
    public void listPostNotAFollower(){
        given()
                .pathParam("userId",this.userId)
                .header("followerId",8)
                .when()
                .get()
                .then()
                .statusCode(403)
                .body(Matchers.is("You can't see these post"));
    }

    @Test
    @DisplayName("should return posts")
    public void listPost(){
        given()
                .pathParam("userId",this.userId)
                .header("followerId",this.followId)
                .when()
                .get()
                .then()
                .statusCode(200)
                .body("size()",Matchers.is(0));
    }
}