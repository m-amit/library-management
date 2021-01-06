package com.library.management.exception;

import lombok.Getter;

@Getter
public class LMSException extends Exception {
    private static final long serialVersionUID = -1885615893367079880L;

    private String status;

    public LMSException(String status){
        super(status);
        this.status = status;
    }
}
