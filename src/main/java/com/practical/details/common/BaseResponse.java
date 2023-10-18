package com.practical.details.common;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public class BaseResponse {

    private boolean success;
    private int status;
    private HttpStatus httpStatus;
    private Object response;

    public BaseResponse(boolean success, int status, HttpStatus httpStatus, Object... response) {
        this.success = success;
        this.status = status;
        this.httpStatus = httpStatus;
        this.response = response;
    }

    public BaseResponse(){}
}

