package com.example.shiyouge.service;

import com.example.shiyouge.bean.BlackBoard;
import com.example.shiyouge.mapper.BlackBoardMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.List;

@Service
@Transactional
public class BlackBoardService {
    @Autowired
    BlackBoardMapper blackBoardMapper;

    /**
     * 得到宿舍黑板记录
     * @param dormitoryId 宿舍ID
     * @return
     */
    public List<BlackBoard> getBlackBoardRecords(int dormitoryId, int getNum){
        return blackBoardMapper.getTheBlackBoardRecords(dormitoryId, getNum);
    }

    /**
     * 创建小黑板记录
     * @param dormitoryId 宿舍ID
     * @param type 类型
     * @param userId 用户ID
     * @param createTime 创建时间
     */
    public void createBlackBoardRecord(int dormitoryId, String type, String userId, Timestamp createTime){
        blackBoardMapper.createTheBlackBoardRecord(dormitoryId, type, userId, createTime);
    }
}
