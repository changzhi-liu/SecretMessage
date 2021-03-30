package com.SecureMessage.demo.model;

import java.io.Serializable;

public class FriendShipDao extends FriendShipDaoKey implements Serializable {
    private Integer msgStartingIndex;

    private Integer msgCurrentIndex;

    private static final long serialVersionUID = 1L;

    public Integer getMsgStartingIndex() {
        return msgStartingIndex;
    }

    public void setMsgStartingIndex(Integer msgStartingIndex) {
        this.msgStartingIndex = msgStartingIndex;
    }

    public Integer getMsgCurrentIndex() {
        return msgCurrentIndex;
    }

    public void setMsgCurrentIndex(Integer msgCurrentIndex) {
        this.msgCurrentIndex = msgCurrentIndex;
    }
}