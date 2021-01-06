package com.library.management.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SearchReq {

    private String filterBy;

    private String name;

    private String author;

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("SearchBook{");
        sb.append("filterBy='").append(filterBy).append('\'');
        sb.append(", name='").append(name).append('\'');
        sb.append(", author='").append(author).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
