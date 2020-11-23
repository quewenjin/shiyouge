package com.example.shiyouge.service;

import com.example.shiyouge.bean.Report;
import com.example.shiyouge.mapper.ReportMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ReportService {
    @Autowired
    ReportMapper reportMapper;

    /**
     * 获得被举报帖子的ID
     * @return 被举报帖子的ID
     */
    public List<Integer> getPostIdOfReport() { return reportMapper.getPostIdOfReport();}

    /**
     * 获得被举报帖子的内容
     * @param postIdOfReport 被举报帖子的ID
     * @return 被举报帖子的内容
     */
    public String getPostContnetByPostId(int postIdOfReport) { return reportMapper.getPostContnetByPostId(postIdOfReport);}

    /**
     * 获得被举报帖子的被举报次数
     * @param postIdOfReport 被举报帖子的ID
     * @return 被举报帖子的次数
     */
    public String getReportTimesByPostId(int postIdOfReport) {return reportMapper.getReportTimesByPostId(postIdOfReport);}

    /**
     * 获得被举报帖子的被举报类型
     * @param postIdOfReport 被举报帖子的ID
     * @return 被举报帖子的举报类型
     */
    public Report getReportTypeByPostId(int postIdOfReport) {return reportMapper.getReportTypeByPostId(postIdOfReport);}
}
