package com.example.shiyouge.controller;

import com.example.shiyouge.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

/**
 * 数据库定时自动更新部分
 */
@Component
public class UpdateCintroller {
    @Autowired
    UserService userService;

    /**
     * 每日 00:00:00 将用户的今日学习时长清0
     */
    @Scheduled(cron = "0 0 0 * * ?")
    public void setStudyTimeTodayToZero() {
        userService.setAllStudyTimeTodayToZero();

        System.out.println("clear");

    }

    /**
     * 每周星期一 00:00:00 将用户的今日学习时长清0
     */
    @Scheduled(cron = "0 0 0 ? * MON")
    public void setStudyTimeWeekToZero() {
        userService.setAllStudyTimeWeekToZero();
    }


}
