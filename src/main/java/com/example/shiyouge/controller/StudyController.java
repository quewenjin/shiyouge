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
        json.put("fertilizerQuantity", userService.getFertilizerQuantityOfUser(userId));
        json.put("studyTimeTotal", userService.getStudyTimeTotalOfUser(userId));
        json.put("numberOfStudy", studyRoomService.getnumberOfStudyRoom(userService.getStudyRoomIdOfUser(userId)));
        return json.toString();
    }

}
