package com.example.shiyouge.controller;

import com.alibaba.fastjson.JSONArray;
import com.example.shiyouge.bean.Dormitory;
import com.example.shiyouge.service.UserService;
import com.alibaba.fastjson.JSONObject;
import com.example.shiyouge.service.*;
import com.example.shiyouge.utils.RandomUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping(value = "/userCenter")
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    DormitoryService dormitoryService;

    //用户标签数组
    String[] tagsArray ={"考研党","毕业就打工人","自觉的读书人","自觉性差","相约读书","一人游书海","爱提问",//学习
            "独立解决", "优秀理科生","儒雅文科生","天赋型选手","努力拼搏者","竞赛得奖选手","学生工作强者",//学习
            "早睡早起","晚睡晚起","爱好安静","噪音无感","工装裤","JK","Lolita",//生活
            "DK","汉服","清淡","无辣不欢","火锅","烤肉","日料","韩料","动物真可爱","不喜欢动物",//生活
            "王者荣耀","和平精英","斗地主","球类运动","听歌","韩综/韩剧","日剧","英美剧","追星",//兴趣
            "美食","乐器","画画","麻将","魔方","收藏","桌游",//兴趣
            "文静","活泼","社恐","爱好交友","乐观向上","老网抑云",//人生
            "天道酬勤","快乐咸鱼","以和为贵","有仇必报","平淡是真","轰轰烈烈"//人生
    };

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
            int randomId = RandomUtil.getTheRandomDormitoryId();
            while (dormitoryService.getAllDormitorys().size() != 0){
                randomId = RandomUtil.getTheRandomDormitoryId();
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
     * @return 状态：succeed 或 wrong 或 occupied
     */
    @RequestMapping(value = "/createDormitory", method = RequestMethod.POST)
    public String createDormitory(@RequestBody Map<String, Object> params) {
        String userId = params.get("userId").toString();
        int DormitoryID = Integer.parseInt(params.get("dormitoryId").toString());
        String joinPassword = params.get("joinPassword").toString();
        JSONObject json = new JSONObject();
        try {
            Dormitory dormitory = dormitoryService.getDormitoryById(DormitoryID);
            if (dormitory == null){
                dormitoryService.created(DormitoryID, joinPassword);
                //加入对应宿舍
                userService.joinDormitoryOfUser(userId, DormitoryID);
                json.put("status", "succeed");
            } else {
                json.put("status", "occupied");
            }
        } catch (Exception e){
            json.put("status", "wrong");
        }
        return json.toString();
    }

    /**
     * 加入宿舍
     * @param params 宿舍ID 加入密码
     * @return 状态：succeed 或 wrong 或 filled
     */
    @RequestMapping(value = "/joinDormitory", method = RequestMethod.POST)
    public String joinDormitory(@RequestBody Map<String, Object> params) {
        String userId = params.get("userId").toString();
        int DormitoryID = Integer.parseInt(params.get("dormitoryId").toString());
        String joinPassword = params.get("joinPassword").toString();
        JSONObject json = new JSONObject();
        try {
            dormitoryService.created(DormitoryID, joinPassword);
            int theNum = dormitoryService.getTheDormitoryMate(DormitoryID);//宿舍人数
            if (theNum < 4){
                //宿舍人数+1
                dormitoryService.setTheDormitoryMate(DormitoryID, dormitoryService.getTheDormitoryMate(DormitoryID)+1);
                //加入对应宿舍
                userService.joinDormitoryOfUser(userId, DormitoryID);
                json.put("status", "succeed");
            } else {
                json.put("status", "filled");
            }
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
            JSONArray jsonArray = new JSONArray();
            String tags = userService.getTagsByUserId(userID);
            int index = 1;
            for (int i = 0; i < tags.length(); i++) {
                if (tags.charAt(i) == '1'){
                    JSONObject js = new JSONObject();
                    js.put(String.valueOf(index), tagsArray[i]);
                    jsonArray.add(js);
                    index ++;
                }
            }
            json.put("tags", jsonArray);
            json.put("status", "succeed");
        } catch (Exception e){
            json.put("status", "wrong");
        }
        return json.toString();
    }

    /**
     * 设置是否进入自动匹配状态
     * @param params 用户ID
     * @return 状态：succeed 或 wrong
     */
    @RequestMapping(value = "/setIfOnMatching", method = RequestMethod.POST)
    public String setIfOnMatching(@RequestBody Map<String, Object> params) {
        String userId = params.get("userId").toString();
        int ifOnMatching = Integer.parseInt(params.get("ifOnMatching").toString());
        JSONObject json = new JSONObject();
        try {
            userService.setIfOnMatchingByUserId(userId, ifOnMatching);
            json.put("status", "succeed");
        } catch (Exception e){
            json.put("status", "wrong");
        }
        return json.toString();
    }
}