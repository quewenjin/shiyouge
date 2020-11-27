package com.example.shiyouge.controller;

import com.example.shiyouge.Algorithm.code1;
import com.example.shiyouge.Algorithm.code2;
import com.example.shiyouge.bean.User;
import com.example.shiyouge.service.DormitoryService;
import com.example.shiyouge.service.MatchingService;
import com.example.shiyouge.service.UserService;
import com.example.shiyouge.utils.RandomUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 周期执行匹配
 */
@Component
public class MatchingController {
    @Autowired
    MatchingService matchingService;
    @Autowired
    UserService userService;
    @Autowired
    DormitoryService dormitoryService;

    /**
     * 第一阶段匹配
     * 每隔一段时间监测在匹配人数是否达到12
     * 每6分钟 执行任务
     * 测试阶段每15秒一次，4人起步
     */
    //@Scheduled(cron = "0 0/6 * * * ?")
    @Scheduled(cron = "0/15 * * * * ?")
    public void judgeTheNumForCode1() {
        System.out.println("一阶匹配开始");
        //得到处于一阶匹配的用户
        //List<User> users = userService.getUsersByMatchingStatus(1);
        List<String> userIds = userService.getUserIdsByMatchingStatus(1);
        List<String> labelOfUsers = new ArrayList<>();
        int[] faultTimes = new int[userIds.size()];
        //如果总人数大于12，开始一阶匹配
        //if (users.size() >= 12){
        if (userIds.size() >= 4){
            //添加 List<label>
            for (String userId: userIds) {
                assert false;
                labelOfUsers.add(userService.getTagsByUserId(userId));
            }
            //添加匹配失败次数
            for (int i = 0; i < userIds.size(); i++) {
                faultTimes[i] = userService.getMatchingFailedTimesByUserId(userIds.get(i));
            }
            //调用第一阶匹配算法
            code1.init(labelOfUsers, faultTimes);
            System.out.println("****************");
            int[] match = code1.solve();
            System.out.println("****************");
            System.out.println(Arrays.toString(match));
            System.out.println("****************");
            //值为-1 的对应的失败次数+1
            //for (int i = 0; i < 12; i++) {
            for (int i = 0; i < userIds.size(); i++) {
                if (match[i] == -1){
                    String theUserId = userIds.get(i);
                    userService.setMatchingFailedTimesByUserId(theUserId, userService.getMatchingFailedTimesByUserId(theUserId)+1);
                }
            }
            //把匹配的成对存到第二阶的数据库
            int theMatchingId = 0;
            //for (int i = 0; i < 12; i++) {
            for (int i = 0; i < userIds.size(); i++) {
                if (match[i] >= 0){
                    //存入数据库matching表
                    theMatchingId ++;
                    matchingService.createMatchingRole(theMatchingId, userIds.get(i), userService.getTagsByUserId(userIds.get(i)), 0);
                    userService.setIfOnMatchingByUserId(userIds.get(i), 2);//匹配状态设置为2
                    userService.setMatchingFailedTimesByUserId(userIds.get(i), 0);//失败次数归0
                    theMatchingId ++;
                    matchingService.createMatchingRole(theMatchingId, userIds.get(match[i]), userService.getTagsByUserId(userIds.get(match[i])), 0);
                    userService.setIfOnMatchingByUserId(userIds.get(match[i]), 2);//匹配状态设置为2
                    userService.setMatchingFailedTimesByUserId(userIds.get(match[i]), 0);//失败次数归0
                    //历遍过设置为-1
                    match[match[i]] = -1;
                    match[i] = -1;
                }
            }
        }
        System.out.println("一阶匹配结束");
    }

