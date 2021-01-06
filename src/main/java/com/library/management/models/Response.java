package com.library.management.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Response implements Serializable {
    private static final long serialVersionUID = -8890297829625966054L;

    private String status;

    private String message;

    public Response(String status, String message){
        this.status = status;
        this.message = message;
    }
}
