package com.example.shiyouge.bean;

import java.sql.Timestamp;

public class Post {
    private int postId;//帖子ID
    private String userIdOfPost;//发帖人ID
    private String postContent;//帖子内容
    private int partitionOfPost;//分区-->倾诉区=1，互助区=2，告白区=3
    private Timestamp publishTime;//发布时间
    private int commentedTimes;//评论次数
    private int praiseTimes;//点赞次数
    private int collectedTimes;//收藏次数
    private int reportTimes;//举报次数
    private boolean ifReported;//是否处于被举报状态
    private String reportedType;//举报类型

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public String getUserIdOfPost() {
        return userIdOfPost;
    }

    public void setUserIdOfPost(String userIdOfPost) {
        this.userIdOfPost = userIdOfPost;
    }

    public String getPostContent() {
        return postContent;
    }

    public void setPostContent(String postContent) {
        this.postContent = postContent;
    }

    public int getPartitionOfPost() {
        return partitionOfPost;
    }

    public void setPartitionOfPost(int partitionOfPost) {
        this.partitionOfPost = partitionOfPost;
    }

    public Timestamp getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(Timestamp publishTime) {
        this.publishTime = publishTime;
    }

    public int getCommentedTimes() {
        return commentedTimes;
    }

    public void setCommentedTimes(int commentedTimes) {
        this.commentedTimes = commentedTimes;
    }

    public int getPraiseTimes() {
        return praiseTimes;
    }

    public void setPraiseTimes(int praiseTimes) {
        this.praiseTimes = praiseTimes;
    }

    public int getCollectedTimes() {
        return collectedTimes;
    }

    public void setCollectedTimes(int collectedTimes) {
        this.collectedTimes = collectedTimes;
    }

    public int getReportTimes() {
        return reportTimes;
    }

    public void setReportTimes(int reportTimes) {
        this.reportTimes = reportTimes;
    }

    public boolean isIfReported() {
        return ifReported;
    }

    public void setIfReported(boolean ifReported) {
        this.ifReported = ifReported;
    }

    public String getReportedType() {
        return reportedType;
    }

    public void setReportedType(String reportedType) {
        this.reportedType = reportedType;
    }
}
