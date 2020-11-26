package com.example.shiyouge.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface MatchingMapper {
    /**
     * 存入二阶匹配数据库
     * @param matchingId 匹配ID，从1开始
     * @param userIdOnMatching 用户ID
     * @param labelOfUser 用户标签
     * @param failedTimes 用户二阶失败次数
     */
    void createMatchingRole(@Param("matchingId") int matchingId, @Param("userIdOnMatching") String userIdOnMatching,
                            @Param("labelOfUser") String labelOfUser, @Param("failedTimes") int failedTimes);

    /**
     * 清空二阶匹配数据库
     */
    void deleteAllInf();

    /**
     * 得到匹配失败次数
     * @param userId ID
     * @return 是否匹配中
     */
    int getMatchingFailedTimesByUserId(String userId);

    /**
     * 设置匹配失败次数
     * @param userId ID
     * @param failedTimes 失败次数
     */
    void setMatchingFailedTimesByUserId(@Param("userId") String userId, @Param("failedTimes") int failedTimes);
}
