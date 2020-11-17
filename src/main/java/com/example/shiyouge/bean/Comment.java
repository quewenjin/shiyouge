package com.example.shiyouge.bean;


import java.sql.Timestamp;

public class Comment {
    private int commentId;//评论ID
    private int postIdOfComment;//对应帖子ID
    private String userIdOfComment;//评论的用户的ID
    private String commentContent;//评论内容
    private Timestamp commentTime;//评论时间

    public int getCommentId() {
        return commentId;
    }

    public void setCommentId(int commentId) {
        this.commentId = commentId;
    }

    public int getPostIdOfComment() {
        return postIdOfComment;
    }

    public void setPostIdOfComment(int postIdOfComment) {
        this.postIdOfComment = postIdOfComment;
    }

    public String getUserIdOfComment() {
        return userIdOfComment;
    }

    public void setUserIdOfComment(String userIdOfComment) {
        this.userIdOfComment = userIdOfComment;
    }

    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
    }

    public Timestamp getCommentTime() {
        return commentTime;
    }

    public void setCommentTime(Timestamp commentTime) {
        this.commentTime = commentTime;
    }
}
