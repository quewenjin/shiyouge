package com.example.shiyouge.mapper;

import com.example.shiyouge.bean.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

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
     * 设置用户的肥料数量
     * @param userId 用户ID
     */
    void setTheFertilizerQuantityOfUser(@Param("userId") String userId, @Param("quantity") int quantity);

    /**
     * 得到用户的水的数量
     * @param userId 用户ID
     * @return 水的数量
     */
    int getTheWaterQuantityOfUser(String userId);

    /**
     * 设置用户的水的数量
     * @param userId 用户ID
     */
    void setTheWaterQuantityOfUser(@Param("userId") String userId, @Param("quantity") int quantity);

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

    /**
     * 得到用户的肥料次数
     * @param userId 用户ID
     * @return 肥料次数
     */
    int getTheFertilizationTimes(String userId);

    /**
     * 设置用户的肥料次数
     * @param userId 用户ID
     */
    void setTheFertilizationTimes(@Param("userId") String userId, @Param("times") int times);

    /**
     * 得到用户的浇水次数
     * @param userId 用户ID
     * @return 浇水次数
     */
    int getTheWateringTimes(String userId);

    /**
     * 设置用户的浇水次数
     * @param userId 用户ID
     */
    void setTheWateringTimes(@Param("userId") String userId, @Param("times") int times);
    /**
     * 获得所有用户ID
     * @return 所有用户ID
     */
    List<String> getAllUserId();

    /**
     * 获得所有用户真实姓名
     * @param userId 用户ID
     * @return 所有用户真实姓名
     */
    String getRealNameByUserId(String userId);

    /**
     * 获得所有用户学号
     * @param userId 用户ID
     * @return 所有用户学号
     */
    String getStudentNumberByUserId(String userId);

    /**
     * 获得用户禁言是否被禁言
     * @param userId 用户ID
     * @return 用户是否被禁言
     */
    int getIfSilentByUserId(String userId);

    /**
     * 修改真实姓名和学号
     * @param  userRealName 用户真实姓名
     * @param  userStudentNumber 学号
     * @param userId ID
     * @return 状态：succeed
     */
    int updateUserInfo(@Param("userRealName") String userRealName, @Param("userStudentNumber") int userStudentNumber,
                       @Param("userId") String userId);

    /**
     * 获得被举报帖子的数量
     * @return 被举报帖子的数量
     */
    int getNumberOfReported();

    /**
     * 退出宿舍
     * @param userId 用户ID
     */
    void quitDormitoryOfUser(String userId);

    /**
     * 加入宿舍
     * @param userId 用户ID
     */
    void joinDormitoryOfUser(@Param("userId") String userId, @Param("dormitoryId") int dormitoryId);

    /**
     * 获得用户兴趣标签
     * @param userId 用户ID
     * @return 兴趣标签
     */
    String getTagsByUserId(String userId);

    /**
     * 获得用户宿舍ID
     * @param userId 用户ID
     * @return 宿舍ID
     */
    int getDormitoryIDByUserId(String userId);

    /**
     * 获得用户性别
     * @param userId 用户ID
     * @return 性别
     */
    String getSexByUserId(String userId);

    /**
     * 获得用户头像
     * @param userId 用户ID
     * @return 头像（base64）
     */
    String getPhotoByUserId(String userId);

    /**
     * 设置用户昵称
     * @param userId 用户ID
     * @param userNickName 用户昵称
     */
    void setUserNickName(String userId, String userNickName);

    /**
     * 设置用户兴趣标签
     * @param userId 用户ID
     * @param usersTags 用户兴趣标签
     */
    void setUserTag(String userId, String usersTags);

    /**
     * 得到用户结束禁言时间
     * @param userId 用户ID
     * @return 结束禁言时间
     */
    Timestamp getTheEndSilentTime(String userId);

    /**
     * 设置用户结束禁言时间
     * @param userId 用户ID
     * @param endSilentTime 结束禁言时间
     */
    void setTheEndSilentTime(@Param("userId") String userId, @Param("endSilentTime") Timestamp endSilentTime);

    /**
     * 通过ID得到用户
     * @param userId ID
     * @return user
     */
    User getUserByUserId(String userId);

    /**
     * 用open_id创建用户
     * @param userId 用户id
     * @param openId open_id
     * @return 是否成功
     */
    Boolean createUserByOpenId(@Param("userId") String userId, @Param("openId") String openId);

    /**
     * 设置性别
     * @param userId ID
     * @param userSex 性别
     */
    void setTheUserSex(@Param("userId") String userId, @Param("userSex") String userSex);

    /**
     * 设置真实姓名
     * @param userId ID
     * @param userRealName 真实姓名
     */
    void setTheUserRealName(@Param("userId") String userId, @Param("userRealName") String userRealName);

    /**
     * 设置学号
     * @param userId ID
     * @param userStudentNumber 学号
     */
    void setTheUserStudentNumber(@Param("userId") String userId, @Param("userStudentNumber") String userStudentNumber);

    /**
     * 设置用户禁言是否被禁言
     * @param userId 用户ID
     * @param ifSilent 是否禁言
     */
    void setIfSilentByUserId(@Param("userId") String userId, @Param("ifSilent") int ifSilent);

    /**
     * 设置用户头像
     * @param userId ID
     * @param photo 头像
     */
    void setThePhotoByUserId(@Param("userId") String userId, @Param("photo") String photo);

    /**
     * 用openId得到用户
     * @param openId openId
     * @return
     */
    User getUserByOpenId(String openId);

    /**
     * 得到是否在匹配中
     * @param userId ID
     * @return 是否匹配中
     */
    int getIfOnMatchingByUserId(String userId);

    /**
     * 设置是否匹配中
     * @param userId ID
     * @param ifOnMatching 状态
     */
    void setIfOnMatchingByUserId(@Param("userId") String userId, @Param("ifOnMatching") int ifOnMatching);

    /**
     * 得到匹配失败次数
     * @param userId ID
     * @return 是否匹配中
     */
    int getMatchingFailedTimesByUserId(String userId);

    /**
     * 设置匹配失败次数
     * @param userId ID
     * @param failedTimes 失败次数
     */
    void setMatchingFailedTimesByUserId(@Param("userId") String userId, @Param("failedTimes") int failedTimes);

    /**
     * 处于某匹配状态的用户
     * @return List
     */
    List<User> getTheUsersByMatchingStatus(int ifOnMatching);
}
