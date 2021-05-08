package com.SecureMessage.demo.requestmodel;

import java.io.Serializable;

public class UserBriefResponse implements Serializable {
    public String userName;
    public Long userId;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public UserBriefResponse( Long userId,String userName) {
        this.userName = userName;
        this.userId = userId;
    }
}
