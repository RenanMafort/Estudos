package melhorias.thread.completable.future.encadeamento;

public final class Quote {
    private final String store;
    private final double price;
    private final Discount.Code discCode;

    private Quote(String store, double price, Discount.Code discCode) {
        this.store = store;
        this.price = price;
        this.discCode = discCode;
    }

    /*
    *Creates new Quote object from the value following the pattern storeName:price:discountCode
    *
    * @param value cotaining storeName:price:discountCode
    * @return new Quote with values from @param value
    * */
    public static Quote newQuote(String value){
        String[] values = value.split(":");
        return new Quote(values[0],Double.parseDouble(values[1]), Discount.Code.valueOf(values[2]));
    }

    public String getStore() {
        return store;
    }

    public double getPrice() {
        return price;
    }

    public Discount.Code getDiscCode() {
        return discCode;
    }
}
