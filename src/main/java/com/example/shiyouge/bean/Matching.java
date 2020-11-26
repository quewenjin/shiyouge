package com.example.shiyouge.bean;

public class Matching {
    private int matchingId;//匹配ID
    private String userIdOnMatching;//在匹配中的人的ID
    private String labelOfUser;//用户的标签
    private int failedTimes;//失败次数

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

    public int getMatchingId() {
        return matchingId;
    }

    public void setMatchingId(int matchingId) {
        this.matchingId = matchingId;
    }

    public int getFailedTimes() {
        return failedTimes;
    }

    public void setFailedTimes(int failedTimes) {
        this.failedTimes = failedTimes;
    }
}
