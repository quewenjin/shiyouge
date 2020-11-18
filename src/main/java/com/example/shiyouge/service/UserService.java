package com.example.shiyouge.service;

import com.example.shiyouge.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

@Service
@Transactional
public class UserService {
    @Autowired
    UserMapper userMapper;

    /**
     * 得到用户的肥料数量
     * @param userId 用户ID
     * @return 肥料数量
     */
    public int getFertilizerQuantityOfUser(String userId){
        return userMapper.getTheFertilizerQuantityOfUser(userId);
    }

    /**
     * 得到用户的自习总时长
     * @param userId 用户ID
     * @return 自习总时长
     */
    public int getStudyTimeTotalOfUser(String userId){
        return userMapper.getTheStudyTimeTotalOfUser(userId);
    }

    /**
     * 得到用户的自习时房间号
     * @param userId 用户ID
     * @return 自习时房间号
     */
    public int getStudyRoomIdOfUser(String userId){
        return userMapper.getTheStudyRoomIdOfUser(userId);
    }


}
