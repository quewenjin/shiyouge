package com.example.shiyouge.mapper;

import com.example.shiyouge.bean.ChatSystem;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.sql.Timestamp;
import java.util.List;

@Mapper
public interface ChatSystemMapper {

    /**
     * 得到一定条数的聊天记录
     * @param dormitoryId 宿舍ID
     * @param getNum 返回条数
     * @return List<ChatSystem>
     */
    List<ChatSystem> getTheChatRecords(@Param("dormitoryId") int dormitoryId, @Param("getNum") int getNum);

    /**
     * 创建宿舍聊天记录
     * @param dormitoryId 宿舍ID
     * @param userIdOfSender 发送人ID
     * @param chatContent 内容
     * @param sendTime 发送时间
     */
    void creatTheChatRecord(@Param("dormitoryId") int dormitoryId, @Param("userIdOfSender") String userIdOfSender,
                            @Param("chatContent") String chatContent, @Param("sendTime") Timestamp sendTime);
}
