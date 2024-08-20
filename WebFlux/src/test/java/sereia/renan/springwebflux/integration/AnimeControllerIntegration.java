package sereia.renan.springwebflux.integration;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;
import reactor.blockhound.BlockHound;
import reactor.blockhound.BlockingOperationError;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;
import sereia.renan.springwebflux.domain.Anime;
import sereia.renan.springwebflux.exception.CustomAttributes;
import sereia.renan.springwebflux.repositorie.AnimeRepositorie;
import sereia.renan.springwebflux.service.AnimeService;
import sereia.renan.springwebflux.util.AnimeCreator;

import java.util.List;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

@ExtendWith(SpringExtension.class)
@AutoConfigureWebTestClient
@SpringBootTest
@Slf4j
public class AnimeControllerIntegration {

    @MockBean
    private AnimeRepositorie animeRepositorie;

    @Autowired
    private WebTestClient webTestClient;

    private final Anime anime = AnimeCreator.animeValid();

    @BeforeAll
    public static void blockHoundSetup(){
        BlockHound.install();
    }

    @BeforeEach
    public void setUp() {
        BDDMockito.when(animeRepositorie.findAll())
                .thenReturn(Flux.just(anime));

        BDDMockito.when(animeRepositorie.findById(ArgumentMatchers.anyInt()))
                .thenReturn(Mono.just(anime));

        BDDMockito.when(animeRepositorie.save(AnimeCreator.animeToBeSaved()))
                .thenReturn(Mono.just(anime));

        BDDMockito.when(animeRepositorie.saveAll(List.of(AnimeCreator.animeToBeSaved(),AnimeCreator.animeToBeSaved())))
                        .thenReturn(Flux.just(anime,anime));

        BDDMockito.when(animeRepositorie.saveAll(List.of(AnimeCreator.animeToBeSaved(),AnimeCreator.animeToBeSaved())))
                .thenReturn(Flux.just(anime,anime));

        BDDMockito.when(animeRepositorie.delete(ArgumentMatchers.any(Anime.class)))
                .thenReturn(Mono.empty());

        BDDMockito.when(animeRepositorie.save(AnimeCreator.animeToBeSaved()))
                .thenReturn(Mono.empty());
    }


    @Test
    public void blockhoundWorks(){
        try {
            FutureTask<?> task = new FutureTask<Object>(() -> {
                Thread.sleep(0);
                return "";
            });
            Schedulers.parallel().schedule(task);
            task.get(18, TimeUnit.SECONDS);
            fail("should fail");
        }catch (Exception e){
            assertTrue(e.getCause() instanceof BlockingOperationError);
        }
    }

    @Test
    @DisplayName("findAll Anime return Flux of Anime when succesfull")
    public void findAll_ReturnFluxOfAnime_WhenSuccesfull(){
        webTestClient
                .get()
                .uri("/animes")
                .exchange()
                .expectStatus().is2xxSuccessful()
                .expectBody()
                .jsonPath("$.[0].id").isEqualTo(anime.getId())
                .jsonPath("$.[0].name").isEqualTo(anime.getName());
    }

    @Test
    @DisplayName("findAll Anime return Flux of Anime when succesfull")
    public void findAll_Flavo2_ReturnFluxOfAnime_WhenSuccesfull(){
        log.info("BODY - {}",webTestClient.get()
                .uri("/animes")
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(Anime.class)
                .returnResult().getResponseBody());
        webTestClient
                .get()
                .uri("/animes")
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(Anime.class)
                .hasSize(1)
                .contains(anime);
    }


    @Test
    @DisplayName("findById Anime return Mono of Anime when succesfull")
    public void findById_ReturnMonoOfAnime_WhenSuccesfull(){
        webTestClient
                .get()
                .uri("/animes/{id}",1)
                .exchange()
                .expectStatus().isOk()
                .expectBody(Anime.class)
                .isEqualTo(anime);
    }

