package br.com.devdojo.varargs.concorrencia.test;

import br.com.devdojo.varargs.concorrencia.test.services.StoreService;
import br.com.devdojo.varargs.concorrencia.test.services.StoreServiceDeprecated;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

public class CompletableFutureTest03 {
    public static void main(String[] args) {
        StoreServiceDeprecated storeServiceDeprecated = new StoreServiceDeprecated();
        searchPricesAsyncComplatableFurute(storeServiceDeprecated);
    }

    private static void searchPricesAsyncComplatableFurute(StoreServiceDeprecated storeServiceDeprecated) {
        long start = System.currentTimeMillis();
        List<String> stores = List.of("Store1","Store2","Store3","Store4");
        List<CompletableFuture<Double>> collect = stores.stream()
                .map(s -> CompletableFuture.supplyAsync(() -> storeServiceDeprecated.getPriceSync(s)))
                .collect(Collectors.toList());
        List<Double> collect1 = collect.stream()
                .map(CompletableFuture::join).collect(Collectors.toList());

        System.out.println(collect1);


        long end = System.currentTimeMillis();
        System.out.printf("Time passed to searchPricesSync %d%n", end - start);


    }
}
