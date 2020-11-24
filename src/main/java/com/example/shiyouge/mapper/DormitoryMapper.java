package com.example.shiyouge.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

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
}
