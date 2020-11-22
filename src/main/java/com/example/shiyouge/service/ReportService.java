package com.example.shiyouge.service;

import com.example.shiyouge.mapper.ReportMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ReportService {
    @Autowired
    ReportMapper reportMapper;

    public void updateTheValueOfReport(int postId,
                                       int vulgar, int sensitivity, int illegal, int advertisement, int virus, int others){
        reportMapper.setTheVulgarNum(postId, reportMapper.getTheVulgarNum(postId)+1);
        reportMapper.setTheSensitivityNum(postId, reportMapper.getTheSensitivityNum(postId)+1);
        reportMapper.setTheIllegalNum(postId, reportMapper.getTheIllegalNum(postId)+1);
        reportMapper.setTheAdvertisementNum(postId, reportMapper.getTheAdvertisementNum(postId)+1);
        reportMapper.setTheVirusNum(postId, reportMapper.getTheVirusNum(postId)+1);
        reportMapper.setTheOthersNum(postId, reportMapper.getTheOthersNum(postId)+1);
    }
}
