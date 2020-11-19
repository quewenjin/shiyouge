package com.example.shiyouge.service;

import com.example.shiyouge.mapper.StudySystemMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;

@Service
@Transactional
public class StudySystemService {
    @Autowired
    StudySystemMapper studySystemMapper;

    /**
     * 创建学习记录
     * @param userId 用户ID
     * @param studyTime 学习时长
     * @param recordTime 记录时间
     */
    public void createStudyRecord(String userId, int studyTime, Timestamp recordTime){
        studySystemMapper.createTheStudyRecord(userId, studyTime, recordTime);
    }

}
