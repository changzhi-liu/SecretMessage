package com.SecureMessage.demo.requestmodel;

public class WriteRequest {
    Long index;
    String message;

    public Long getIndex() {
        return index;
    }

    public void setIndex(Long index) {
        this.index = index;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public WriteRequest(Long index, String message) {
        this.index = index;
        this.message = message;
    }
}
