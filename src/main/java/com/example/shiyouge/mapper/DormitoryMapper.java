package com.example.shiyouge.mapper;

import com.example.shiyouge.bean.Dormitory;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface DormitoryMapper {
    /**
     * 每日土壤湿度清 0（每日限制浇水10次）
     */
    void setTheAllSoilMoistureToZero();

    /**
     * 每日土壤肥度清 0
     */
    void setTheAllSoilFertilityToZero();

    /**
     * 得到对应宿舍花的土壤湿度
     * @param dormitoryId 宿舍ID
     * @return 湿度
     */
    int getTheSoilMoistureOfDormitory(int dormitoryId);

    /**
     * 得到对应宿舍花的土壤肥度
     * @param dormitoryId 宿舍ID
     * @return 肥度
     */
    int getTheSoilFertilityOfDormitory(int dormitoryId);

    /**
     * 得到对应宿舍花的成长值
     * @param dormitoryId 宿舍ID
     * @return 成长值
     */
    int getTheFlowerGrowthValueOfDormitory(int dormitoryId);

    /**
     * 修改土壤湿度
     * @param dormitoryId 宿舍ID
     * @param moisture 湿度
     */
    void setTheSoilMoistureOfDormitory(@Param("dormitoryId") int dormitoryId, @Param("moistrue") int moisture);

    /**
     * 修改土壤湿度
     * @param dormitoryId 宿舍ID
     * @param fertility 湿度
     */
    void setTheSoilFertilityOfDormitory(@Param("dormitoryId") int dormitoryId, @Param("fertility") int fertility);

    /**
     * 修改花的成长值
     * @param dormitoryId 宿舍ID
     * @param flowerGrowthValue 成长值
     */
    void setTheFlowerGrowthValueOfDormitory(@Param("dormitoryId") int dormitoryId, @Param("flowerGrowthValue") int flowerGrowthValue);

    /**
     * 得到总浇水次数
     * @param dormitoryId 宿舍ID
     * @return 总浇水次数
     */
    int getTheFlowerWateringTimes(int dormitoryId);

    /**
     * 设置总浇水次数
     * @param dormitoryId 宿舍ID
     * @param times 次数
     */
    void setTheFlowerWateringTimes(@Param("dormitoryId") int dormitoryId, @Param("times") int times);

    /**
     * 得到总施肥次数
     * @param dormitoryId 宿舍ID
     * @return 总施肥次数
     */
    int getTheFlowerFertilizationTimes(int dormitoryId);

    /**
     * 设置总施肥次数
     * @param dormitoryId 宿舍ID
     * @param times 次数
     */
    void setTheFlowerFertilizationTimes(@Param("dormitoryId") int dormitoryId, @Param("times") int times);

    /**
     * 设置宿舍人数
     * @param dormitoryId 宿舍ID
     */
    void setTheDormitoryMate(@Param("dormitoryId") int dormitoryId, @Param("theNum") int theNum);

    /**
     * 得到宿舍人数
     * @param dormitoryId 宿舍ID
     * @return 人数
     */
    int getTheDormitoryMate(int dormitoryId);

    /**
     * 创建宿舍
     * @param dormitoryId 宿舍ID
     * @param joinPassword 加入密码
     */
    void createDormitory(@Param("dormitoryId") int dormitoryId, @Param("joinPassword") String joinPassword);

    /**
     * 得到最大的宿舍ID
     * @return 最大ID
     */
    int getMaxDormitoryId();

    /**
     * 设置加入密码
     * @param dormitoryId 宿舍ID
     * @param joinPassword 加入密码
     */
    void setTheJoinPassword(@Param("dormitoryId") int dormitoryId, @Param("joinPassword") String joinPassword);

    /**
     * 得到加入密码
     * @param dormitoryId 宿舍ID
     * @return 密码
     */
    String getTheJoinPassword(int dormitoryId);

    /**
     * 得到全部的宿舍
     * @return 宿舍List
     */
    List<Dormitory> getAllDormitorys();

    /**
     * 得到宿舍
     * @param dormitoryId ID
     * @return 宿舍
     */
    Dormitory getDormitoryById(int dormitoryId);
}
