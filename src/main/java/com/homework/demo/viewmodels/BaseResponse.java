package com.homework.demo.viewmodels;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

public class BaseResponse<T> {
    private final String status;

    @JsonInclude(Include.NON_NULL)
    private T data;

    @JsonInclude(Include.NON_NULL)
    private String error;

    @JsonIgnore
    public final static String SUCCESS = "success";
    @JsonIgnore
    public final static String ERROR = "error";

    public BaseResponse(T data, String status) {
        this.status = status;
        this.data = data;
    }

    public BaseResponse(String error, String status) {
        this.status = status;
        this.error = error;
    }

    public String getStatus() {
        return status;
    }

    public T getData() {
        return data;
    }

    public String getError() {
        return error;
    }
}
