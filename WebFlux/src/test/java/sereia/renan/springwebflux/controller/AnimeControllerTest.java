package sereia.renan.springwebflux.controller;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.server.ResponseStatusException;
import reactor.blockhound.BlockHound;
import reactor.blockhound.BlockingOperationError;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;
import reactor.test.StepVerifier;
import sereia.renan.springwebflux.domain.Anime;
import sereia.renan.springwebflux.repositorie.AnimeRepositorie;
import sereia.renan.springwebflux.service.AnimeService;
import sereia.renan.springwebflux.util.AnimeCreator;

import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
class AnimeControllerTest {

    @InjectMocks
    private AnimeController animeController;

    @Mock
    private AnimeService animeService;

    private final Anime anime = AnimeCreator.animeValid();


    @BeforeAll
    public static void blockHoundSetup(){
        BlockHound.install();
    }

    @BeforeEach
    public void setUp(){
        BDDMockito.when(animeService.findAll())
                .thenReturn(Flux.just(anime));

        BDDMockito.when(animeService.findById(ArgumentMatchers.anyInt()))
                .thenReturn(Mono.just(Anime.builder()
                                .id(869)
                                .name("Injetado pelo Mockito")
                        .build()));
//
        BDDMockito.when(animeService.save(AnimeCreator.animeToBeSaved()))
                .thenReturn(Mono.just(anime));

        BDDMockito.when(animeService.delete(ArgumentMatchers.anyInt()))
                .thenReturn(Mono.empty());

        BDDMockito.when(animeService.save(AnimeCreator.animeToBeSaved()))
                .thenReturn(Mono.just(anime));

        BDDMockito.when(animeService.update(AnimeCreator.animeValid()))
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
        StepVerifier.create(animeController.listAll())
                .expectSubscription()
                .expectNext(anime)
                .verifyComplete();
    }

    @Test
    @DisplayName("findById Anime return Mono of Anime when succesfull")
    public void findById_ReturnMonoOfAnime_WhenSuccesfull(){
        StepVerifier.create(animeController.findById(1))
                .expectSubscription()
                .expectNext(Anime.builder()
                        .id(869)
                        .name("Injetado pelo Mockito")
                        .build())
                .verifyComplete();
    }

    @Test
    @DisplayName("Save a anime when succesfull")
    public void save_A_Anime_whenSuccesfull(){
        StepVerifier.create(animeController.save(AnimeCreator.animeToBeSaved()))
                .expectSubscription()
                .expectNext(anime)
                .verifyComplete();
    }

    @Test
    @DisplayName("Delete Anime when succesfull")
    public void deleteAnime_WhenSuccesfull(){
        StepVerifier.create(animeController.delete(1))
                .expectSubscription()
                .verifyComplete();
    }



    @Test
    @DisplayName("Update Anime when succesfull")
    public void update_Aime_WhenSuccesfull(){
        StepVerifier.create(animeController.update(1,AnimeCreator.animeValid()))
                .expectSubscription()
                .verifyComplete();
    }



}