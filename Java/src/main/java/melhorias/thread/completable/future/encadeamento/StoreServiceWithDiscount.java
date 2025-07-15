package melhorias.thread.completable.future.encadeamento;

import java.util.concurrent.*;

public class StoreServiceWithDiscount {

    private static final ExecutorService ex = Executors.newCachedThreadPool();
    public String getPriceSync(String storeName){
        double price = priceGenerator();

        Discount.Code value = Discount.Code.values()[
                ThreadLocalRandom.current().nextInt(Discount.Code.values().length)];
        return String.format("%s:%.2f:%s",storeName,price,value).replace(",",".");
    }

    public String applyDiscount(Quote quote){
        delay();
        double v = quote.getPrice() * (100 - quote.getDiscCode().getPerncetage()) / 100;
        return String.format("'%s' original price: '%.2f'. Applying discount code '%s'. Final price: '%.2f'",
                quote.getStore(),
                quote.getPrice(),
                quote.getDiscCode(),
                v);
    }

    public Future<Double> getPricesAsyncFuture(String storeName){
        System.out.printf("Getting prices sync for store %s%n",storeName);

        return ex.submit(this::priceGenerator);
    }


    public CompletableFuture<Double> getPricesAsyncComplateFuture(String storeName){
        System.out.printf("Getting prices sync for store %s%n",storeName);

        return CompletableFuture.supplyAsync(this::priceGenerator);
    }
    public static void shutDown(){
        ex.shutdown();
    }
    private double priceGenerator(){
        delay();
        return ThreadLocalRandom.current().nextInt(1,500) * 10;
    }

    private void delay(){
        try {
            TimeUnit.SECONDS.sleep(2);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
