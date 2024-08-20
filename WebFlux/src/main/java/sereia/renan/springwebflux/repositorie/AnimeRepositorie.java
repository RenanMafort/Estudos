package sereia.renan.springwebflux.repositorie;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Mono;
import sereia.renan.springwebflux.domain.Anime;

public interface AnimeRepositorie extends ReactiveCrudRepository<Anime,Integer> {

    Mono<Anime> findById(int integer);
}
