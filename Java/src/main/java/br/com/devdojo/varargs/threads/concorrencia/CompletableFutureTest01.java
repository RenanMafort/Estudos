package br.com.devdojo.varargs.threads.concorrencia;

import br.com.devdojo.varargs.threads.concorrencia.service.StoreSerivce;

import java.util.concurrent.ExecutionException;

public class CompletableFutureTest01 {
    public static void main(String[] args) {
        StoreSerivce storeSerivce = new StoreSerivce();
        searchPriceSync(storeSerivce);

    }

    private static void searchPriceSync(StoreSerivce storeSerivce){
        long start = System.currentTimeMillis();
        System.out.println(storeSerivce.getPriceSync("Store 1"));
        System.out.println(storeSerivce.getPriceSync("Store 2"));
        System.out.println(storeSerivce.getPriceSync("Store 3"));
        System.out.println(storeSerivce.getPriceSync("Store 4"));
        long end = System.currentTimeMillis();
        System.out.printf("Time passed to searchPriceSync %d%n",end-start);

    }
    private static void searchPricesAsyncFuture(StoreSerivce storeSerivce){
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
    }
}
