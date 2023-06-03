package com.example.ap.error;

import java.io.Serializable;

public class ErrorResponse implements Serializable {
    private String key;
    private String message;
    private String details;

    public ErrorResponse(String key, String message) {
        this.key = key;
        this.message = message;
    }

    public ErrorResponse(String key, String message, String details) {
        this.key = key;
        this.message = message;
        this.details = details;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}
