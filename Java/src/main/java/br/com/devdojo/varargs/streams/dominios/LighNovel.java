package br.com.devdojo.varargs.streams.dominios;

import java.util.Objects;

public class LighNovel {
    private String title;
    private double price;

    private Category category;

    public LighNovel(String title, double price) {
        this.title = title;
        this.price = price;
    }

    public LighNovel(String title, double price, Category category) {
        this.title = title;
        this.price = price;
        this.category = category;
    }

    public String getTitle() {
        return title;
    }

    public double getPrice() {
        return price;
    }

    public Category getCategory() {
        return category;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LighNovel lighNovel = (LighNovel) o;
        return Objects.equals(title, lighNovel.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title);
    }

    @Override
    public String toString() {
        return "LighNovel{" +
                "title='" + title + '\'' +
                ", price=" + price +
                ", category=" + category +
                '}';
    }
}
