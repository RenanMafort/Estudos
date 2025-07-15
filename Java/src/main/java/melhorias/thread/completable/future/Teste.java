package melhorias.thread.completable.future;


import melhorias.thread.completable.future.StoreService;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class Teste {
    public static void main(String[] args) {
        StoreService storeSerivce = new StoreService();
//        searchPriceSync(storeSerivce);
        searchPricesAsyncFutureErrado(storeSerivce);
//        searchPricesAsyncFutureCerto(storeSerivce);
//        searchPricesAsyncCompletableFutureCerto(storeSerivce);

    }

    private static void searchPriceSync(StoreService storeSerivce){
        long start = System.currentTimeMillis();
        System.out.println(storeSerivce.getPriceSync("Store 1"));
        System.out.println(storeSerivce.getPriceSync("Store 2"));
        System.out.println(storeSerivce.getPriceSync("Store 3"));
        System.out.println(storeSerivce.getPriceSync("Store 4"));
        long end = System.currentTimeMillis();
        System.out.printf("Time passed to searchPriceSync %d%n",end-start);
        StoreService.shutDown();

    }

    private static void searchPricesAsyncFutureErrado(StoreService storeSerivce){
        long start = System.currentTimeMillis();


        try {
            storeSerivce.getPricesAsyncFuture("Store 1").get();
            storeSerivce.getPricesAsyncFuture("Store 2").get();
            storeSerivce.getPricesAsyncFuture("Store 3").get();
            storeSerivce.getPricesAsyncFuture("Store 4").get();
        }catch (InterruptedException | ExecutionException e){
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        System.out.printf("Time passed to searchPriceSync %d%n",end-start);

        StoreService.shutDown();
    }

    private static void searchPricesAsyncFutureCerto(StoreService storeSerivce){
        long start = System.currentTimeMillis();

        Future<Double> pricesAsyncFuture1 = storeSerivce.getPricesAsyncFuture("Store 1");
        Future<Double> pricesAsyncFuture2 = storeSerivce.getPricesAsyncFuture("Store 2");
        Future<Double> pricesAsyncFuture3 = storeSerivce.getPricesAsyncFuture("Store 3");
        Future<Double> pricesAsyncFuture4 = storeSerivce.getPricesAsyncFuture("Store 4");
        try {
            Double v1 = pricesAsyncFuture1.get();
            Double v2 = pricesAsyncFuture2.get();
            Double v3 = pricesAsyncFuture3.get();
            Double v4 = pricesAsyncFuture4.get();
            System.out.println(v1 + "" + v2 + v3 + v4);
        }catch (InterruptedException | ExecutionException e){
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        System.out.printf("Time passed to searchPriceSync %d%n",end-start);

        StoreService.shutDown();
    }

    private static void searchPricesAsyncCompletableFutureCerto(StoreService storeSerivce){
        long start = System.currentTimeMillis();

        CompletableFuture<Double> pricesAsyncFuture1 = storeSerivce.getPricesAsyncComplateFuture("Store 1");
        CompletableFuture<Double> pricesAsyncFuture2 = storeSerivce.getPricesAsyncComplateFuture("Store 2");
        CompletableFuture<Double> pricesAsyncFuture3 = storeSerivce.getPricesAsyncComplateFuture("Store 3");
        CompletableFuture<Double> pricesAsyncFuture4 = storeSerivce.getPricesAsyncComplateFuture("Store 4");
        System.out.println(pricesAsyncFuture1.join());
        System.out.println(pricesAsyncFuture2.join());
        System.out.println(pricesAsyncFuture3.join());
        System.out.println(pricesAsyncFuture4.join());


        long end = System.currentTimeMillis();
        System.out.printf("Time passed to searchPriceSync %d%n",end-start);

    }
}
