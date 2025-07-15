package melhorias.thread.completable.future.encadeamento;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class Teste {
    public static void main(String[] args) {
        StoreServiceWithDiscount storeServiceWithDiscount = new StoreServiceWithDiscount();
        searchPricesWithDiscount(storeServiceWithDiscount);
        searchPricesWithDiscountAsync(storeServiceWithDiscount);
    }


    private static void searchPricesWithDiscount(StoreServiceWithDiscount service){
        List<String> stores = List.of("Store 1","Store 2","Store 3","Store 4");
//        stores.forEach(s -> System.out.println(service.getPriceSync(s)));
        stores.stream()
                .map(service::getPriceSync)
                .map(Quote::newQuote)
                .map(service::applyDiscount)
                .forEach(System.out::println);
    }


    private static void searchPricesWithDiscountAsync(StoreServiceWithDiscount service){
        long start = System.currentTimeMillis();

        List<String> stores = List.of("Store 1","Store 2","Store 3","Store 4");

       var completableFutureList = stores.stream()
                .map(s -> CompletableFuture.supplyAsync(() -> service.getPriceSync(s)))
                .map(cf -> cf.thenApply(Quote::newQuote))
                .map(cf -> cf.thenCompose(quote -> CompletableFuture.supplyAsync(() -> service.applyDiscount(quote))))
                .map(cf -> cf.thenAccept(store -> System.out.printf("%s finished in %d%n", store, (System.currentTimeMillis() - start))))
                .toArray(CompletableFuture[]::new);

//        completableFutureList.stream().map(CompletableFuture::join)
//                .forEach(System.out::println);

//        CompletableFuture<Void> voidCompletableFuture = CompletableFuture.allOf(completableFutureList);
        CompletableFuture<Object> objectCompletableFuture = CompletableFuture.anyOf(completableFutureList);
        objectCompletableFuture.join();

        long end = System.currentTimeMillis();
    }
}
