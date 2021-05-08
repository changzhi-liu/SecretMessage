package com.SecureMessage.demo.requestmodel;

public class AddFriendsRequest {
    public Long user_id;

    public AddFriendsRequest(Long user_id) {
        this.user_id = user_id;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }
}
