package br.com.devdojo.varargs.concorrencia.test;

import br.com.devdojo.varargs.concorrencia.test.services.StoreService;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class CompletableFutureTest01 {
    public static void main(String[] args) {
        StoreService storeService = new StoreService();
//        searchPricesSync(storeService);
        searchPricesAsyncFuture(storeService);
    }

    private static void searchPricesSync(StoreService storeService){
        long start = System.currentTimeMillis();
        System.out.println(storeService.getPriceSync("Store 1"));
        System.out.println(storeService.getPriceSync("Store 2"));
        System.out.println(storeService.getPriceSync("Store 3"));
        System.out.println(storeService.getPriceSync("Store 4"));
        long end =System.currentTimeMillis();
        System.out.printf("Time passed to searchPricesSync %d%n",end -start);
    }

    private static void searchPricesAsyncFuture(StoreService storeService){
        long start = System.currentTimeMillis();
        Future<Double> pricesAsyncFuture = storeService.getPricesAsyncFuture("Store 1");
        Future<Double> pricesAsyncFuture1 = storeService.getPricesAsyncFuture("Store 2");
        Future<Double> pricesAsyncFuture2 = storeService.getPricesAsyncFuture("Store 3");
        Future<Double> pricesAsyncFuture3 = storeService.getPricesAsyncFuture("Store 4");
        try {
            pricesAsyncFuture .get();
            pricesAsyncFuture1.get();
            pricesAsyncFuture2.get();
            pricesAsyncFuture3.get();
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
        long end =System.currentTimeMillis();
        System.out.printf("Time passed to searchPricesSync %d%n",end -start);
        StoreService.shutDown();

    }
}
