package com.library.management.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SortingReq {

    private enum Order{ASCENDING,ascending, DESCENDING, descending};

    private enum SortBy{NAME, PRICE, name, price}

    private SortBy sortBy;

    private Order sortMethod;

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("SortingReq{");
        sb.append("sortBy=").append(sortBy);
        sb.append('}');
        return sb.toString();
    }
}
