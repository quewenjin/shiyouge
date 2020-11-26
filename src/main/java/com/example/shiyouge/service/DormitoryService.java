package com.example.shiyouge.service;

import com.example.shiyouge.bean.Dormitory;
import com.example.shiyouge.mapper.DormitoryMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class DormitoryService {
    @Autowired
    DormitoryMapper dormitoryMapper;

    /**
     * 创建宿舍
     */
    public void created(int DormitoryID, String joinPassword){
        dormitoryMapper.createDormitory(DormitoryID, joinPassword);
    }

    /**
     * 设置宿舍人数
     * @param dormitoryId 宿舍ID
     */
    public void setTheDormitoryMate(int dormitoryId, int theNum){
        dormitoryMapper.setTheDormitoryMate(dormitoryId, theNum);
    }

    /**
     * 得到宿舍人数
     * @param dormitoryId 宿舍ID
     * @return 人数
     */
    public int getTheDormitoryMate(int dormitoryId){
        return dormitoryMapper.getTheDormitoryMate(dormitoryId);
    }

    /**
     * 随机宿舍ID
     * @return 随机ID
     */
    public int randomID(){
        int max=100,min=1;
        int ran = (int) (Math.random()*(max-min)+min);
        return ran;
    }

    /**
     * 每日土壤湿度清 0（每日限制浇水10次）
     */
    public void setAllSoilMoistureToZero(){
        dormitoryMapper.setTheAllSoilMoistureToZero();
    }

    /**
     * 每日土壤肥度清 0
     */
    public void setAllSoilFertilityToZero(){
        dormitoryMapper.setTheAllSoilFertilityToZero();
    }

    /**
     * 得到对应宿舍花的土壤湿度
     * @param dormitoryId 宿舍ID
     * @return 湿度
     */
    public int getTheSoilMoistureOfDormitory(int dormitoryId){
        return dormitoryMapper.getTheSoilMoistureOfDormitory(dormitoryId);
    }

    /**
     * 得到对应宿舍花的土壤肥度
     * @param dormitoryId 宿舍ID
     * @return 肥度
     */
    public int getTheSoilFertilityOfDormitory(int dormitoryId){
        return dormitoryMapper.getTheSoilFertilityOfDormitory(dormitoryId);
    }

    /**
     * 修改土壤湿度
     * @param dormitoryId 宿舍ID
     * @param moisture 湿度
     */
    public void setSoilMoistureOfDormitory(int dormitoryId, int moisture){
        dormitoryMapper.setTheSoilMoistureOfDormitory(dormitoryId, moisture);
    }

    /**
     * 修改土壤湿度
     * @param dormitoryId 宿舍ID
     * @param fertility 湿度
     */
    public void setSoilFertilityOfDormitory(int dormitoryId, int fertility){
        dormitoryMapper.setTheSoilFertilityOfDormitory(dormitoryId, fertility);
    }

    /**
     * 得到对应宿舍花的成长等级
     * @param dormitoryId 宿舍ID
     * @return 成长等级
     */
    public int getFlowerGrowthLevelOfDormitory(int dormitoryId){
        int growthValue = dormitoryMapper.getTheFlowerGrowthValueOfDormitory(dormitoryId);
        int level;
        if (0<=growthValue && growthValue<8){
            level = 0;
        } else if (8<=growthValue && growthValue<16){
            level = 1;
        } else if (0<=growthValue && growthValue<32){
            level = 2;
        } else if (32<=growthValue && growthValue<64){
            level = 3;
        } else if (64<=growthValue && growthValue<128){
            level = 4;
        } else if (128<=growthValue && growthValue<256){
            level = 5;
        } else if (256<=growthValue && growthValue<512){
            level = 6;
        } else if (512<=growthValue && growthValue<1024){
            level = 7;
        } else{
            level = 8;
        }
        return level;
    }

    /**
     * 修改花的成长值
     * @param dormitoryId 宿舍ID
     * @param flowerGrowthValue 成长值
     */
    public void setFlowerGrowthValueOfDormitory(int dormitoryId, int flowerGrowthValue){
        dormitoryMapper.setTheFlowerGrowthValueOfDormitory(dormitoryId, flowerGrowthValue);
    }

    /**
     * 得到总浇水次数
     * @param dormitoryId 宿舍ID
     * @return 总浇水次数
     */
    public int getTheFlowerWateringTimes(int dormitoryId){
        return dormitoryMapper.getTheFlowerWateringTimes(dormitoryId);
    }

    /**
     * 设置总浇水次数
     * @param dormitoryId 宿舍ID
     * @param times 次数
     */
    public void setTheFlowerWateringTimes(@Param("dormitoryId") int dormitoryId, @Param("times") int times){
        dormitoryMapper.setTheFlowerWateringTimes(dormitoryId, times);
    }

    /**
     * 得到总施肥次数
     * @param dormitoryId 宿舍ID
     * @return 总施肥次数
     */
    public int getTheFlowerFertilizationTimes(int dormitoryId){
        return dormitoryMapper.getTheFlowerFertilizationTimes(dormitoryId);
    }

    /**
     * 设置总施肥次数
     * @param dormitoryId 宿舍ID
     * @param times 次数
     */
    public void setTheFlowerFertilizationTimes(@Param("dormitoryId") int dormitoryId, @Param("times") int times){
        dormitoryMapper.setTheFlowerFertilizationTimes(dormitoryId, times);
    }

    /**
     * 得到最大的宿舍ID
     * @return 最大ID
     */
    public int getMaxDormitoryId(){
        return dormitoryMapper.getMaxDormitoryId();
    }

    /**
     * 设置加入密码
     * @param dormitoryId 宿舍ID
     * @param joinPassword 加入密码
     */
    void setTheJoinPassword(int dormitoryId, String joinPassword){
        dormitoryMapper.setTheJoinPassword(dormitoryId, joinPassword);
    }

    /**
     * 得到加入密码
     * @param dormitoryId 宿舍ID
     * @return 密码
     */
    String getTheJoinPassword(int dormitoryId){
        return dormitoryMapper.getTheJoinPassword(dormitoryId);
    }

    /**
     * 得到全部的宿舍
     * @return 宿舍List
     */
    public List<Dormitory> getAllDormitorys(){
        return dormitoryMapper.getAllDormitorys();
    }

    /**
     * 得到宿舍
     * @param dormitoryId ID
     * @return 宿舍
     */
    public Dormitory getDormitoryById(int dormitoryId){
        return dormitoryMapper.getDormitoryById(dormitoryId);
    }
}
