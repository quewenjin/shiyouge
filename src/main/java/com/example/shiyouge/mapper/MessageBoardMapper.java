package com.example.shiyouge.mapper;

import com.example.shiyouge.bean.MessageBoard;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Mapper
public interface MessageBoardMapper {

    /**
     * 通过ID得到
     * @param dormitoryId 宿舍ID
     * @return List<MessageBoard>
     */
    List<MessageBoard> getTheMessagesOfDormitory(int dormitoryId);

    /**
     * 留言
     * @param dormitoryId 宿舍ID
     * @param userId 留言人ID
     * @param content  留言内容
     * @param leaveTime 留言时间
     */
    void creatTheNewMessage(@Param("dormitoryId") int dormitoryId, @Param("userId") String userId,
                            @Param("content") String content, @Param("leaveTime") Timestamp leaveTime);
}
