package com.SecureMessage.demo.requestmodel;

public class UserBrief {
    public Long user_id;

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public UserBrief(Long user_id, String user_name) {
        this.user_id = user_id;
        this.user_name = user_name;
    }

    public String user_name;

}
