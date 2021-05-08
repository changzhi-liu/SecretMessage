package com.SecureMessage.demo.model;

import java.io.Serializable;

public class friendspkDao implements Serializable {
    private Long friendspkId;

    private Long senderId;

    private Long receiverId;

    private String keySender;

    private String keyReceiver;

    private Boolean receiverDecided;

    private Boolean senderRetrieved;

    private static final long serialVersionUID = 1L;

    public Long getFriendspkId() {
        return friendspkId;
    }

    public void setFriendspkId(Long friendspkId) {
        this.friendspkId = friendspkId;
    }

    public Long getSenderId() {
        return senderId;
    }

    public void setSenderId(Long senderId) {
        this.senderId = senderId;
    }

    public Long getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(Long receiverId) {
        this.receiverId = receiverId;
    }

    public String getKeySender() {
        return keySender;
    }

    public void setKeySender(String keySender) {
        this.keySender = keySender == null ? null : keySender.trim();
    }

    public String getKeyReceiver() {
        return keyReceiver;
    }

    public void setKeyReceiver(String keyReceiver) {
        this.keyReceiver = keyReceiver == null ? null : keyReceiver.trim();
    }

    public Boolean getReceiverDecided() {
        return receiverDecided;
    }

    public void setReceiverDecided(Boolean receiverDecided) {
        this.receiverDecided = receiverDecided;
    }

    public Boolean getSenderRetrieved() {
        return senderRetrieved;
    }

    public void setSenderRetrieved(Boolean senderRetrieved) {
        this.senderRetrieved = senderRetrieved;
    }
}