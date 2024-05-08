package br.com.devdojo.varargs.concorrencia.test.services;

import br.com.devdojo.varargs.concorrencia.test.dominio.Discount;
import br.com.devdojo.varargs.concorrencia.test.dominio.Quote;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class StoreServiceWithDiscount {

    public String getPriceSync(String storeName){
        System.out.printf("Getting prices sync for store %s%n",storeName);
        double price = priceGenerator();
        Discount.Code value = Discount.Code.values()[ThreadLocalRandom.current().nextInt(Discount.Code.values().length)];

        return String.format("%s:%.2f:%s",storeName,price,value);
    }

    public String pplyDiscount(Quote quote){
        delay();
        double discountValue = quote.getPrice() * (100 - quote.getDiscountCode().getPercentage()) / 100;
        return String.format("'%s' original price: '%.2f'. Applying discount code '%s'. Final Price: '%.2f'",
                quote.getStore(),
                quote.getPrice(),
                quote.getDiscountCode(),
                discountValue);
    }

    private double priceGenerator(){
        System.out.printf("%s generating price %n", Thread.currentThread().getName());
        delay();
        return ThreadLocalRandom.current().nextInt(1,500) * 10;
    }


    private void delay(){
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
