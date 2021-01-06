package com.library.management.models;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
public class Book implements Serializable {

    private static final long serialVersionUID = 7191261688088809849L;

    private String name;

    private String author;

    private Date publicationDate;

    private Double price;

    private String thumbnailImage;

    private String language;

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Book{");
        sb.append("name='").append(name).append('\'');
        sb.append(", author='").append(author).append('\'');
        sb.append(", publicationDate=").append(publicationDate);
        sb.append(", price=").append(price);
        sb.append(", thumbnailImage='").append(thumbnailImage).append('\'');
        sb.append(", language='").append(language).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
