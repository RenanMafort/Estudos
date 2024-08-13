package sereia.renan.reactive.test;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;
import reactor.test.StepVerifier;

import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

@Slf4j
public class OperatorTest {

    @Test
    public void subscriberOnSimple(){
        Flux<Integer> flux =
                Flux.range(1,4)
                        .map(i -> {
                            log.info("Map 1 - Number {} on Thread {}",i,Thread.currentThread().getName());
                            return i;
                        })
                        .subscribeOn(Schedulers.boundedElastic())
                        .map(i -> {
                            log.info("Map 2 - Number {} on Thread {}",i,Thread.currentThread().getName());
                            return i;
                        });

        StepVerifier.create(flux)
                .expectSubscription()
                .expectNext(1,2,3,4)
                .verifyComplete();
    }

    @Test
    public void publishOnSimple(){
        Flux<Integer> flux =
                Flux.range(1,4)
                        .map(i -> {
                            log.info("Map 1 - Number {} on Thread {}",i,Thread.currentThread().getName());
                            return i;
                        })
                        .publishOn(Schedulers.boundedElastic())
                        .map(i -> {
                            log.info("Map 2 - Number {} on Thread {}",i,Thread.currentThread().getName());
                            return i;
                        });

        StepVerifier.create(flux)
                .expectSubscription()
                .expectNext(1,2,3,4)
                .verifyComplete();
    }

    @Test
    public void subscribeOnIO(){
        Mono<List<String>> text = Mono.fromCallable(() -> Files.readAllLines(Path.of("text")))
                .log()
                .subscribeOn(Schedulers.boundedElastic());

        StepVerifier.create(text)
                .expectSubscription()
                .thenConsumeWhile( i -> {
                    Assertions.assertFalse(i.isEmpty());
                    log.info("Size - {}", i.size());
                    return true;
                })
                .verifyComplete();
    }

    @Test
    public void switchIfEmpty(){
        Flux<Object> flux = emptyFlux()
                .switchIfEmpty(Flux.just("not empty anymore"))
                .log();

        StepVerifier.create(flux)
                .expectSubscription()
                .expectNext("not empty anymore")
                .verifyComplete();
    }

    @Test
    public void deferOperator() throws Exception{
        Mono<Long> just = Mono.just(System.currentTimeMillis());
        Mono<Long> defer = Mono.defer(() -> Mono.just(System.currentTimeMillis()));

        defer.subscribe(l -> log.info("time {}",l));
        Thread.sleep(100);
        defer.subscribe(l -> log.info("time {}",l));
        Thread.sleep(100);
        defer.subscribe(l -> log.info("time {}",l));
        Thread.sleep(100);
        defer.subscribe(l -> log.info("time {}",l));

        AtomicLong atomicLong = new AtomicLong();
        defer.subscribe(atomicLong::set);
        Assertions.assertTrue(atomicLong.get() > 0);

    }

    @Test
    public void concat(){
        Flux<String> flux1 = Flux.just("a", "b");
        Flux<String> flux2 = Flux.just("c", "d");

        Flux<String> fluxConcat = Flux.concat(flux1, flux2).log();

        StepVerifier.create(fluxConcat)
                .expectSubscription()
                .expectNext("a","b","c","d")
                .verifyComplete();

    }

    @Test
    public void concatWith(){
        Flux<String> flux1 = Flux.just("a", "b");
        Flux<String> flux2 = Flux.just("c", "d");

        Flux<String> fluxConcat = flux1.concatWith(flux2).log();

        StepVerifier.create(fluxConcat)
                .expectSubscription()
                .expectNext("a","b","c","d")
                .verifyComplete();

    }

    @Test
    public void combineLatestConcat(){
        Flux<String> flux1 = Flux.just("a", "b").delayElements(Duration.ofMillis(400));
        Flux<String> flux2 = Flux.just("c", "d");

        Flux<String> combineLatest = Flux.combineLatest(flux1,flux2,
                (s1,s2) -> s1.toUpperCase() + s2.toUpperCase())
                .log();

        StepVerifier.create(combineLatest)
                .expectSubscription()
                .expectNext("BC","BD")
                .verifyComplete();

    }

    @Test
    public void mergeOperator() throws Exception{
        Flux<String> flux1 = Flux.just("a", "b").delayElements(Duration.ofMillis(200));
        Flux<String> flux2 = Flux.just("c", "d");

        Flux<String> merge = Flux.merge(flux1, flux2).log();

        merge.subscribe(log::info);
        Thread.sleep(1000);

        StepVerifier.create(merge)
                .expectSubscription()
                .expectNext("c","d","a","b")
                .verifyComplete();

    }

    @Test
    public void mergeWithOperator() throws Exception{
        Flux<String> flux1 = Flux.just("a", "b").delayElements(Duration.ofMillis(200));
        Flux<String> flux2 = Flux.just("c", "d");

        Flux<String> merge = flux1.mergeWith(flux2);

        merge.subscribe(log::info);
        Thread.sleep(1000);

        StepVerifier.create(merge)
                .expectSubscription()
                .expectNext("c","d","a","b")
                .verifyComplete();

    }