    @Test
    @DisplayName("findById  return Mono Error  when empty mono is returned")
    public void findById_ReturnMonoError_WhenEmptyMonoIsReturned(){
        BDDMockito
                .when(animeRepositorie.findById(ArgumentMatchers.anyInt()))
                .thenReturn(Mono.empty());

        webTestClient
                .get()
                .uri("/animes/{id}",1)
                .exchange()
                .expectStatus().isNotFound()
                .expectBody()
                .jsonPath("$.status").isEqualTo(404)
                .jsonPath("$.developerMessage").isEqualTo("A ResponseStatusException Happend");
    }

    @Test
    @DisplayName("Save a anime when succesfull")
    public void save_A_Anime_whenSuccesfull(){
        Anime animeValid = AnimeCreator.animeToBeSaved();

        webTestClient
               .post()
                .uri("/animes")
               .contentType(MediaType.APPLICATION_JSON)
               .body(BodyInserters.fromValue(animeValid))
                .exchange()
                .expectStatus().isCreated()
                .expectBody(Anime.class)
                .isEqualTo(anime);
    }

    @Test
    @DisplayName("Save return error when name is empty")
    public void save_returnError_WhenNameIsEmpty(){
        Anime animeValid =Anime.builder().id(2).name("Renan sereia").build();

        webTestClient
                .post()
                .uri("/animes/")
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromValue(animeValid))
                .exchange()
                .expectStatus().isBadRequest()
                .expectBody()
                .jsonPath("$.status").isEqualTo(400);
    }

    @Test
    @DisplayName("delete removes the anime when successful")
    public void delete_RemovesAnime_WhenSuccessful() {
        webTestClient
                .delete()
                .uri("/animes/{id}", 1)
                .exchange()
                .expectStatus().isNoContent();
    }

    @Test
    @DisplayName("delete returns Mono error when anome does not exist")
    public void delete_ReturnMonoError_WhenEmptyMonoIsReturned() {
        BDDMockito.when(animeRepositorie.findById(ArgumentMatchers.anyInt()))
                .thenReturn(Mono.empty());

        webTestClient
                .delete()
                .uri("/animes/{id}", 1)
                .exchange()
                .expectStatus().isNotFound()
                .expectBody()
                .jsonPath("$.status").isEqualTo(404)
                .jsonPath("$.developerMessage").isEqualTo("A ResponseStatusException Happened");
    }

    @Test
    @DisplayName("update save updated anime and returns empty mono when successful")
    public void update_SaveUpdatedAnime_WhenSuccessful() {
        webTestClient
                .put()
                .uri("/animes/{id}", 1)
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromValue(anime))
                .exchange()
                .expectStatus().isNoContent();
    }

    @Test
    @DisplayName("update returns Mono error when anime does not exist")
    public void update_ReturnMonoError_WhenEmptyMonoIsReturned() {
        BDDMockito.when(animeRepositorie.findById(ArgumentMatchers.anyInt()))
                .thenReturn(Mono.empty());

        webTestClient.put()
                .uri("/animes/{id}", 1)
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromValue(anime))
                .exchange()
                .expectStatus().isNotFound()
                .expectBody()
                .jsonPath("$.status").isEqualTo(404)
                .jsonPath("$.developerMessage").isEqualTo("A ResponseStatusException Happened");
    }

    @Test
    @DisplayName("save_CreateListOfAnime_WhenSuccesfull")
    public void save_CreateListOfAnime_WhenSuccesfull() {
        webTestClient.post()
                .uri("/animes/batch")
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromValue(List.of(AnimeCreator.animeToBeSaved(),AnimeCreator.animeToBeSaved())))
                .exchange()
                .expectStatus().isCreated()
                .expectBodyList(Anime.class)
                .hasSize(2)
                .contains(anime);
    }

    @Test
    @DisplayName("save_ReturnMonoError_WhenSuccesfull()")
    public void save_ReturnMonoError_WhenSuccesfull() {
        BDDMockito.when(animeRepositorie.saveAll(ArgumentMatchers.anyIterable()))
                .thenReturn(Flux.just(anime,anime.withName("")));


        webTestClient.post()
                .uri("/animes/batch")
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromValue(List.of(AnimeCreator.animeToBeSaved(),AnimeCreator.animeToBeSaved())))
                .exchange()
                .expectStatus().isBadRequest()
                .expectBody()
                .jsonPath("$.status").isEqualTo(400);
    }


}
