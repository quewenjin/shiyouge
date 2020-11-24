package com.example.shiyouge.mapper;

import com.example.shiyouge.bean.BlackBoard;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.sql.Timestamp;
import java.util.List;

@Mapper
public interface BlackBoardMapper {
    /**
     * 得到宿舍黑板记录
     * @param dormitoryId 宿舍ID
     * @return
     */
    List<BlackBoard> getTheBlackBoardRecords(@Param("dormitoryId") int dormitoryId, @Param("getNum") int getNum);

    /**
     * 创建小黑板记录
     * @param dormitoryId 宿舍ID
     * @param type 类型
     * @param userId 用户ID
     * @param createTime 创建时间
     */
    void createTheBlackBoardRecord(@Param("dormitoryId") int dormitoryId, @Param("actionType") String actionType,
                                   @Param("userId") String userId, @Param("createTime") Timestamp createTime);
}
