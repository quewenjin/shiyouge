package com.example.shiyouge.mapper;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AdminMapper {
    /**
     * 管理员登录
     * @param userId 用户ID
     * @param password 密码
     * @return 1
     */
    int singIn(String userId, String password);
}