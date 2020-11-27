package com.example.shiyouge.service;

import com.example.shiyouge.bean.User;
import com.example.shiyouge.mapper.UserMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.List;

@Service
@Transactional
public class UserService {
    @Autowired
    UserMapper userMapper;

    /**
     * 退出宿舍
     * @param userId 用户ID
     */
    public void quitDormitoryOfUser(String userId){
        userMapper.quitDormitoryOfUser(userId);
    }

    /**
     * 加入宿舍
     * @param userId 用户ID
     */
    public void joinDormitoryOfUser(String userId, int dormitoryId){
        userMapper.joinDormitoryOfUser(userId, dormitoryId);
    }

    /**
     * 得到用户的肥料数量
     * @param userId 用户ID
     * @return 肥料数量
     */
    public int getFertilizerQuantityOfUser(String userId){
        return userMapper.getTheFertilizerQuantityOfUser(userId);
    }

    /**
     * 设置用户的肥料数量
     * @param userId 用户ID
     */
    public void setFertilizerQuantityOfUser(String userId, int quantity){
        userMapper.setTheFertilizerQuantityOfUser(userId, quantity);
    }

    /**
     * 得到用户的水的数量
     * @param userId 用户ID
     * @return 水的数量
     */
    public int getWaterQuantityOfUser(String userId){
        return userMapper.getTheFertilizerQuantityOfUser(userId);
    }

    /**
     * 设置用户的水的数量
     * @param userId 用户ID
     */
    public  void setWaterQuantityOfUser(String userId, int quantity){
        userMapper.setTheFertilizerQuantityOfUser(userId, quantity);
    }

    /**
     * 得到用户的自习总时长
     * @param userId 用户ID
     * @return 自习总时长
     */
    public int getStudyTimeTotalOfUser(String userId){
        return userMapper.getTheStudyTimeTotalOfUser(userId);
    }

    /**
     * 得到用户的今日自习时长
     * @param userId 用户ID
     * @return 今日自习时长
     */
    public int getStudyTimeTodayOfUser(String userId){
        return userMapper.getTheStudyTimeTodayOfUser(userId);
    }

    /**
     * 得到用户的本周自习时长
     * @param userId 用户ID
     * @return 本周自习时长
     */
    public int getStudyTimeWeekOfUser(String userId){
        return userMapper.getTheStudyTimeWeekOfUser(userId);
    }

    /**
     * 得到用户的自习时房间号
     * @param userId 用户ID
     * @return 自习时房间号
     */
    public int getStudyRoomIdOfUser(String userId){
        return userMapper.getTheStudyRoomIdOfUser(userId);
    }

    /**
     * 根据用户ID更新用户的学习总时长
     * @param userId 用户ID
     * @param studyTimeIntotal 用户学习总时长
     */
    public void updateStudyTimeTotalOfUser(String userId, int studyTimeIntotal){
        userMapper.uptateTheStudyTimeTotalOfUser(userId, studyTimeIntotal);
    }

    /**
     * 根据用户ID更新用户的今日学习时长
     * @param userId 用户ID
     * @param studyTimeToday 用户今日学习时长
     */
    public void updateStudyTimeTodayOfUser(String userId, int studyTimeToday){
        userMapper.uptateTheStudyTimeTodayOfUser(userId, studyTimeToday);
    }

    /**
     * 根据用户ID更新用户的今日学习时长
     * @param userId 用户ID
     * @param studyTimeWeek 用户今日学习时长
     */
    public void updateStudyTimeWeekOfUser(String userId, int studyTimeWeek){
        userMapper.uptateTheStudyTimeWeekOfUser(userId, studyTimeWeek);
    }

    /**
     * 所有用户今日学习时长清0
     */
    public void setAllStudyTimeTodayToZero(){
        userMapper.setAllTheStudyTimeTodayToZero();
    }

    /**
     * 所有用户本周学习时长清0
     */
    public void setAllStudyTimeWeekToZero(){
        userMapper.setAllTheStudyTimeWeekToZero();
    }

