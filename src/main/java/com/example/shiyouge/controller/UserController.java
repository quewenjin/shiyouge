package com.example.shiyouge.controller;

import com.example.shiyouge.bean.Dormitory;
import com.example.shiyouge.service.UserService;
import com.alibaba.fastjson.JSONObject;
import com.example.shiyouge.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/userCenter")
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    DormitoryService dormitoryService;

    /**
     * 得到用户的各个属性
     * @param params 用户id
     * @return json：标签，昵称，学号，性别，姓名，头像代码
     */
    @RequestMapping(value = "/getDetailsOfPeople", method = RequestMethod.POST)
    public String getDetailsOfPeople(@RequestBody Map<String, Object> params) {
        String userID = params.get("userId").toString();
        JSONObject json = new JSONObject();
        json.put("tags", userService.getTagsByUserId(userID));
        json.put("nickname", userService.getNickNameByUserId(userID));
        json.put("studentNumber", userService.getStudentNumberByUserId(userID));
        json.put("sex", userService.getSexByUserId(userID));
        json.put("realName", userService.getRealNameByUserId(userID));
        json.put("photo", userService.getPhotoByUserId(userID));
        json.put("dormitoryId", userService.getDormitoryIDByUserId(userID));
        return json.toString();
    }

    /**
     * 修改昵称
     * @param params 昵称
     * @return 状态：succeed 或 wrong
     */
    @RequestMapping(value = "/setNickname", method = RequestMethod.POST)
    public String setNickName(@RequestBody Map<String, Object> params) {
        String userID = params.get("userId").toString();
        String Nickname = params.get("nickname").toString();
        JSONObject json = new JSONObject();
        try {
            userService.setUserNickName(userID, Nickname);
            json.put("status", "succeed");
        } catch (Exception e){
            json.put("status", "wrong");
        }
        return json.toString();
    }

    /**
     * 设置用户基本信息
     * @param params 昵称
     * @return 状态：succeed 或 wrong
     */
    @RequestMapping(value = "/setBaseInf", method = RequestMethod.POST)
    public String setBaseInf(@RequestBody Map<String, Object> params) {
        String userId = params.get("userId").toString();
        String studentNumber = params.get("studentNumber").toString();
        String userSex = params.get("userSex").toString();
        String userRealName = params.get("userRealName").toString();
        JSONObject json = new JSONObject();
        try {
            userService.setTheUserRealName(userId, userRealName);// 设置真实姓名
            userService.setTheUserStudentNumber(userId, studentNumber);// 设置学号
            userService.setTheUserSex(userId, userSex);// 设置性别
            json.put("status", "succeed");
        } catch (Exception e){
            json.put("status", "wrong");
        }
        return json.toString();
    }

    /**
     * 退出宿舍
     * @param params 用户ID
     * @return 状态：succeed 或 wrong
     */
    @RequestMapping(value = "/quitDormitory", method = RequestMethod.POST)
    public String quitDormitory(@RequestBody Map<String, Object> params) {
        String userID = params.get("userId").toString();
        JSONObject json = new JSONObject();
        try {
            int dormitoryID = userService.getDormitoryIDByUserId(userID);
            //宿舍人数-1
            dormitoryService.setTheDormitoryMate(dormitoryID, dormitoryService.getTheDormitoryMate(dormitoryID)-1);
            //退出宿舍
            userService.quitDormitoryOfUser(userID);
            json.put("status", "succeed");
        } catch (Exception De){
            json.put("status", "wrong");
        }
        return json.toString();
    }

    /**
     * 随机ID
     * @return 状态：succeed 或 wrong
     */
    @RequestMapping(value = "/randomDormitoryId", method = RequestMethod.POST)
    public String radomDormitoryId() {
        JSONObject json = new JSONObject();
        try {
            int randomId = 1;
            List<Dormitory> dormitories = dormitoryService.getAllDormitorys();
            if (dormitories.size() != 0){
                randomId = dormitoryService.getMaxDormitoryId()+1;
            }
            json.put("dormitoryId", randomId);
            json.put("status", "succeed");
        } catch (Exception e){
            json.put("status", "wrong");
        }
        return json.toString();
    }

    /**
     * 创建宿舍
     * @param params 宿舍ID 加入密码
     * @return 状态：succeed 或 wrong
     */
    @RequestMapping(value = "/createDormitory", method = RequestMethod.POST)
    public String createDormitory(@RequestBody Map<String, Object> params) {
        String userId = params.get("userId").toString();
        int DormitoryID = Integer.parseInt(params.get("dormitoryId").toString());
        String joinPassword = params.get("joinPassword").toString();
        JSONObject json = new JSONObject();
        try {
            dormitoryService.created(DormitoryID, joinPassword);
            //宿舍人数+1
            dormitoryService.setTheDormitoryMate(DormitoryID, dormitoryService.getTheDormitoryMate(DormitoryID)+1);
            //加入对应宿舍
            userService.joinDormitoryOfUser(userId, DormitoryID);
            json.put("status", "succeed");
        } catch (Exception e){
            json.put("status", "wrong");
        }
        return json.toString();
    }

    /**
     * 加入宿舍
     * @param params 宿舍ID 加入密码
     * @return 状态：succeed 或 wrong
     */
    @RequestMapping(value = "/joinDormitory", method = RequestMethod.POST)
    public String joinDormitory(@RequestBody Map<String, Object> params) {
        String userId = params.get("userId").toString();
        int DormitoryID = Integer.parseInt(params.get("dormitoryId").toString());
        String joinPassword = params.get("joinPassword").toString();
        JSONObject json = new JSONObject();
        try {
            dormitoryService.created(DormitoryID, joinPassword);
            //宿舍人数+1
            dormitoryService.setTheDormitoryMate(DormitoryID, dormitoryService.getTheDormitoryMate(DormitoryID)+1);
            //加入对应宿舍
            userService.joinDormitoryOfUser(userId, DormitoryID);
            json.put("status", "succeed");
        } catch (Exception e){
            json.put("status", "wrong");
        }
        return json.toString();
    }

    /**
     * 设置标签
     * @param params 用户标签Tags
     * @return 状态：succeed 或 wrong
     */
    @RequestMapping(value = "/setUserTag", method = RequestMethod.POST)
    public String setUserTag(@RequestBody Map<String, Object> params) {
        String userID = params.get("userId").toString();
        String Tags = params.get("tags").toString();
        JSONObject json = new JSONObject();
        try {
            userService.setUserTag(userID, Tags);
            json.put("status", "succeed");
        } catch (Exception e){
            json.put("status", "wrong");
        }
        return json.toString();
    }

    /**
     * 得到标签
     * @param params 用户ID
     * @return 状态：succeed 或 wrong
     */
    @RequestMapping(value = "/getUserTag", method = RequestMethod.POST)
    public String getUserTag(@RequestBody Map<String, Object> params) {
        String userID = params.get("userId").toString();
        JSONObject json = new JSONObject();
        try {
            json.put("tags", userService.getTagsByUserId(userID));
            json.put("status", "succeed");
        } catch (Exception e){
            json.put("status", "wrong");
        }
        return json.toString();
    }

    /**
     * 两人匹配算法
     * @return 临时宿舍id
     */
    @RequestMapping(value = "/SingleAlgorithm", method = RequestMethod.POST)
    public String SingleAlgorithm() {
        JSONObject json = new JSONObject();
        json.put("status", "succeed");
        return json.toString();
    }

    /**
     * 四人匹配算法
     * @return 最终宿舍id
     */
    @RequestMapping(value = "/CoupleAlgorithm", method = RequestMethod.POST)
    public String CoupleAlgorithm() {
        JSONObject json = new JSONObject();
        json.put("status", "succeed");
        return json.toString();
    }
}