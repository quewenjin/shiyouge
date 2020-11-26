package com.example.shiyouge.bean;

import java.sql.Timestamp;

public class User {
    private String userId;//用户ID
    private String userSex;//性别
    private String userNickname;//昵称
    private String userPhoto;//头像(base64)
    private String userRealName;//真实姓名
    private String userStudentNumber;//学号
    private int userDormitoryId;//用户的宿舍ID
    private int userWateringTimes;//浇水次数
    private int userFertilizationTimes;//施肥次数
    private int fertilizerQuantity;//肥料数量
    private int waterQuantity;//肥料数量
    private int userStudyRoomId;//用户的自习室ID
    private boolean ifSilent;//是否被禁言
    private Timestamp endSilentTime;//结束禁言时间
    private String lable;//用户标签 --> 默认59个0 --> 00000000000000000000000000000000000000000000000000000000000
    private int userStudyTimeIntotal;//用户自习总时长
    private int userStudyTimeToday;//用户今日自习时长
    private int userStudyTimeWeek;//用户本周自习时长
    private String openId;//open_id
    private int matchingFailedTimes;//匹配失败次数
    private int ifOnMatching;//是否处于在匹配状态

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserSex() {
        return userSex;
    }

    public void setUserSex(String userSex) {
        this.userSex = userSex;
    }

    public String getUserNickname() {
        return userNickname;
    }

    public void setUserNickname(String userNickname) {
        this.userNickname = userNickname;
    }

    public String getUserPhoto() {
        return userPhoto;
    }

    public void setUserPhoto(String userPhoto) {
        this.userPhoto = userPhoto;
    }

    public String getUserRealName() {
        return userRealName;
    }

    public void setUserRealName(String userRealName) {
        this.userRealName = userRealName;
    }

    public String getUserStudentNumber() {
        return userStudentNumber;
    }

    public void setUserStudentNumber(String userStudentNumber) {
        this.userStudentNumber = userStudentNumber;
    }

    public int getUserDormitoryId() {
        return userDormitoryId;
    }

    public void setUserDormitoryId(int userDormitoryId) {
        this.userDormitoryId = userDormitoryId;
    }

    public int getUserWateringTimes() {
        return userWateringTimes;
    }

    public void setUserWateringTimes(int userWateringTimes) {
        this.userWateringTimes = userWateringTimes;
    }

    public int getUserFertilizationTimes() {
        return userFertilizationTimes;
    }

    public void setUserFertilizationTimes(int userFertilizationTimes) {
        this.userFertilizationTimes = userFertilizationTimes;
    }

    public int getFertilizerQuantity() {
        return fertilizerQuantity;
    }

    public void setFertilizerQuantity(int fertilizerQuantity) {
        this.fertilizerQuantity = fertilizerQuantity;
    }

    public int getWaterQuantity() {
        return waterQuantity;
    }

    public void setWaterQuantity(int waterQuantity) {
        this.waterQuantity = waterQuantity;
    }

    public int getUserStudyRoomId() {
        return userStudyRoomId;
    }

    public void setUserStudyRoomId(int userStudyRoomId) {
        this.userStudyRoomId = userStudyRoomId;
    }

    public boolean isIfSilent() {
        return ifSilent;
    }

    public void setIfSilent(boolean ifSilent) {
        this.ifSilent = ifSilent;
    }

    public Timestamp getEndSilentTime() {
        return endSilentTime;
    }

    public void setEndSilentTime(Timestamp endSilentTime) {
        this.endSilentTime = endSilentTime;
    }

    public String getLable() {
        return lable;
    }

    public void setLable(String lable) {
        this.lable = lable;
    }

    public int getUserStudyTimeIntotal() {
        return userStudyTimeIntotal;
    }

    public void setUserStudyTimeIntotal(int userStudyTimeIntotal) {
        this.userStudyTimeIntotal = userStudyTimeIntotal;
    }

    public int getUserStudyTimeToday() {
        return userStudyTimeToday;
    }

    public void setUserStudyTimeToday(int userStudyTimeToday) {
        this.userStudyTimeToday = userStudyTimeToday;
    }

    public int getUserStudyTimeWeek() {
        return userStudyTimeWeek;
    }

    public void setUserStudyTimeWeek(int userStudyTimeWeek) {
        this.userStudyTimeWeek = userStudyTimeWeek;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public int getMatchingFailedTimes() {
        return matchingFailedTimes;
    }

    public void setMatchingFailedTimes(int matchingFailedTimes) {
        this.matchingFailedTimes = matchingFailedTimes;
    }

    public int getIfOnMatching() {
        return ifOnMatching;
    }

    public void setIfOnMatching(int ifOnMatching) {
        this.ifOnMatching = ifOnMatching;
    }
}
