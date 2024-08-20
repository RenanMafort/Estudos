package sereia.renan.springwebflux.service;

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
import sereia.renan.springwebflux.util.AnimeCreator;

import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
class AnimeServiceTest {

    @InjectMocks
    private AnimeService animeService;

    @Mock
    private AnimeRepositorie animeRepositorie;

    private final Anime anime = AnimeCreator.animeValid();


    @BeforeAll
    public static void blockHoundSetup(){
        BlockHound.install();
    }

    @BeforeEach
    public void setUp(){
        BDDMockito.when(animeRepositorie.findAll())
                .thenReturn(Flux.just(anime));

        BDDMockito.when(animeRepositorie.findById(ArgumentMatchers.anyInt()))
                .thenReturn(Mono.just(anime));

        BDDMockito.when(animeRepositorie.save(AnimeCreator.animeToBeSaved()))
                .thenReturn(Mono.just(anime));

        BDDMockito.when(animeRepositorie.delete(ArgumentMatchers.any(Anime.class)))
                .thenReturn(Mono.empty());

        BDDMockito.when(animeRepositorie.save(AnimeCreator.animeToBeSaved()))
                .thenReturn(Mono.just(anime));

        BDDMockito.when(animeRepositorie.save(AnimeCreator.animeValid()))
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
        StepVerifier.create(animeService.findAll())
                .expectSubscription()
                .expectNext(anime)
                .verifyComplete();
    }

    @Test
    @DisplayName("findById Anime return Mono of Anime when succesfull")
    public void findById_ReturnMonoOfAnime_WhenSuccesfull(){
        StepVerifier.create(animeService.findById(1))
                .expectSubscription()
                .expectNext(anime)
                .verifyComplete();
    }

    @Test
    @DisplayName("findById  return Mono Error  when empty mono is returned")
    public void findById_ReturnMonoError_WhenEmptyMonoIsReturned(){
        BDDMockito
                .when(animeRepositorie.findById(ArgumentMatchers.anyInt()))
                        .thenReturn(Mono.empty());

        StepVerifier.create(animeService.findById(1))
                .expectSubscription()
                .expectError(ResponseStatusException.class)
                .verify();
    }

    @Test
    @DisplayName("Save a anime when succesfull")
    public void save_A_Anime_whenSuccesfull(){
        StepVerifier.create(animeService.save(AnimeCreator.animeToBeSaved()))
                .expectSubscription()
                .expectNext(anime)
                .verifyComplete();
    }

    @Test
    @DisplayName("Delete Anime when succesfull")
    public void deleteAnime_WhenSuccesfull(){
        StepVerifier.create(animeService.delete(1))
                .expectSubscription()
                .verifyComplete();
    }

    @Test
    @DisplayName("Delete Anime when succesfull")
    public void delete_returnMonoError_WhenEmptyIsReturned(){
        BDDMockito
                .when(animeRepositorie.findById(ArgumentMatchers.anyInt()))
                .thenReturn(Mono.empty());
        StepVerifier.create(animeService.delete(1))
                .expectSubscription()
                .expectError(ResponseStatusException.class)
                .verify();
    }

    @Test
    @DisplayName("Update Anime when succesfull")
    public void update_Aime_WhenSuccesfull(){
        StepVerifier.create(animeService.update(AnimeCreator.animeValid()))
                .expectSubscription()
                .verifyComplete();
    }

    @Test
    @DisplayName("Update anime return mono error when empty mono is returned")
    public void update_ReturnMonoError_WhenEmptyMonoIsReturned(){
        BDDMockito
                .when(animeRepositorie.findById(ArgumentMatchers.anyInt()))
                .thenReturn(Mono.empty());

        StepVerifier.create(animeService.update(AnimeCreator.animeValid()))
                .expectSubscription()
                .expectError(ResponseStatusException.class)
                .verify();
    }

}