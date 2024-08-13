package sereia.renan.reactive.test;

import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import reactor.core.publisher.BaseSubscriber;
import reactor.core.publisher.ConnectableFlux;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Slf4j
public class FluxTest {

    @Test
    public void fluxSubscriber() {
        Flux<String> log = Flux.just("Renan", "Mafort", "Sereia", "Da silva", "Almeida", "Aquino").log();

        StepVerifier.create(log)
                .expectNext("Renan", "Mafort", "Sereia", "Da silva", "Almeida", "Aquino")
                .verifyComplete();
    }

    @Test
    public void fluxSubscriberNumbers() {
        Flux<Integer> logs = Flux.range(1, 5).log();

        log.info("----------------------------");

        logs.subscribe(i -> log.info("Value - {}", i));

        StepVerifier.create(logs)
                .expectNext(1, 2, 3, 4, 5)
                .verifyComplete();
    }

    @Test
    public void fluxSubscriberFromList() {
        Flux<Integer> integerFlux = Flux.fromIterable(List.of(1, 2, 3, 4, 5))
                .log()
                .map(i -> {
                    if (i == 4) {
                        throw new IndexOutOfBoundsException("Index Error");
                    }
                    return i;
                });

        log.info("----------------------------");

        integerFlux.subscribe(i -> log.info("Value - {}", i), Throwable::printStackTrace,
                () -> log.info("DONEE !"), subscription -> subscription.request(3));

        log.info("----------------------------");


        StepVerifier.create(integerFlux)
                .expectNext(1, 2, 3)
                .expectError(IndexOutOfBoundsException.class)
                .verify();
    }

    @Test
    public void fluxSubscriberNumbersUglyBackpressure() {
        Flux<Integer> integerFlux = Flux.fromIterable(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10))
                .log();

        log.info("----------------------------");

        integerFlux.subscribe(new Subscriber<Integer>() {
            private int count = 0;
            private int requestCounter = 2;
            private Subscription subscription;

            @Override
            public void onSubscribe(Subscription subscription) {
                this.subscription = subscription;
                subscription.request(requestCounter);
            }

            @Override
            public void onNext(Integer integer) {
                count++;
                if (count >= requestCounter) {
                    count = 0;
                    subscription.request(requestCounter);
                }
            }

            @Override
            public void onError(Throwable t) {
                log.error("ENTROU NO ERROR!");
            }

            @Override
            public void onComplete() {
                log.info("ENTROU NO onClomplete!");
            }
        });

        log.info("-------------");

        StepVerifier.create(integerFlux)
                .expectNext(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
                .verifyComplete();
    }

    @Test
    public void fluxSubscriberNumbersNotSoUglyBackpressure() {
        Flux<Integer> integerFlux = Flux.fromIterable(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10))
                .log();

        log.info("----------------------------");

        integerFlux.subscribe(new BaseSubscriber<>() {
            private int count = 0;
            private final int requestCounter = 2;
            @Override
            protected void hookOnSubscribe(Subscription subscription) {
                request(requestCounter);
            }
            @Override
            protected void hookOnNext(Integer value) {
                count++;
                if (count >= requestCounter) {
                    count = 0;
                    request(requestCounter);
                }
            }
        });

        log.info("-------------");
        StepVerifier.create(integerFlux)
                .expectNext(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
                .verifyComplete();
    }

    @Test
    public void fluxSubscriberPrettyBackPressure() {
        Flux<Integer> logs = Flux.range(1, 10)
                .log()
                .limitRate(3); // Pega de 3 em 3

        log.info("----------------------------");

        logs.subscribe(i -> log.info("Value - {}", i));

        StepVerifier.create(logs)
                .expectNext(1, 2, 3, 4, 5,6,7,8,9,10)
                .verifyComplete();
    }

    @Test
    public void fluxSubscriberWithIntervalOne() throws InterruptedException {
        Flux<Long> log1 = Flux.interval(Duration.ofMillis(100))
                .take(8)
                .log();

        log1.subscribe(i -> log.info("Value - {}",i));

        TimeUnit.SECONDS.sleep(3);
    }

    @Test
    public void fluxSubscriberWithIntervalTwo() throws InterruptedException {

        StepVerifier.withVirtualTime(this::createInterval)
                .expectSubscription()
                .thenAwait(Duration.ofSeconds(10))
                .expectNext(0L)
                .expectNext(1L)
                .thenCancel()
                .verify();
    }

    private  Flux<Long> createInterval() {
        return Flux.interval(Duration.ofSeconds(5))
                .log();
    }

    @Test
    public void conectableFlux() throws Exception {
        ConnectableFlux<Integer> publish = Flux.range(1, 10)
//                .delayElements(Duration.ofMillis(100))
                .log()
                .publish();

//        publish.connect();

//        log.info("Thread sleeping for 300ms");
//        TimeUnit.MILLISECONDS.sleep(300);
//
//        publish.subscribe(i -> log.info("Sub1 number - {}",i));
//
//        TimeUnit.MILLISECONDS.sleep(200);
//        publish.subscribe(i -> log.info("Sub2 number - {}",i));

        StepVerifier.create(publish)
                .then(publish::connect)
                .thenConsumeWhile(i -> i<=5)
                .expectNext(6,7,8,9,10)
                .expectComplete()
                .verify();
    }




}
