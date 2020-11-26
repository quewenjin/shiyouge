package com.example.shiyouge.controller;

import com.example.shiyouge.Algorithm.code1;
import com.example.shiyouge.Algorithm.code2;
import com.example.shiyouge.bean.User;
import com.example.shiyouge.service.MatchingService;
import com.example.shiyouge.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/matching")
public class MatchingController {
    @Autowired
    MatchingService matchingService;
    @Autowired
    UserService userService;

    /**
     * 第一阶段匹配
     * 每隔一段时间监测在匹配人数是否达到
     */
    @Scheduled(cron = "0 0 0 * * ?")
    public void judgeTheNumForCode1() {
        //得到处于一阶匹配的用户
        List<User> users = userService.getUsersByMatchingStatus(1);
        List<String> labelOfUsers= null;
        int[] faultTimes = new int[users.size()];
        //如果总人数大于12，开始一阶匹配
        if (users.size() >= 12){
            //添加 List<label>
            for (User user: users) {
                assert false;
                labelOfUsers.add(user.getLable());
            }
            //添加匹配失败次数
            for (int i = 0; i < users.size(); i++) {
                faultTimes[i] = users.get(i).getMatchingFailedTimes();
            }
            //调用第一阶匹配算法
            code1.init(labelOfUsers, faultTimes);
            int[] match = code1.solve();
            //值为-1 的对应的失败次数+1
            for (int i = 0; i < 12; i++) {
                if (match[i] == -1){
                    String theUserId = users.get(i).getUserId();
                    userService.setMatchingFailedTimesByUserId(theUserId, userService.getMatchingFailedTimesByUserId(theUserId)+1);
                }
            }
            //把匹配的成对存到第二阶的数据库
            int theMatchingId = 0;
            for (int i = 0; i < 12; i++) {
                if (match[i] >= 0){
                    //存入数据库matching表
                    theMatchingId ++;
                    matchingService.createMatchingRole(theMatchingId, users.get(i).getUserId(), users.get(i).getLable(), 0);
                    userService.setIfOnMatchingByUserId(users.get(i).getUserId(), 2);
                    theMatchingId ++;
                    matchingService.createMatchingRole(theMatchingId, users.get(match[i]).getUserId(), users.get(match[i]).getLable(), 0);
                    userService.setIfOnMatchingByUserId(users.get(i).getUserId(), 2);
                    //历遍过设置为-1
                    match[match[i]] = -1;
                    match[i] = -1;
                }
            }
        }
    }

    /**
     * 第二阶段匹配
     * 每隔一段时间监测在匹配人数是否达到
     */
    @Scheduled(cron = "0 0 0 * * ?")
    public void judgeTheNumForCode2() {
        //得到处于二阶匹配的用户
        List<User> users = userService.getUsersByMatchingStatus(2);
        List<String> labelOfUsers= null;
        int[] faultTimes = new int[users.size()];
        //如果总人数大于24，开始一阶匹配
        if (users.size() >= 24){
            //添加 List<label>
            for (User user: users) {
                assert false;
                labelOfUsers.add(user.getLable());
            }
            //添加匹配失败次数
            for (int i = 0; i < users.size(); i++) {
                faultTimes[i] = users.get(i).getMatchingFailedTimes();
            }
            //调用第二阶匹配算法
            code2.init(labelOfUsers, faultTimes);
            int[] left = code2.solve();//返回长度为12
            List<String> userIdsOfFailure= null;//二阶匹配失败者的ID
            int[] faultTimesOfFailure = new int[users.size()];//二阶匹配失败者的失败次数
            int numOfFailure = 0;
            //值为-1 的对应的失败次数+1,记录下来
            for (int i = 0; i < 12; i++) {
                if (left[i] == -1){
                    //成对的第一个
                    String theUserId1 = users.get(2*i).getUserId();
                    matchingService.setMatchingFailedTimesByUserId(theUserId1, matchingService.getMatchingFailedTimesByUserId(theUserId1)+1);
                    userIdsOfFailure.add(theUserId1);
                    //faultTimesOfFailure
                    //成对的第二个
                    String theUserId2 = users.get(2*i+1).getUserId();
                    matchingService.setMatchingFailedTimesByUserId(theUserId2, matchingService.getMatchingFailedTimesByUserId(theUserId2)+1);
                    userIdsOfFailure.add(theUserId2);
                }
            }
        }
    }
}
