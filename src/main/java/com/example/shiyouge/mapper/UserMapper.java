package com.example.shiyouge.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

@Mapper
public interface UserMapper {
    /**
     * 得到用户的肥料数量
     * @param userId 用户ID
     * @return 肥料数量
     */
    int getTheFertilizerQuantityOfUser(String userId);

    /**
     * 得到用户的自习时房间号
     * @param userId 用户ID
     * @return 自习时房间号
     */
    int getTheStudyRoomIdOfUser(String userId);

    /**
     * 得到用户的自习总时长
     * @param userId 用户ID
     * @return 自习总时长
     */
    int getTheStudyTimeTotalOfUser(String userId);

    /**
     * 根据用户ID更新用户的学习总时长
     * @param userId 用户ID
     * @param studyTimeIntotal 用户学习总时长
     */
    void uptateTheStudyTimeTotalOfUser(@Param("userId") String userId, @Param("studyTimeIntotal") int studyTimeIntotal);

    /**
     * 得到用户的今日自习时长
     * @param userId 用户ID
     * @return 今日自习时长
     */
    int getTheStudyTimeTodayOfUser(String userId);

    /**
     * 根据用户ID更新用户的今日学习时长
     * @param userId 用户ID
     * @param studyTimeToday 用户今日学习时长
     */
    void uptateTheStudyTimeTodayOfUser(@Param("userId") String userId, @Param("studyTimeToday") int studyTimeToday);

    /**
     * 得到用户的本周自习时长
     * @param userId 用户ID
     * @return 本周自习时长
     */
    int getTheStudyTimeWeekOfUser(String userId);

    /**
     * 根据用户ID更新用户的本周学习时长
     * @param userId 用户ID
     * @param studyTimeWeek 用户本周学习时长
     */
    void uptateTheStudyTimeWeekOfUser(@Param("userId") String userId, @Param("studyTimeWeek") int studyTimeWeek);

    /**
     * 通过用户ID得到昵称
     * @param userId 用户ID
     * @return 用户昵称
     */
    String getTheNickNameByUserId(String userId);

    /**
     * 所有用户今日学习时长清0
     */
    void setAllTheStudyTimeTodayToZero();

    /**
     * 所有用户本周学习时长清0
     */
    void setAllTheStudyTimeWeekToZero();

    /**
     * 今日前10
     * @return 前10的用户ID
     */
    List<String> getTheTodayTop10();

    /**
     * 本周前10
     * @return 前10的用户ID
     */
    List<String> getTheWeekTop10();
}
