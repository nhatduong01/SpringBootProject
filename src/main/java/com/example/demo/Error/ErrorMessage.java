package com.example.demo.Error;

import org.springframework.http.HttpStatus;


public class ErrorMessage {
    private HttpStatus status;
    private  String errorMessage;

    public ErrorMessage(HttpStatus status, String errorMessage) {
        this.status = status;
        this.errorMessage = errorMessage;
    }

    public ErrorMessage() {
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