    /**
     * 今日前10
     * @return 前10的用户ID
     */
    public List<String> getTodayTop10(){
        return userMapper.getTheTodayTop10();
    }

    /**
     * 本周前10
     * @return 前10的用户ID
     */
    public List<String> getWeekTop10(){ return userMapper.getTheWeekTop10(); }

    /**
     * 得到用户的肥料次数
     * @param userId 用户ID
     * @return 肥料次数
     */
    public int getTheFertilizationTimes(String userId){
        return userMapper.getTheFertilizationTimes(userId);
    }

    /**
     * 设置用户的肥料次数
     * @param userId 用户ID
     */
    public void setTheFertilizationTimes(String userId, int times){
        userMapper.setTheFertilizationTimes(userId, times);
    }

    /**
     * 得到用户的浇水次数
     * @param userId 用户ID
     * @return 浇水次数
     */
    public int getTheWateringTimes(String userId){
        return userMapper.getTheWateringTimes(userId);
    }

    /**
     * 设置用户的浇水次数
     * @param userId 用户ID
     */
    public void setTheWateringTimes(String userId, int times){
        userMapper.setTheWateringTimes(userId, times);
    }

    /**
     * 获得所有用户ID
     * @return 所有用户ID
     */
     public List<String> getAllUserId() { return userMapper.getAllUserId();}

    /**
     * 通过用户ID得到昵称
     * @param userId 用户ID
     * @return 用户昵称
     */
    public String getNickNameByUserId(String userId){
        return userMapper.getTheNickNameByUserId(userId);
    }

    /**
     * 获得用户真实姓名
     * @param userId 用户ID
     * @return 用户真实姓名
     */
    public String getRealNameByUserId(String userId) { return userMapper.getRealNameByUserId(userId); }

    /**
     * 获得用户学号
     * @param userId 用户ID
     * @return 用户学号
     */
    public String getStudentNumberByUserId(String userId) {
        return userMapper.getStudentNumberByUserId(userId);
    }

    /**
     * 获得用户兴趣标签
     * @param userId 用户ID
     * @return 兴趣标签
     */
    public String getTagsByUserId(String userId) {
        return userMapper.getTagsByUserId(userId);
    }

    /**
     * 获得用户所在宿舍ID
     * @param userId 用户ID
     * @return 宿舍ID
     */
    public int getDormitoryIDByUserId(String userId) {
        return userMapper.getDormitoryIDByUserId(userId);
    }

    /**
     * 获得用户性别
     * @param userId 用户ID
     * @return 用户性别
     */
    public String getSexByUserId(String userId) {
        return userMapper.getSexByUserId(userId);
    }

    /**
     * 获得用户头像
     * @param userId 用户ID
     * @return 用户头像
     */
    public String getPhotoByUserId(String userId) {
        return userMapper.getPhotoByUserId(userId);
    }

    /**
     * 获得用户禁言是否被禁言
     * @param userId 用户ID
     * @return 用户是否被禁言
     */
    public int getIfSilentByUserId(String userId) {
        return userMapper.getIfSilentByUserId(userId);
    }

    /**
     * 修改真实姓名和学号
     * @param  userRealName 用户真实姓名
     * @param  userStudentNumber 学号
     * @param userId ID
     * @return 状态：succeed
     */
    public int updateUserInfo(String userRealName, int userStudentNumber, String userId){
        return userMapper.updateUserInfo(userRealName, userStudentNumber, userId);
    }

    /**
     * 修改昵称
     * @param userId 用户ID
     * @param  userNickName 用户昵称
     */
    public void setUserNickName(String userId, String userNickName){
        userMapper.setUserNickName(userId, userNickName);
    }

    /**
     * 修改兴趣标签
     * @param userId 用户ID
     * @param  usersTags 用户兴趣标签
     */
    public void setUserTag(String userId, String usersTags){
        userMapper.setUserTag(userId, usersTags);
    }

    /**
     * 获得被举报帖子的数量
     * @return 被举报帖子的数量
     */
    public int getNumberOfReported() { return userMapper.getNumberOfReported();}

