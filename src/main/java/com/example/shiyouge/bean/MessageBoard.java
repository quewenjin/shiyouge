package com.example.shiyouge.bean;

import java.sql.Timestamp;

public class MessageBoard {
    private int messageId;//留言ID
    private String userIdOfMessage;//留言的用户的ID
    private String messageContent;//留言内容
    private Timestamp messageTime;//留言时间

    public int getMessageId() {
        return messageId;
    }

    public void setMessageId(int messageId) {
        this.messageId = messageId;
    }

    public String getUserIdOfMessage() {
        return userIdOfMessage;
    }

    public void setUserIdOfMessage(String userIdOfMessage) {
        this.userIdOfMessage = userIdOfMessage;
    }

    public String getMessageContent() {
        return messageContent;
    }

    public void setMessageContent(String messageContent) {
        this.messageContent = messageContent;
    }

    public Timestamp getMessageTime() {
        return messageTime;
    }

    public void setMessageTime(Timestamp messageTime) {
        this.messageTime = messageTime;
    }
}
