package com.example.shiyouge.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.shiyouge.bean.User;
import com.example.shiyouge.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping(value = "/UserCenter")
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
        int userID = Integer.parseInt(params.get("userID").toString());
        JSONObject json = new JSONObject();
        json.put("Tags", UserService.getTags(userID));
        json.put("Nickname", UserService.getNickname(userID));
        json.put("StudentNumber", UserService.getStudentNumber(userID));
        json.put("Sex", UserService.getSex(userID));
        json.put("Name", UserService.getName(userID));
        json.put("PhotoID", UserService.getPhotoID(userID));
        return json.toString();
    }

    /**
     * 修改昵称
     * @param params 昵称
     * @return 状态：succeed
     */
    @RequestMapping(value = "/setNickName", method = RequestMethod.POST)
    public String setNickName(@RequestBody Map<String, Object> params) {
        String Nickname = params.get("Nickname").toString();
        JSONObject json = new JSONObject();
        try {
            UserService.setNickname(Nickname);
            json.put("status", "succeed");
        } catch (Exception e){
            json.put("status", "wrong");
        }
        return json.toString();
    }

    /**
     * 退出宿舍
     * @param params 用户ID
     * @return 状态：succeed
     */
    @RequestMapping(value = "/quitDormitory", method = RequestMethod.POST)
    public String quitDormitory(@RequestBody Map<String, Object> params) {
        int userID = Integer.parseInt(params.get("userID").toString());
        JSONObject json = new JSONObject();
        try {
            int DormitoryID = UserService.getDormitory(userID);
            UserService.quitDormitory(userID);
            DormitoryService.removeUser(DormitoryID, userID);
            json.put("status", "succeed");
        } catch (Exception e){
            json.put("status", "wrong");
        }
        return json.toString();
    }

    /**
     * 随机宿舍id
     * @return string：一个暂未使用的宿舍id
     */
    @RequestMapping(value = "/randomDormitory", method = RequestMethod.POST)
    public String randomDormitory() {
        JSONObject json = new JSONObject();
        json.put("id", DormitoryService.randomID());
        return json.toString();
    }

    /**
     * 创建宿舍
     * @param params 宿舍ID
     * @return 状态：succeed
     */
    @RequestMapping(value = "/createDormitory", method = RequestMethod.POST)
    public String createDormitory(@RequestBody Map<String, Object> params) {
        int DormitoryID = Integer.parseInt(params.get("DormitoryID").toString());
        JSONObject json = new JSONObject();
        try {
            DormitoryService.created(DormitoryID);
            json.put("status", "succeed");
        } catch (Exception e){
            json.put("status", "wrong");
        }
        return json.toString();
    }

    /**
     * 设置标签
     * @param params 用户ID + 用户标签Tags
     * @return 状态：succeed
     */
    @RequestMapping(value = "/setUserTag", method = RequestMethod.POST)
    public String setUserTag(@RequestBody Map<String, Object> params) {
        int userID = Integer.parseInt(params.get("userID").toString());
        String Tags = params.get("Tags").toString();
        JSONObject json = new JSONObject();
        try {
            UserService.setTags(userID, Tags);
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
