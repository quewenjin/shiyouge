package com.example.shiyouge.bean;


import java.sql.Timestamp;

public class StudySystem {
    private int recordIdOfStudy;//自习记录ID
    private int userIdOfSelfStudy;//用户ID
    private int studyTimeTotal;//自习时间(分钟)
    private Timestamp dateOfStudy;//记录自习的日期

    public int getRecordIdOfStudy() {
        return recordIdOfStudy;
    }

    public void setRecordIdOfStudy(int recordIdOfStudy) {
        this.recordIdOfStudy = recordIdOfStudy;
    }

    public int getUserIdOfSelfStudy() {
        return userIdOfSelfStudy;
    }

    public void setUserIdOfSelfStudy(int userIdOfSelfStudy) {
        this.userIdOfSelfStudy = userIdOfSelfStudy;
    }

    public int getStudyTimeTotal() {
        return studyTimeTotal;
    }

    public void setStudyTimeTotal(int studyTimeTotal) {
        this.studyTimeTotal = studyTimeTotal;
    }

    public Timestamp getDateOfStudy() {
        return dateOfStudy;
    }

    public void setDateOfStudy(Timestamp dateOfStudy) {
        this.dateOfStudy = dateOfStudy;
    }
}
