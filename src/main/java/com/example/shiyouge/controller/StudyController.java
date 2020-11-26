package com.example.shiyouge.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.shiyouge.service.StudyRoomService;
import com.example.shiyouge.service.StudySystemService;
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
@RequestMapping(value = "/study")
public class StudyController {
    @Autowired
    UserService userService;
    @Autowired
    StudyRoomService studyRoomService;
    @Autowired
    StudySystemService studySystemService;

    /**
     * 进入自习界面后交互的相关信息
     * @param params 用户ID
     * @return 用户的肥料总量 + 用户的自习总时长 + 当前自习室的人数
     */
    @RequestMapping(value = "/getInf", method = RequestMethod.POST)
    public String getInformationOfUser(@RequestBody Map<String, Object> params) {
        String userId = params.get("userId").toString();
        JSONObject json = new JSONObject();
        try{
            json.put("status", "succeed");
            //查询相应信息
            json.put("fertilizerQuantity", userService.getFertilizerQuantityOfUser(userId));
            json.put("studyTimeTotal", userService.getStudyTimeTotalOfUser(userId));
            json.put("numberOfStudy", studyRoomService.getNumberOfStudyRoom(userService.getStudyRoomIdOfUser(userId)));
        } catch (Exception e){
            json.put("status", "wrong");
        }
        return json.toString();
    }

    /**
     * 记录学习
     * @param params 用户ID + 学习时长（分钟计）
     * @return 状态：recorded 或者 wrong
     */
    @RequestMapping(value = "/recorddStudy", method = RequestMethod.POST)
    public String recordStudy(@RequestBody Map<String, Object> params) {
        String userId = params.get("userId").toString();
        int studyTime = Integer.parseInt(params.get("studyTime").toString());
        Date date = new Date();
        Timestamp recordTime =  new Timestamp(date.getTime());
        JSONObject json = new JSONObject();
        try{
            //添加学习记录
            studySystemService.createStudyRecord(userId, studyTime, recordTime);
            //更新个人的总时长，今日时长，本周时长
            userService.updateStudyTimeTotalOfUser(userId, userService.getStudyTimeTotalOfUser(userId)+studyTime);
            userService.updateStudyTimeTodayOfUser(userId, userService.getStudyTimeTodayOfUser(userId)+studyTime);
            userService.updateStudyTimeWeekOfUser(userId, userService.getStudyTimeWeekOfUser(userId)+studyTime);
            json.put("status", "recorded");
        } catch (Exception e){
            json.put("status", "wrong");
        }
        return json.toString();
    }

    /**
     * 每日排名前10
     * @return 状态 + json数组：排名 + 昵称 + 今日学习时长
     */
    @RequestMapping(value = "/rankOfToday", method = RequestMethod.POST)
    public String getStudyRankOfToday() {
        int rank = 1;
        JSONObject json = new JSONObject();
        JSONArray jsonArray = new JSONArray();
        try{
            json.put("status", "succeed");
            List<String> userIds = userService.getTodayTop10();
            for (String userId: userIds) {
                JSONObject jo = new JSONObject();
                jo.put("rank", rank);
                String nickname = userService.getNickNameByUserId(userId);
                jo.put("nickname", nickname);
                jo.put("photo", userService.getPhotoByUserId(userId));
                int studyTimeToday = userService.getStudyTimeTodayOfUser(userId);
                jo.put("studyTimeToday", studyTimeToday);
                rank++;
                jsonArray.add(jo);
            }
            json.put("inf", jsonArray);
        } catch (Exception e){
            json.put("status", "wrong");
        }
        return json.toString();
    }

    /**
     * 每周排名前10
     * @return json数组：排名 + 昵称 + 本周学习时长
     */
    @RequestMapping(value = "/rankOfWeek", method = RequestMethod.POST)
    public String getStudyRankOfWeek() {
        int rank = 1;
        JSONObject json = new JSONObject();
        JSONArray jsonArray = new JSONArray();
        List<String> userIds = userService.getWeekTop10();
        try{
            json.put("status", "succeed");
            for (String userId: userIds) {
                JSONObject jo = new JSONObject();
                jo.put("rank", rank);
                String nickname = userService.getNickNameByUserId(userId);
                jo.put("nickname", nickname);
                jo.put("photo", userService.getPhotoByUserId(userId));
                int studyTimeWeek = userService.getStudyTimeWeekOfUser(userId);
                jo.put("studyTimeWeek", studyTimeWeek);
                rank++;
                jsonArray.add(jo);
            }
            json.put("inf", jsonArray);
        } catch (Exception e){
            json.put("status", "wrong");
        }
        return json.toString();
    }

    /**
     * 开始自习
     * @return 状态：succeed 或者 wrong
     */
    @RequestMapping(value = "/beginStudy", method = RequestMethod.POST)
    public String beginStudy() {
        JSONObject json = new JSONObject();
        try{
            //自习室人数+1
            studyRoomService.updateNumberOfStudyRoom(1, studyRoomService.getNumberOfStudyRoom(1)+1);
            json.put("status", "succeed");
        } catch (Exception e){
            json.put("status", "wrong");
        }
        return json.toString();
    }

    /**
     * 结束自习
     * @return 状态：wrong 或 succeed
     */
    @RequestMapping(value = "/stopStudy", method = RequestMethod.POST)
    public String stopStudy() {
        JSONObject json = new JSONObject();
        try{
            if (studyRoomService.getNumberOfStudyRoom(1) <= 0){
                json.put("status", "wrong");
            } else {
                //自习室人数-1
                studyRoomService.updateNumberOfStudyRoom(1, studyRoomService.getNumberOfStudyRoom(1)-1);
                json.put("status", "succeed");
            }
        } catch (Exception e){
            json.put("status", "wrong");
        }
        return json.toString();
    }
}
