package sereia.renan.springwebflux.repositorie;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Mono;
import sereia.renan.springwebflux.domain.DevRenanUser;

public interface DevRenanUserRepository extends ReactiveCrudRepository<DevRenanUser,Integer> {

    Mono<DevRenanUser> findByUsername(String name);
}
