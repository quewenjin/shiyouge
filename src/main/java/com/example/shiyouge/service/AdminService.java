package com.example.shiyouge.service;

import com.example.shiyouge.mapper.AdminMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AdminService {
    @Autowired
    AdminMapper adminMapper;

    /**
     * 管理员登录
     * @param userId 用户ID
     * @param password 密码
     * @return 1
     */
    public int signIn(String userId,String password){
        return adminMapper.singIn(userId,password);
    }
}