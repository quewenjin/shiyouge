package com.example.shiyouge.service;

import com.example.shiyouge.bean.ChatSystem;
import com.example.shiyouge.mapper.ChatSystemMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.List;

@Service
@Transactional
public class ChatSystemService {
    @Autowired
    ChatSystemMapper chatSystemMapper;

    /**
     * 得到一定条数的聊天记录
     * @param dormitoryId 宿舍ID
     * @param getNum 返回条数
     * @return List<ChatSystem>
     */
    public List<ChatSystem> getChatRecords(int dormitoryId, int getNum){
        return chatSystemMapper.getTheChatRecords(dormitoryId, getNum);
    }

    /**
     * 创建宿舍聊天记录
     * @param dormitoryId 宿舍ID
     * @param userIdOfSender 发送人ID
     * @param chatContent 内容
     * @param sendTime 发送时间
     */
    public void creatChatRecord(int dormitoryId, String userIdOfSender, String chatContent, Timestamp sendTime){
        chatSystemMapper.creatTheChatRecord(dormitoryId, userIdOfSender, chatContent, sendTime);
    }
}
