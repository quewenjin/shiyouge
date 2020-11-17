package com.example.shiyouge.bean;

import java.sql.Timestamp;

public class ChatSystem {
    private int chatId;//聊天记录ID
    private int dormitoryIdOfChat;//对应宿舍ID
    private String userIdOfSender;//发送人的ID
    private String userIdOfReceiver;//接收人的ID
    private Timestamp sendTime;//发送时间
    private String chatContent;//聊天内容

    public int getChatId() {
        return chatId;
    }

    public void setChatId(int chatId) {
        this.chatId = chatId;
    }

    public int getDormitoryIdOfChat() {
        return dormitoryIdOfChat;
    }

    public void setDormitoryIdOfChat(int dormitoryIdOfChat) {
        this.dormitoryIdOfChat = dormitoryIdOfChat;
    }

    public String getUserIdOfSender() {
        return userIdOfSender;
    }

    public void setUserIdOfSender(String userIdOfSender) {
        this.userIdOfSender = userIdOfSender;
    }

    public String getUserIdOfReceiver() {
        return userIdOfReceiver;
    }

    public void setUserIdOfReceiver(String userIdOfReceiver) {
        this.userIdOfReceiver = userIdOfReceiver;
    }

    public Timestamp getSendTime() {
        return sendTime;
    }

    public void setSendTime(Timestamp sendTime) {
        this.sendTime = sendTime;
    }

    public String getChatContent() {
        return chatContent;
    }

    public void setChatContent(String chatContent) {
        this.chatContent = chatContent;
    }
}
