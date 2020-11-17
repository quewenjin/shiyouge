package com.example.shiyouge.bean;


import java.sql.Timestamp;

public class BlackBoard {
    private int dormitoryIdOfBoard;//对应宿舍ID
    private String recordType;//类型(浇水还是施肥)
    private String userIdOfRecord;//执行的用户的ID
    private Timestamp recordTime ;//记录时间

    public int getDormitoryIdOfBoard() {
        return dormitoryIdOfBoard;
    }

    public void setDormitoryIdOfBoard(int dormitoryIdOfBoard) {
        this.dormitoryIdOfBoard = dormitoryIdOfBoard;
    }

    public String getRecordType() {
        return recordType;
    }

    public void setRecordType(String recordType) {
        this.recordType = recordType;
    }

    public String getUserIdOfRecord() {
        return userIdOfRecord;
    }

    public void setUserIdOfRecord(String userIdOfRecord) {
        this.userIdOfRecord = userIdOfRecord;
    }

    public Timestamp getRecordTime() {
        return recordTime;
    }

    public void setRecordTime(Timestamp recordTime) {
        this.recordTime = recordTime;
    }
}
