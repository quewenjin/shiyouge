package com.example.shiyouge.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.shiyouge.bean.BlackBoard;
import com.example.shiyouge.service.BlackBoardService;
import com.example.shiyouge.service.DormitoryService;
import com.example.shiyouge.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/balcony")
public class BalconyController {
    @Autowired
    DormitoryService dormitoryService;
    @Autowired
    UserService userService;
    @Autowired
    BlackBoardService blackBoardService;

    /**
     * 进入花盆界面返回的信息
     * @param params 宿舍ID
     * @return 状态：succeed 或 wrong + 今日浇水次数 + 今日施肥次数 + 花的等级
     */
    @RequestMapping(value = "/getFlowerInf", method = RequestMethod.POST)
    public String getFlowerInf(@RequestBody Map<String, Object> params) {
        int dormitoryId = Integer.parseInt(params.get("dormitoryId").toString());
        JSONObject json = new JSONObject();
        try {
            json.put("soilMoisture", dormitoryService.getTheSoilMoistureOfDormitory(dormitoryId));
            json.put("soilFertility", dormitoryService.getTheSoilFertilityOfDormitory(dormitoryId));
            json.put("flowerLevel", dormitoryService.getFlowerGrowthLevelOfDormitory(dormitoryId));
            json.put("status", "succeed");
        } catch (Exception e){
            json.put("status", "wrong");
        }
        return json.toString();
    }

    /**
     * 用户施肥
     * @param params 用户ID + 宿舍ID
     * @return 状态：noFertilizer（肥料不够） 或 succeed（成功施肥） 或 wrong（错误）
     */
    @RequestMapping(value = "/fertilize", method = RequestMethod.POST)
    public String fertilize(@RequestBody Map<String, Object> params) {
        String userId = params.get("userId").toString();
        int dormitoryId = Integer.parseInt(params.get("dormitoryId").toString());
        Date date = new Date();
        Timestamp recordTime =  new Timestamp(date.getTime());
        String typeOfAction = "fertilize";
        JSONObject json = new JSONObject();
        try {
            int fertilizerQuantity = userService.getFertilizerQuantityOfUser(userId);
            if (fertilizerQuantity == 0){
                //没有肥料的情况
                json.put("status", "noFertilizer");
                json.put("mes","肥料不足");
                return json.toString();
            }
            //小黑板记录
            blackBoardService.createBlackBoardRecord(dormitoryId, typeOfAction, userId, recordTime);
            //用户施肥次数+1
            userService.setTheFertilizationTimes(userId, userService.getTheFertilizationTimes(userId)+1);
            //用户肥料数量-1
            userService.setFertilizerQuantityOfUser(userId, userService.getFertilizerQuantityOfUser(userId)-1);
            //花的总施肥次数+1
            dormitoryService.setTheFlowerFertilizationTimes(dormitoryId, dormitoryService.getTheFlowerFertilizationTimes(dormitoryId)+1);
            //花的成长值+3
            dormitoryService.setFlowerGrowthValueOfDormitory(dormitoryId, dormitoryService.getFlowerGrowthLevelOfDormitory(dormitoryId)+3);
            //花的今天施肥+1
            dormitoryService.setSoilFertilityOfDormitory(dormitoryId, dormitoryService.getTheSoilFertilityOfDormitory(dormitoryId)+1);
            json.put("status", "succeed");
            json.put("mes","施肥成功");
        } catch (Exception e){
            json.put("status", "wrong");
            json.put("mes","服务器开了个小差");
        }
        return json.toString();
    }

    /**
     * 用户浇水
     * @param params 用户ID + 宿舍ID
     * @return 状态：noWater（水不够） 或 tooWet（土壤过湿不能浇水）或 succeed（成功施肥） 或 wrong（错误）
     */
    @RequestMapping(value = "/watering", method = RequestMethod.POST)
    public String watering(@RequestBody Map<String, Object> params) {
        String userId = params.get("userId").toString();
        int dormitoryId = Integer.parseInt(params.get("dormitoryId").toString());
        Date date = new Date();
        Timestamp recordTime =  new Timestamp(date.getTime());
        String typeOfAction = "watering";
        JSONObject json = new JSONObject();
        try {
            int waterQuantity = userService.getWaterQuantityOfUser(userId);
            //没有水的情况
            if (waterQuantity == 0){
                json.put("status", "noWater");
                json.put("mes","水量不足");
                return json.toString();
            }
            //每日浇水达到上限情况
            if (dormitoryService.getTheSoilMoistureOfDormitory(dormitoryId) >= 10){
                json.put("status", "tooWet");
                json.put("mes","今日浇水已达上限");
                return json.toString();
            }
            //小黑板记录
            blackBoardService.createBlackBoardRecord(dormitoryId, typeOfAction, userId, recordTime);
            //用户浇水次数+1
            userService.setTheWateringTimes(userId, userService.getTheWateringTimes(userId)+1);
            //用户水数量-1
            userService.setWaterQuantityOfUser(userId, userService.getWaterQuantityOfUser(userId)-1);
            //花的总浇水次数+1
            dormitoryService.setTheFlowerWateringTimes(dormitoryId, dormitoryService.getTheFlowerWateringTimes(dormitoryId)+1);
            //花的成长值+1
            dormitoryService.setFlowerGrowthValueOfDormitory(dormitoryId, dormitoryService.getFlowerGrowthLevelOfDormitory(dormitoryId)+1);
            //花的今天浇水+1
            dormitoryService.setSoilMoistureOfDormitory(dormitoryId, dormitoryService.getTheSoilMoistureOfDormitory(dormitoryId)+1);
            json.put("status", "succeed");
            json.put("mes","浇水成功");
        } catch (Exception e){
            json.put("status", "wrong");
            json.put("mes","服务器开了个小差");
        }
        return json.toString();
    }

    /**
     * 养花记录
     * @param params 宿舍ID
     * @return 状态：状态：succeed 或 wrong + 今日浇水次数 + 今日施肥次数 + 养花记录json数组：昵称 + 浇花或施肥
     */
    @RequestMapping(value = "/plantingRecord", method = RequestMethod.POST)
    public String plantingRecord(@RequestBody Map<String, Object> params) {
        int dormitoryId = Integer.parseInt(params.get("dormitoryId").toString());
        int getNum = 20;
        JSONObject json = new JSONObject();
        try {
            json.put("soilMoisture", dormitoryService.getTheSoilMoistureOfDormitory(dormitoryId));
            json.put("soilFertility", dormitoryService.getTheSoilFertilityOfDormitory(dormitoryId));
            JSONArray jsonArray = new JSONArray();
            //最近的20条
            List<BlackBoard> blackBoards = blackBoardService.getBlackBoardRecords(dormitoryId, getNum);
            for (BlackBoard blackBoard: blackBoards) {
                JSONObject jo = new JSONObject();
                jo.put("userNickname", userService.getNickNameByUserId(blackBoard.getUserIdOfRecord()));
                jo.put("actionType", blackBoard.getRecordType());
                //jo.put("actionTime", blackBoard.getRecordTime());
                jsonArray.add(jo);
            }
            json.put("records", jsonArray);
            json.put("status", "succeed");
        } catch (Exception e){
            json.put("status", "wrong");
        }
        return json.toString();
    }
}
