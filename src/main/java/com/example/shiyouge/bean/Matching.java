package com.example.shiyouge.bean;

public class Matching {
    private String userIdOnMatching;//在匹配中的人的ID
    private String labelOfUser;//用户的标签

    public String getUserIdOnMatching() {
        return userIdOnMatching;
    }

    public void setUserIdOnMatching(String userIdOnMatching) {
        this.userIdOnMatching = userIdOnMatching;
    }

    public String getLabelOfUser() {
        return labelOfUser;
    }

    public void setLabelOfUser(String labelOfUser) {
        this.labelOfUser = labelOfUser;
    }
}
