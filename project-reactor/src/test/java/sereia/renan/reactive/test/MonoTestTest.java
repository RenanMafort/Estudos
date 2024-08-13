package sereia.renan.reactive.test;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.reactivestreams.Subscription;
import reactor.blockhound.BlockHound;
import reactor.blockhound.BlockingOperationError;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;
import reactor.test.StepVerifier;

import java.util.Objects;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
/**
 * 1. Asynchronous
 * 2. Non-blocking
 * 3. Backpressure
 * Publisher <- (subscribe) Subscriber
 * Subscription is created
 * Publisher (onSubscribe with the subscription) -> Subscriber
 * Subscription <-(request N) Subscriber
 * Publisher -> (onNext) Subscriber
 * until:
 * 1. Publisher sends all the objects requested.
 * 2. Publisher sends all the objects it has. (onComplete) subscriber and subscription will be canceled.
 * 3. There is an error. (onError) -> subscriber and subscription will be canceled.
 */
class MonoTestTest {

    @BeforeAll
    public static void setUp(){
        BlockHound.install();
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
    public void monoSubscriber(){
        String name = "Renan Mafort Sereia";
        Mono<String> mono = Mono.just(name).log();

        mono.subscribe();
        log.info("--------------------------");
        StepVerifier.create(mono)
                        .expectNext(name)
                                .verifyComplete();

    }

    @Test
    public void monoSubscriberConsumer(){
        String name = "Renan Mafort Sereia";
        Mono<String> mono = Mono.just(name).log();

        mono.subscribe(msg -> log.info("value - {}",msg));
        log.info("--------------------------");
        StepVerifier.create(mono)
                .expectNext(name)
                .verifyComplete();

    }

    @Test
    public void monoSubscriberConsumerError(){
        String name = "Renan Mafort Sereia";
        Mono<String> mono = Mono.just(name)
                .handle((s, sink) -> {
                    sink.error(new RuntimeException("Testing mono with error"));
                });

        mono.subscribe(msg -> log.info("value - {}",msg),msg -> log.error("Something bad error"));
        mono.subscribe(msg -> log.info("value - {}",msg),Throwable::printStackTrace);
        log.info("--------------------------");
        StepVerifier.create(mono)
                .expectError(RuntimeException.class)
                .verify();

    }

    @Test
    public void monoSubscriberConsumerComplete() {
        String name = "Renan Mafort Sereia";
        Mono<String> mono = Mono.just(name).log().map(String::toUpperCase);

        mono.subscribe(msg -> log.info("value - {}", msg),
                Throwable::printStackTrace,
                () -> log.info("FINISHED!!"),
                Subscription::cancel);
        log.info("--------------------------");
        StepVerifier.create(mono)
                .expectNext(name.toUpperCase())
                .verifyComplete();
    }

    @Test
    public void monoSubscriberConsumerSubscription() {
        String name = "Renan Mafort Sereia";
        Mono<String> mono = Mono.just(name).log().map(String::toUpperCase);

        mono.subscribe(msg -> log.info("value - {}", msg),
                Throwable::printStackTrace,
                () -> log.info("FINISHED!!"),
                s -> s.request(5));
        log.info("--------------------------");
        StepVerifier.create(mono)
                .expectNext(name.toUpperCase())
                .verifyComplete();
    }

    @Test
    public void monoDoOnMethods() {
        String name = "Renan Mafort Sereia";
        Mono<Object> mono = Mono.just(name)
                .log()
                .map(String::toUpperCase)
                .doOnSubscribe(subscription -> log.info("Subscribed"))
                        .doOnRequest(longnumber -> log.info("Request received, starting doing something..."))
                                .doOnNext(s -> log.info("Value is here,Executing doOnNext {}",s))
                .flatMap(s -> Mono.empty())
                                .doOnNext(s -> log.info("Value is here,Executing doOnNext {}",s)) //Will not be executed
                                        .doOnSuccess(s -> log.info("doOnSuccess executed"));


        mono.subscribe(msg -> log.info("value - {}", msg),
                Throwable::printStackTrace,
                () -> log.info("FINISHED!!"));
        log.info("--------------------------");
    }

    @Test
    public void monoDoOnError() {
        Mono<Object> logs = Mono.error(new IllegalArgumentException("Illegal Argument Exception"))
                .doOnError(s -> log.error("Error message: {}", s.getMessage()))
                .doOnNext(l -> log.info("Executing this doOnNext"))
                .log();

        StepVerifier.create(logs)
                .expectError(IllegalArgumentException.class)
                .verify();
    }

    @Test
    public void monoDoOnErrorResume() {
        String name = "Renan Mafort Sereia";
        Mono<Object> logs = Mono.error(new IllegalArgumentException("Illegal Argument Exception"))
                .doOnError(s -> log.error("Error message: {}", s.getMessage()))
                .onErrorResume(s -> {
                    log.info("Inside onErrorResume");
                    return Mono.just(name);
                })
                .log();

        StepVerifier.create(logs)
                .expectNext(name)
                .verifyComplete();
    }

    @Test
    public void monoDoOnErrorReturn() {
        String name = "Renan Mafort Sereia";
        Mono<Object> logs = Mono.error(new IllegalArgumentException("Illegal Argument Exception"))
                .onErrorReturn("EMPTY")
                .onErrorResume(s -> {
                    log.info("Inside onErrorResume");
                    return Mono.just(name);
                })
                .doOnError(s -> log.error("Error message: {}", s.getMessage()))
                .log();

        StepVerifier.create(logs)
                .expectNext("EMPTY")
                .verifyComplete();
    }
}