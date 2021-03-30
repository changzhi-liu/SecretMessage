package com.SecureMessage.demo.model;

import java.io.Serializable;

public class FriendShipDaoKey implements Serializable {
    private Long senderId;

    private Long recieverId;

    private static final long serialVersionUID = 1L;

    public Long getSenderId() {
        return senderId;
    }

    public void setSenderId(Long senderId) {
        this.senderId = senderId;
    }

    public Long getRecieverId() {
        return recieverId;
    }

    public void setRecieverId(Long recieverId) {
        this.recieverId = recieverId;
    }
}