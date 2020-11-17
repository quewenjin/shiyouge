package com.example.shiyouge.bean;

public class Collect {
    private int collectId;//收藏编号
    private String userIdOfCollector;//收藏人ID
    private int postIdOfCollection;//收藏的帖子的ID

    public int getCollectId() {
        return collectId;
    }

    public void setCollectId(int collectId) {
        this.collectId = collectId;
    }

    public String getUserIdOfCollector() {
        return userIdOfCollector;
    }

    public void setUserIdOfCollector(String userIdOfCollector) {
        this.userIdOfCollector = userIdOfCollector;
    }

    public int getPostIdOfCollection() {
        return postIdOfCollection;
    }

    public void setPostIdOfCollection(int postIdOfCollection) {
        this.postIdOfCollection = postIdOfCollection;
    }
}
