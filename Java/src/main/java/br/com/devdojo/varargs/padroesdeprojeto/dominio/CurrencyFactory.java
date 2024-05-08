package br.com.devdojo.varargs.padroesdeprojeto.dominio;

public class CurrencyFactory {
    public static Currency newCurrency(Country country){
        return switch (country) {
            case BRAZIL -> new Real();
            case USA -> new Dollar();
            default -> throw new IllegalArgumentException("No currency found for this country");
        };

    }
}
