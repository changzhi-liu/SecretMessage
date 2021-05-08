package com.SecureMessage.demo.requestmodel;

public class AcceptFriendsRequest {
    Long friendPkId;
    boolean accpted;
    String myPk;

    public Long getFriendPkId() {
        return friendPkId;
    }

    public void setFriendPkId(Long friendPkId) {
        this.friendPkId = friendPkId;
    }

    public boolean isAccpted() {
        return accpted;
    }

    public void setAccpted(boolean accpted) {
        this.accpted = accpted;
    }

    public String getMyPk() {
        return myPk;
    }

    public void setMyPk(String myPk) {
        this.myPk = myPk;
    }

    public AcceptFriendsRequest(Long friendPkId, boolean accpted, String myPk) {
        this.friendPkId = friendPkId;
        this.accpted = accpted;
        this.myPk = myPk;
    }
}
