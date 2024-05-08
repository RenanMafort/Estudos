package br.com.devdojo.varargs.padroesdeprojeto.dominio.test;

import br.com.devdojo.varargs.padroesdeprojeto.dominio.Country;
import br.com.devdojo.varargs.padroesdeprojeto.dominio.Currency;
import br.com.devdojo.varargs.padroesdeprojeto.dominio.CurrencyFactory;

public class CurrencyFactoryTest01 {
    public static void main(String[] args) {
        Currency currency = CurrencyFactory.newCurrency(Country.BRAZIL);
        System.out.println(currency.getSymbol());
    }
}
