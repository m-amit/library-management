package com.library.management.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Book implements Comparable<Book>, Serializable {

    private static final long serialVersionUID = 7191261688088809849L;

    private String name;

    private String author;

    private Date publicationDate;

    private Double price;

    private String thumbnail;

    private String language;

    private String uri;

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Book{");
        sb.append("name='").append(name).append('\'');
        sb.append(", author='").append(author).append('\'');
        sb.append(", publicationDate=").append(publicationDate);
        sb.append(", price=").append(price);
        sb.append(", thumbnailImage='").append(thumbnail).append('\'');
        sb.append(", language='").append(language).append('\'');
        sb.append('}');
        return sb.toString();
    }

    @Override
    public int compareTo(Book o) {
        return this.name.compareTo(o.getName());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(name, book.name) && Objects.equals(author, book.author) && Objects.equals(publicationDate, book.publicationDate) && Objects.equals(price, book.price) && Objects.equals(thumbnail, book.thumbnail) && Objects.equals(language, book.language) && Objects.equals(uri, book.uri);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, author, publicationDate, price, thumbnail, language, uri);
    }
}
