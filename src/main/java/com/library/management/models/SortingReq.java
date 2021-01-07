package com.library.management.models;

import lombok.Setter;

@Setter
public class SortingReq {

    private enum Order{ASCENDING,ascending, DESCENDING, descending};

    private enum SortBy{NAME, PRICE, name, price}

    private SortBy sortBy;

    private Order sortMethod;

    public String getSortBy() {
        return sortBy.name();
    }

    public String getSortMethod() {
        return sortMethod.name();
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("SortingReq{");
        sb.append("sortBy=").append(sortBy);
        sb.append('}');
        return sb.toString();
    }
}
