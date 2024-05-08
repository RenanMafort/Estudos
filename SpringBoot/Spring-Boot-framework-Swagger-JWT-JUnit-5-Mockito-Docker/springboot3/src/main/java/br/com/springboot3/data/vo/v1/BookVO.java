package br.com.springboot3.data.vo.v1;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.github.dozermapper.core.Mapping;
import org.springframework.hateoas.RepresentationModel;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@JsonPropertyOrder({"key","title","price","lauchDate","author"})
public class BookVO extends RepresentationModel<BookVO> implements Serializable {
    @Serial
    private static final long serialVersionUID = -5094945975289256352L;

    @Mapping("id")
    @JsonProperty("id")
    private Long key;
    private String author;
    @JsonProperty("lauch_date")
    private Date lauchDate;
    private Double price;
    private String title;

    public BookVO() {

    }

    public Long getKey() {
        return key;
    }

    public void setKey(Long key) {
        this.key = key;
    }


    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Date getLauchDate() {
        return lauchDate;
    }

    public void setLauchDate(Date lauchDate) {
        this.lauchDate = lauchDate;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        BookVO bookVO = (BookVO) o;
        return Objects.equals(key, bookVO.key) && Objects.equals(author, bookVO.author) && Objects.equals(lauchDate, bookVO.lauchDate) && Objects.equals(price, bookVO.price) && Objects.equals(title, bookVO.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), key, author, lauchDate, price, title);
    }
}
