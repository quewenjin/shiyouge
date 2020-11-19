package com.example.shiyouge.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.sql.Timestamp;

@Mapper
public interface StudySystemMapper {

    /**
     * 创建学习记录
     * @param userId 用户ID
     * @param studyTime 学习时长
     * @param recordTime 记录时间
     */
    void createTheStudyRecord(@Param("userId") String userId, @Param("studyTime") int studyTime, @Param("recordTime") Timestamp recordTime);

}
