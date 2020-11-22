package com.example.shiyouge.service;

import com.example.shiyouge.mapper.DormitoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class DormitoryService {
    @Autowired
    DormitoryMapper dormitoryMapper;

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
}
