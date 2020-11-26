package com.example.shiyouge.service;

import com.example.shiyouge.mapper.MatchingMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class MatchingService {
    @Autowired
    MatchingMapper matchingMapper;

    /**
     * 存入二阶匹配数据库
     * @param matchingId 匹配ID，从1开始
     * @param userIdOnMatching 用户ID
     * @param labelOfUser 用户标签
     * @param failedTimes 用户二阶失败次数
     */
    public void createMatchingRole(int matchingId, String userIdOnMatching, String labelOfUser, int failedTimes){
        matchingMapper.createMatchingRole(matchingId, userIdOnMatching, labelOfUser, failedTimes);
    }

    /**
     * 清空二阶匹配数据库
     */
    public void deleteAllInf(){
        matchingMapper.deleteAllInf();
    }

    /**
     * 得到匹配失败次数
     * @param userId ID
     * @return 是否匹配中
     */
    public int getMatchingFailedTimesByUserId(String userId){
        return matchingMapper.getMatchingFailedTimesByUserId(userId);
    }

    /**
     * 设置匹配失败次数
     * @param userId ID
     * @param failedTimes 失败次数
     */
    public void setMatchingFailedTimesByUserId(String userId, int failedTimes){
        matchingMapper.setMatchingFailedTimesByUserId(userId, failedTimes);
    }
}