    /**
     * 第二阶段匹配
     * 每隔一段时间监测在匹配人数是否达到24
     * 每6分钟 执行任务
     * 测试阶段每15秒一次，8人起步
     */
    //@Scheduled(cron = "0 0/6 * * * ?")
    @Scheduled(cron = "0/15 * * * * ?")
    public void judgeTheNumForCode2() {
        System.out.println("二阶匹配开始");
        //得到处于二阶匹配的用户
        //List<User> users = userService.getUsersByMatchingStatus(2);
        List<String> userIds = userService.getUserIdsByMatchingStatus(2);
        List<String> labelOfUsers= new ArrayList<>();
        int[] faultTimes = new int[userIds.size()];
        //如果总人数大于24，开始一阶匹配
        //if (users.size() >= 24){
        if (userIds.size() >= 8){
            //添加 List<label>
            for (String userId: userIds) {
                assert false;
                labelOfUsers.add(userService.getTagsByUserId(userId));
            }
            //添加匹配失败次数
            for (int i = 0; i < userIds.size(); i++) {
                faultTimes[i] = userService.getMatchingFailedTimesByUserId(userIds.get(i));
            }
            //调用第二阶匹配算法
            code2.init(labelOfUsers, faultTimes);
            int[] left = code2.solve();//返回长度为12
            System.out.println("****************");
            System.out.println(Arrays.toString(left));
            System.out.println("****************");
            List<String> userIdsOfFailure = new ArrayList<>();//二阶匹配失败者的ID
            int[] faultTimesOfFailure = new int[userIds.size()];//二阶匹配失败者的失败次数
            int numOfFailure = 0;
            //值为 -1 的每对用户的失败次数+1,记录下来
            //for (int i = 0; i < 12; i++) {
            for (int i = 0; i < userIds.size()/2; i++) {
                if (left[i] == -1){
                    //成对的第一个
                    String theUserId1 = userIds.get(2*i);
                    //对应失败次数+1
                    matchingService.setMatchingFailedTimesByUserId(theUserId1, matchingService.getMatchingFailedTimesByUserId(theUserId1)+1);
                    //记录用户ID
                    userIdsOfFailure.add(theUserId1);
                    //记录用户失败次数
                    faultTimesOfFailure[numOfFailure] = matchingService.getMatchingFailedTimesByUserId(theUserId1);//记录用户失败次数
                    numOfFailure ++;
                    //成对的第二个
                    String theUserId2 = userIds.get(2*i+1);
                    //对应失败次数+1
                    matchingService.setMatchingFailedTimesByUserId(theUserId2, matchingService.getMatchingFailedTimesByUserId(theUserId2)+1);
                    //记录用户ID
                    userIdsOfFailure.add(theUserId2);
                    //记录用户失败次数
                    faultTimesOfFailure[numOfFailure] = matchingService.getMatchingFailedTimesByUserId(theUserId2);//记录用户失败次数
                    numOfFailure ++;
                }
            }
            System.out.println("****************");
            System.out.println(faultTimesOfFailure.length);
            System.out.println("****************");
            //把匹配的成对放进宿舍
            //for (int i = 0; i < 12; i++) {
            for (int i = 0; i < userIds.size()/2; i++) {
                if (left[i] >= 0){
                    //产生随机ID
                    int randomId = RandomUtil.getTheRandomDormitoryId();
                    while (dormitoryService.getDormitoryById(randomId) != null){
                        randomId = RandomUtil.getTheRandomDormitoryId();
                    }
                    String thePassword = String.valueOf(randomId);
                    //创建宿舍
                    dormitoryService.created(randomId, thePassword);
                    dormitoryService.setTheDormitoryMate(randomId, 4);
                    //四人加入宿舍
                    userService.joinDormitoryOfUser(userIds.get(2*i), randomId);
                    userService.joinDormitoryOfUser(userIds.get(2*i+1), randomId);
                    userService.joinDormitoryOfUser(userIds.get(2*left[i]), randomId);
                    userService.joinDormitoryOfUser(userIds.get(2*left[i]+1), randomId);
                    //设置四人状态为3
                    userService.setIfOnMatchingByUserId(userIds.get(2*i), 3);
                    userService.setIfOnMatchingByUserId(userIds.get(2*i+1), 3);
                    userService.setIfOnMatchingByUserId(userIds.get(2*left[i]), 3);
                    userService.setIfOnMatchingByUserId(userIds.get(2*left[i]+1), 3);
                    //历遍过设置为-1
                    left[left[i]] = -1;
                    left[i] = -1;
                }
            }
            //清空二阶匹配数据库
            matchingService.deleteAllInf();
            //二阶匹配失败者重新打入数据库
            int theMatchingId = 0;
            for (int i = 0; i < userIdsOfFailure.size()/2; i++) {
                //存入数据库matching表
                //成对打入
                theMatchingId ++;
                matchingService.createMatchingRole(theMatchingId, userIdsOfFailure.get(2*i), labelOfUsers.get(2*i), faultTimesOfFailure[2*i]);
                //userService.setIfOnMatchingByUserId(userIds.get(i), 2);
                theMatchingId ++;
                matchingService.createMatchingRole(theMatchingId, userIdsOfFailure.get(2*i+1), labelOfUsers.get(2*i+1), faultTimesOfFailure[2*i+1]);
                //userService.setIfOnMatchingByUserId(userIds.get(i), 2);
            }
        }
        System.out.println("二阶匹配结束");
    }
}
