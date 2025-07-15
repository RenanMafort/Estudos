package melhorias.thread.completable.future.threadfactory;

import melhorias.thread.completable.future.StoreService;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Teste {

    public static void main(String[] args) {
        StoreService storeService = new StoreService();
        searchPricesAsyncCompletableFuture(storeService);
    }

    private static void searchPricesAsyncCompletableFuture(StoreService storeService){
        long start = System.currentTimeMillis();

        ExecutorService executorService = Executors.newFixedThreadPool(10, r -> {
            Thread thread = new Thread(r);
            thread.setDaemon(true);
            return thread;
        });

        List<String> stores = List.of("Store 1","Store 2","Store 3","Store 4");

        List<CompletableFuture<Double>> list = stores.stream()
                .map(s -> CompletableFuture.supplyAsync(() -> storeService.getPriceSync(s), executorService)).toList();

        List<Double> joins = list.stream().map(CompletableFuture::join)
                .toList();

        System.out.println(joins);
        long end = System.currentTimeMillis();
        System.out.println("Time - " + (end - start));
    }
}
