package melhorias.thread.completable.future.stream;

import melhorias.thread.completable.future.StoreService;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class Teste {
    public static void main(String[] args) {

        StoreService storeService = new StoreService();
        searchPriceStreamCompletableFuture(storeService);

    }

    private static void searchPriceStreamCompletableFuture(StoreService storeService){
        long start = System.currentTimeMillis();
        List<String> stores = List.of("Store 1","Store 2","Store 3","Store 4");

        List<CompletableFuture<Double>> list = stores.stream()
                .map(storeService::getPricesAsyncComplateFuture).toList();

        List<Double> nums = list.stream().map(CompletableFuture::join).toList();

        System.out.println(nums);

        long end = System.currentTimeMillis();

        System.out.printf("Time passed to searchPricesSync %dms%n", (end-start));
    }
}
