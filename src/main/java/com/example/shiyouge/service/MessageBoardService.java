package com.example.shiyouge.service;

import com.example.shiyouge.bean.MessageBoard;
import com.example.shiyouge.mapper.MessageBoardMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.List;

@Service
@Transactional
public class MessageBoardService {
    @Autowired
    MessageBoardMapper messageBoardMapper;

    /**
     * 通过ID得到
     * @param dormitoryId 宿舍ID
     * @return List<MessageBoard>
     */
    public List<MessageBoard> getMessagesOfDormitory(int dormitoryId){
        return messageBoardMapper.getTheMessagesOfDormitory(dormitoryId);
    }

    /**
     * 留言
     * @param dormitoryId 宿舍ID
     * @param userId 留言人ID
     * @param content  留言内容
     * @param leaveTime 留言时间
     */
    public void creatTheNewMessage(int dormitoryId, String userId, String content, Timestamp leaveTime){
        messageBoardMapper.creatTheNewMessage(dormitoryId, userId, content, leaveTime);
    }
}
