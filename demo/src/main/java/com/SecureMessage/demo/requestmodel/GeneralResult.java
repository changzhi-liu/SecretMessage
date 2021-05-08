package com.SecureMessage.demo.requestmodel;

import java.io.Serializable;

public class GeneralResult implements Serializable {
    public String message;
    public int responseCode;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(int responseCode) {
        this.responseCode = responseCode;
    }

    public Object getContent() {
        return content;
    }

    public void setContent(Object content) {
        this.content = content;
    }

    public GeneralResult(String message, int responseCode, Object content) {
        this.message = message;
        this.responseCode = responseCode;
        this.content = content;
    }

    public Object content;
}
