package com.example.shiyouge.service;

import com.example.shiyouge.bean.Report;
import com.example.shiyouge.mapper.ReportMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ReportService {
    @Autowired
    ReportMapper reportMapper;

    /**
     * 更新信息，有的对应 + 1
     * @param postId 帖子ID
     * @param vulgar 色情低俗
     * @param sensitivity 政治敏感
     * @param illegal 违法
     * @param advertisement 广告
     * @param virus 病毒木马
     * @param others 其他
     */
    public void updateTheValueOfReport(int postId, int vulgar, int sensitivity, int illegal, int advertisement, int virus, int others){
        if (vulgar != 0){
            reportMapper.setTheVulgarNum(postId, reportMapper.getTheVulgarNum(postId)+1);
        }
        if (sensitivity != 0){
            reportMapper.setTheSensitivityNum(postId, reportMapper.getTheSensitivityNum(postId)+1);
        }
        if (illegal != 0){
            reportMapper.setTheIllegalNum(postId, reportMapper.getTheIllegalNum(postId)+1);
        }
        if (advertisement != 0){
            reportMapper.setTheAdvertisementNum(postId, reportMapper.getTheAdvertisementNum(postId)+1);
        }
        if (virus != 0){
            reportMapper.setTheVirusNum(postId, reportMapper.getTheVirusNum(postId)+1);
        }
        if (others != 0){
            reportMapper.setTheOthersNum(postId, reportMapper.getTheOthersNum(postId)+1);
        }
    }

    /**
     * 用帖子ID得到举报信息
     * @param postId 帖子ID
     * @return Report对象
     */
    public boolean findTheReportByPostId(int postId){
        Report report = reportMapper.getTheReportByPostId(postId);
        if (report != null){
            return true;
        } else {
            return false;
        }
    }

    /**
     * 创建某帖子的举报记录
     * @param postId 帖子ID
     */
    public void creatTheReportOfPost(int postId){
        reportMapper.creatTheReportOfPost(postId);
    }
}
