package com.example.shiyouge.bean;

public class StudyRoom {
    private int studyRoomId;//自习室ID-->产品测试阶段数据量小，固定为1
    private int numberOfStudy;//自习人数

    public int getStudyRoomId() {
        return studyRoomId;
    }

    public void setStudyRoomId(int studyRoomId) {
        this.studyRoomId = studyRoomId;
    }

    public int getNumberOfStudy() {
        return numberOfStudy;
    }

    public void setNumberOfStudy(int numberOfStudy) {
        this.numberOfStudy = numberOfStudy;
    }
}
