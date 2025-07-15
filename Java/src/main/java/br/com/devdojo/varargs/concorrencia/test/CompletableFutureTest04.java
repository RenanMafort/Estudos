package br.com.devdojo.varargs.concorrencia.test;

import br.com.devdojo.varargs.concorrencia.test.dominio.Quote;
import br.com.devdojo.varargs.concorrencia.test.services.StoreServiceWithDiscount;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

public class CompletableFutureTest04 {
    public static void main(String[] args) {
        StoreServiceWithDiscount service = new StoreServiceWithDiscount();
        searchPricesWithDiscount(service);
    }

    private static void searchPricesWithDiscount(StoreServiceWithDiscount service){
        List<String> stores = List.of("Store1","Store2","Store3","Store4");
//        stores.forEach(s -> System.out.println(service.getPriceSync(s)));

        stores.stream()
                .map(service::getPriceSync)//store:price:code
                .map(Quote::newQuote)
                .map(service::pplyDiscount)
                .forEach(System.out::println);

    }private static void searchPricesWithDiscountAsync(StoreServiceWithDiscount service){
        List<String> stores = List.of("Store1","Store2","Store3","Store4");
//        stores.forEach(s -> System.out.println(service.getPriceSync(s)));

        List<CompletableFuture<String>> collect = stores.stream()
                .map(s -> CompletableFuture.supplyAsync(() -> service.getPriceSync(s)))
                .map(cf -> cf.thenApply(Quote::newQuote))
                .map(cf -> cf.thenCompose(quote ->
                        CompletableFuture.supplyAsync(() -> service.pplyDiscount(quote))))
                .toList();

        collect.stream().map(CompletableFuture::join).forEach(System.out::println);
    }
}
