package com.SecureMessage.demo.requestmodel;

public class WriteRequestClient {
    Long receiver_id;
    String message;

    public Long getReceiver_id() {
        return receiver_id;
    }

    public void setReceiver_id(Long receiver_id) {
        this.receiver_id = receiver_id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public WriteRequestClient(Long receiver_id, String message) {
        this.receiver_id = receiver_id;
        this.message = message;
    }
}
