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


}
