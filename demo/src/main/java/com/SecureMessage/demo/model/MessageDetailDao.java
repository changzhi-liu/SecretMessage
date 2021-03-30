package com.SecureMessage.demo.model;

import java.io.Serializable;
import java.util.Date;

public class MessageDetailDao implements Serializable {
    private Long msgIndex;

    private String sender;

    private String reciever;

    private Long senderId;

    private Long recieverId;

    private String content;

    private Integer validation;

    private Date sendTime;

    private static final long serialVersionUID = 1L;

    public Long getMsgIndex() {
        return msgIndex;
    }

    public void setMsgIndex(Long msgIndex) {
        this.msgIndex = msgIndex;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender == null ? null : sender.trim();
    }

    public String getReciever() {
        return reciever;
    }

    public void setReciever(String reciever) {
        this.reciever = reciever == null ? null : reciever.trim();
    }

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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Integer getValidation() {
        return validation;
    }

    public void setValidation(Integer validation) {
        this.validation = validation;
    }

    public Date getSendTime() {
        return sendTime;
    }

    public void setSendTime(Date sendTime) {
        this.sendTime = sendTime;
    }
}