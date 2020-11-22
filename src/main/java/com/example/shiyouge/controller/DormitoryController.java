package com.example.shiyouge.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.shiyouge.bean.ChatSystem;
import com.example.shiyouge.bean.MessageBoard;
import com.example.shiyouge.service.ChatSystemService;
import com.example.shiyouge.service.MessageBoardService;
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
@RequestMapping(value = "/dormitory")
public class DormitoryController {
    @Autowired
    MessageBoardService messageBoardService;
    @Autowired
    UserService userService;
    @Autowired
    ChatSystemService chatSystemService;

    /**
     * 查看宿舍留言板
     * @param params 宿舍ID
     * @return 状态：succeed 或 wrong + 昵称 + 内容 + 时间（最新的优先）
     */
    @RequestMapping(value = "/getMessageBoard", method = RequestMethod.POST)
    public String getMessageBoard(@RequestBody Map<String, Object> params) {
        int dormitoryId = Integer.parseInt(params.get("dormitoryId").toString());
        JSONObject json = new JSONObject();
        try{
            JSONArray jsonArray = new JSONArray();
            List<MessageBoard> messageBoards = messageBoardService.getMessagesOfDormitory(dormitoryId);
            for (MessageBoard messageBoard : messageBoards) {
                JSONObject jo = new JSONObject();
                jo.put("nickname", userService.getNickNameByUserId(messageBoard.getUserIdOfMessage()));
                jo.put("messageContent", messageBoard.getMessageContent());
                jo.put("messageTime", messageBoard.getMessageTime());
                jsonArray.add(jo);
            }
            json.put("messages", jsonArray);
            json.put("status", "succeed");
        } catch (Exception e){
            json.put("status", "wrong");
        }
        return json.toString();
    }

    /**
     * 创建留言
     * @param params 宿舍ID + 留言人ID + 留言内容
     * @return 状态：succeed 或 wrong
     */
    @RequestMapping(value = "/leaveMessage", method = RequestMethod.POST)
    public String leaveMessage(@RequestBody Map<String, Object> params) {
        int dormitoryId = Integer.parseInt(params.get("dormitoryId").toString());
        String userId = params.get("userId").toString();
        String content = params.get("content").toString();
        Date date = new Date();
        Timestamp leaveTime =  new Timestamp(date.getTime());
        JSONObject json = new JSONObject();
        try{
            //创建留言
            messageBoardService.creatTheNewMessage(dormitoryId, userId, content, leaveTime);
            json.put("status", "succeed");
        } catch (Exception e){
            json.put("status", "wrong");
        }
        return json.toString();
    }

    /**
     * 得到一定条数的聊天记录
     * @param params 宿舍ID + 发消息人ID + 消息内容
     * @return 状态：succeed 或 wrong + json数组：发消息人昵称 + 消息内容 + 发送时间
     */
    @RequestMapping(value = "/getChatRecords", method = RequestMethod.POST)
    public String getChatRecords(@RequestBody Map<String, Object> params) {
        int dormitoryId = Integer.parseInt(params.get("dormitoryId").toString());
        int getNum = Integer.parseInt(params.get("getNum").toString());
        JSONObject json = new JSONObject();
        try{
            JSONArray jsonArray = new JSONArray();
            List<ChatSystem> chatSystems = chatSystemService.getChatRecords(dormitoryId, getNum);
            for (ChatSystem chatSystem: chatSystems) {
                JSONObject jo = new JSONObject();
                jo.put("userNickname", userService.getNickNameByUserId(chatSystem.getUserIdOfSender()));
                jo.put("content", chatSystem.getChatContent());
                jo.put("sendTime", chatSystem.getSendTime());
                jsonArray.add(jo);
            }
            json.put("chatRecords", jsonArray);
            json.put("status", "succeed");
        } catch (Exception e){
            json.put("status", "wrong");
        }
        return json.toString();
    }

    /**
     * 发消息
     * @param params 宿舍ID + 发消息人ID + 消息内容
     * @return 状态：succeed 或 wrong
     */
    @RequestMapping(value = "/toChat", method = RequestMethod.POST)
    public String toChat(@RequestBody Map<String, Object> params) {
        int dormitoryId = Integer.parseInt(params.get("dormitoryId").toString());
        String userId = params.get("userId").toString();
        String content = params.get("content").toString();
        Date date = new Date();
        Timestamp leaveTime =  new Timestamp(date.getTime());
        JSONObject json = new JSONObject();
        try{
            //创建聊天记录
            chatSystemService.creatChatRecord(dormitoryId, userId, content, leaveTime);
            json.put("status", "succeed");
        } catch (Exception e){
            json.put("status", "wrong");
        }
        return json.toString();
    }
}
