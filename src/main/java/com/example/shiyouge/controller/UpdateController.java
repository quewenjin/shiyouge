package com.example.shiyouge.controller;

import com.example.shiyouge.service.DormitoryService;
import com.example.shiyouge.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * 数据库定时自动更新部分
 */
@Component
public class UpdateController {
    @Autowired
    UserService userService;
    @Autowired
    DormitoryService dormitoryService;

    /**
     * 每日 00:00:00 将用户的今日学习时长清0
     */
    @Scheduled(cron = "0 0 0 * * ?")
    public void setStudyTimeTodayToZero() {
        userService.setAllStudyTimeTodayToZero();
        System.out.println("setStudyTimeTodayToZero");
        System.out.println("每日 00:00:00 将用户的今日学习时长清0");
    }

    /**
     * 每周星期一 00:00:00 将用户的本周学习时长清0
     */
    @Scheduled(cron = "0 0 0 ? * MON")
    public void setStudyTimeWeekToZero() {
        userService.setAllStudyTimeWeekToZero();
        System.out.println("setStudyTimeWeekToZero");
        System.out.println("每周星期一 00:00:00 将用户的今日学习时长清0");
    }

    /**
     * 每日 00:00:00 将宿舍花盆的土壤湿度清0
     */
    @Scheduled(cron = "0 0 0 * * ?")
    public void setSoilMoistureToZero() {
        dormitoryService.setAllSoilMoistureToZero();
        System.out.println("setSoilMoistureToZero");
        System.out.println("每日 00:00:00 将宿舍花盆的土壤湿度清0");
    }

    /**
     * 每日 00:00:00 将宿舍花盆的土壤肥度清0
     */
    @Scheduled(cron = "0 0 0 * * ?")
    public void setAllSoilFertilityToZero() {
        dormitoryService.setAllSoilFertilityToZero();
        System.out.println("setAllSoilFertilityToZero");
        System.out.println("每日 00:00:00 将宿舍花盆的土壤肥度清0");
    }
}
