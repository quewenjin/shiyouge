package com.example.shiyouge.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.sql.Date;
import java.sql.Timestamp;

@Mapper
public interface UserMapper {

    /**
     * 得到用户的肥料数量
     * @param userId 用户ID
     * @return 肥料数量
     */
    int getTheFertilizerQuantityOfUser(String userId);

    /**
     * 得到用户的自习总时长
     * @param userId 用户ID
     * @return 自习总时长
     */
    int getTheStudyTimeTotalOfUser(String userId);

    /**
     * 得到用户的自习时房间号
     * @param userId 用户ID
     * @return 自习时房间号
     */
    int getTheStudyRoomIdOfUser(String userId);
}
