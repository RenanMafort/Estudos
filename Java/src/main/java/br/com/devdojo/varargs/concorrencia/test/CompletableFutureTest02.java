package br.com.devdojo.varargs.concorrencia.test;

import br.com.devdojo.varargs.concorrencia.test.services.StoreService;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CompletableFutureTest02 {
    public static void main(String[] args) {
        StoreService storeService = new StoreService();
        searchPricesAsyncComplatableFurute(storeService);
    }

    private static void searchPricesAsyncComplatableFurute(StoreService storeService) {
        long start = System.currentTimeMillis();
        List<String> stores = List.of("Store1","Store2","Store3","Store4");

        List<CompletableFuture<Double>> collect = stores.stream()
                .map(storeService::getPricesAsyncCompletableFuture).collect(Collectors.toList());

        List<Double> collect1 = collect.stream().map(CompletableFuture::join).collect(Collectors.toList());
        System.out.println(collect1);
        long end = System.currentTimeMillis();
        System.out.printf("Time passed to searchPricesSync %d%n", end - start);


    }
}
