package com.example.shiyouge.mapper;

import org.apache.ibatis.annotations.Mapper;

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
}
