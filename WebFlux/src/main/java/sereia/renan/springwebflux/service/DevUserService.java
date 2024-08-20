package sereia.renan.springwebflux.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.ReactiveUserDetailsService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import sereia.renan.springwebflux.repositorie.DevRenanUserRepository;

@Service
@RequiredArgsConstructor
public class DevUserService implements ReactiveUserDetailsService {

    private final DevRenanUserRepository devuser;
    @Override
    public Mono<UserDetails> findByUsername(String name) {
        return devuser.findByUsername(name)
                .cast(UserDetails.class);
    }
}
