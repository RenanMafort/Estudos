package br.com.springboot3.model;

import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "books")
public class Book implements Serializable {
    @Serial
    private static final long serialVersionUID = -5094945975289256352L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 180)
    private String author;
    @Column(name = "launch_date",nullable = false)
    @Temporal(TemporalType.DATE)
    private Date lauchDate;
    @Column(nullable = false)
    private Double price;
    @Column(nullable = false,length = 250) //6 char to 'Female'
    private String title;

    public Book() {
    }

    public Long getId() {
        return id;
    }

    public String getAuthor() {
        return author;
    }

    public Date getLauchDate() {
        return lauchDate;
    }

    public Double getPrice() {
        return price;
    }

    public String getTitle() {
        return title;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setLauchDate(Date lauchDate) {
        this.lauchDate = lauchDate;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(id, book.id)
                && Objects.equals(author, book.author)
                && Objects.equals(lauchDate, book.lauchDate)
                && Objects.equals(price, book.price)
                && Objects.equals(title, book.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, author, lauchDate, price, title);
    }
}