    @Test
    public void mergeSequentialOperator() throws Exception{
        Flux<String> flux1 = Flux.just("a", "b").delayElements(Duration.ofMillis(200));
        Flux<String> flux2 = Flux.just("c", "d");

        Flux<String> merge = Flux.mergeSequential(flux1,flux2,flux1);

        merge.subscribe(log::info);
        Thread.sleep(1000);

        StepVerifier.create(merge)
                .expectSubscription()
                .expectNext("a","b","c","d","a","b")
                .verifyComplete();

    }

    @Test
    public void concatOperatorError() throws Exception{
        Flux<String> flux1 = Flux.just("a", "b")
                .map(v -> {
                    if ("b".equals(v)){
                        throw new IllegalArgumentException("Argument not valid!");
                    }
                    return v;
                });

        Flux<String> flux2 = Flux.just("c", "d");

        Flux<String> merge = Flux.concatDelayError(flux1,flux2);

        merge.subscribe(log::info);
        Thread.sleep(1000);

        StepVerifier.create(merge)
                .expectSubscription()
                .expectNext("a","c","d")
                .expectError()
                .verify();

    }

    @Test
    public void mergeDelayErrorOperator() throws Exception{
        Flux<String> flux1 = Flux.just("a", "b")
                .map(v -> {
                    if ("b".equals(v)){
                        throw new IllegalArgumentException("Argument not valid!");
                    }
                    return v;
                }).doOnError(e -> log.info("We could do something with this"));

        Flux<String> flux2 = Flux.just("c", "d");

        Flux<String> merge = Flux.concatDelayError(flux1,flux2);

        merge.subscribe(log::info);
        Thread.sleep(1000);

        StepVerifier.create(merge)
                .expectSubscription()
                .expectNext("a","c","d")
                .expectError()
                .verify();
    }

    @Test
    public void flatMapOperator() throws Exception{
        Flux<String> flux = Flux.just("a", "b");

        Flux<String> flatFlux = flux.map(String::toUpperCase)
                .flatMap(this::findByName)
                .log();

        StepVerifier.create(flatFlux)
                .expectSubscription()
                .expectNext("nameB1","nameB2","nameA1","nameA2")
                .verifyComplete();
    }

    @Test
    public void flatMapSequentialsOperator() throws Exception{
        Flux<String> flux = Flux.just("a", "b");

        Flux<String> flatFlux = flux.map(String::toUpperCase)
                .flatMapSequential(this::findByName)
                .log();

        StepVerifier.create(flatFlux)
                .expectSubscription()
                .expectNext("nameA1","nameA2","nameB1","nameB2")
                .verifyComplete();
    }

    @Test
    public void zipOperator(){
        Flux<String> titleFlux = Flux.just("Grand blue", "Bak1");
        Flux<String> studioFlux = Flux.just("Zero-G", "TMS Entertaiment");
        Flux<Integer> episodeFlux = Flux.just(10,22);

        Flux<Anime> animeFlux = Flux.zip(titleFlux, studioFlux, episodeFlux)
                .flatMap(flux -> Flux.just(new Anime(flux.getT1(), flux.getT2(), flux.getT3())));

//        animeFlux.subscribe(l -> log.info(l.toString()));

        StepVerifier.create(animeFlux)
                .expectSubscription()
                .expectNext(
                        new Anime("Grand blue","Zero-G",10),
                        new Anime("Bak1","TMS Entertaiment",22)

                ).verifyComplete();
    }

    @Test
    public void zipWithOperator(){
        Flux<String> titleFlux = Flux.just("Grand blue", "Bak1");
        Flux<String> studioFlux = Flux.just("Zero-G", "TMS Entertaiment");
        Flux<Integer> episodeFlux = Flux.just(10,22);

        Flux<Anime> animeFlux = titleFlux.zipWith(episodeFlux)
                .flatMap(flux -> Flux.just(new Anime(flux.getT1(), null, flux.getT2())));

//        animeFlux.subscribe(l -> log.info(l.toString()));

        StepVerifier.create(animeFlux)
                .expectSubscription()
                .expectNext(
                        new Anime("Grand blue",null,10),
                        new Anime("Bak1",null,22)

                ).verifyComplete();
    }



    @AllArgsConstructor
    @Getter
    @ToString
    @EqualsAndHashCode
    class Anime{
        private String title;
        private String studio;
        private int episodes;
    }


    public Flux<String> findByName(String name){
        return "A".equals(name) ? Flux.just("nameA1","nameA2").delayElements(Duration.ofMillis(200)) : Flux.just("nameB1","nameB2");
    }


    private Flux<Object> emptyFlux(){
        return Flux.empty();
    }
}