    /**
     * 得到用户结束禁言时间
     * @param userId 用户ID
     * @return 结束禁言时间
     */
    public Timestamp getTheEndSilentTime(String userId){
        return userMapper.getTheEndSilentTime(userId);
    }

    /**
     * 设置用户结束禁言时间
     * @param userId 用户ID
     * @param endSilentTime 结束禁言时间
     */
    public void setTheEndSilentTime(String userId, Timestamp endSilentTime){
        userMapper.setTheEndSilentTime(userId, endSilentTime);
    }

    /**
     * 通过ID得到用户
     * @param userId ID
     * @return user
     */
    public User getUserByUserId(String userId){
        return userMapper.getUserByUserId(userId);
    }

    /**
     * 用open_id创建用户
     * @param userId 用户id
     * @param openId open_id
     * @return 是否成功
     */
    public Boolean createUserByOpenId(String userId, String openId){
        return userMapper.createUserByOpenId(userId, openId);
    }

    /**
     * 设置性别
     * @param userId ID
     * @param userSex 性别
     */
    public void setTheUserSex(String userId, String userSex){
        userMapper.setTheUserSex(userId, userSex);
    }

    /**
     * 设置真实姓名
     * @param userId ID
     * @param userRealName 真实姓名
     */
    public void setTheUserRealName(String userId, String userRealName){
        userMapper.setTheUserRealName(userId, userRealName);
    }

    /**
     * 设置学号
     * @param userId ID
     * @param userStudentNumber 学号
     */
    public void setTheUserStudentNumber(String userId, String userStudentNumber){
        userMapper.setTheUserStudentNumber(userId, userStudentNumber);
    }

    /**
     * 设置用户禁言是否被禁言
     * @param userId 用户ID
     * @param ifSilent 是否禁言
     */
    public void setIfSilentByUserId(String userId, int ifSilent){
        userMapper.setIfSilentByUserId(userId, ifSilent);
    }

    /**
     * 设置用户头像
     * @param userId ID
     * @param photo 头像
     */
    public void setPhotoByUserId(String userId, String photo){
        userMapper.setThePhotoByUserId(userId, photo);
    }

    /**
     * 用openId得到用户
     * @param openId openId
     * @return
     */
    public User getUserByOpenId(String openId){
        return userMapper.getUserByOpenId(openId);
    }

    /**
     * 得到是否在匹配中
     * @param userId ID
     * @return 是否匹配中
     */
    public int getIfOnMatchingByUserId(String userId){
        return userMapper.getIfOnMatchingByUserId(userId);
    }

    /**
     * 设置是否匹配中
     * @param userId ID
     * @param ifOnMatching 状态
     */
    public void setIfOnMatchingByUserId(String userId, int ifOnMatching){
        userMapper.setIfOnMatchingByUserId(userId, ifOnMatching);
    }

    /**
     * 得到匹配失败次数
     * @param userId ID
     * @return 是否匹配中
     */
    public int getMatchingFailedTimesByUserId(String userId){
        return userMapper.getMatchingFailedTimesByUserId(userId);
    }

    /**
     * 设置匹配失败次数
     * @param userId ID
     * @param failedTimes 失败次数
     */
    public void setMatchingFailedTimesByUserId(String userId, int failedTimes){
        userMapper.setMatchingFailedTimesByUserId(userId, failedTimes);
    }

    /**
     * 处于某匹配状态的用户
     * @return List
     */
    public List<User> getUsersByMatchingStatus(int ifOnMatching){
        return userMapper.getTheUsersByMatchingStatus(ifOnMatching);
    }

    /**
     * 用 openId 得到用户ID
     * @param openId openid
     * @return 用户ID
     */
    public String getUserIdByOpenId(String openId){
        return userMapper.getUserIdByOpenId(openId);
    }

    /**
     * 处于某匹配状态的用户
     * @return List
     */
    public List<String> getUserIdsByMatchingStatus(int ifOnMatching){
        return userMapper.getTheUserIdsByMatchingStatus(ifOnMatching);
    }
}
