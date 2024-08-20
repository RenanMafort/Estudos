package sereia.renan.springwebflux.service;

import io.netty.util.internal.StringUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.server.ResponseStatusException;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import sereia.renan.springwebflux.domain.Anime;
import sereia.renan.springwebflux.repositorie.AnimeRepositorie;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AnimeService {

    private final AnimeRepositorie repositorie;

    public Flux<Anime> findAll(){
        return repositorie.findAll();
    }

    @Transactional
    public Flux<Anime> saveAll(List<Anime> anime){
        return repositorie.saveAll(anime)
                .doOnNext(this::throwResponseStatusExceptionWhenNameIsEmPt);
    }

    private void throwResponseStatusExceptionWhenNameIsEmPt(Anime anime){
        if (StringUtil.isNullOrEmpty(anime.getName())){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Name is empty");
        }
    }

    public Mono<Anime> findById(Integer id){
        return repositorie.findById((int)id)
                .switchIfEmpty(monoResponseStatusNotFoundExcecption());
    }

    private <T> Mono<T> monoResponseStatusNotFoundExcecption(){
        return Mono.error(new ResponseStatusException(HttpStatus.NOT_FOUND,"Anime NOT found"));
    }

    public Mono<Anime> save(Anime anime) {
        return repositorie.save(anime);
    }

    public Mono<Void> update(Anime anime){
        return findById(anime.getId())
                .flatMap(repositorie::save)
                .then();
    }

    public Mono<Void> delete(int id){
        return this.findById(id)
                .flatMap(repositorie::delete)                ;
    }
}
