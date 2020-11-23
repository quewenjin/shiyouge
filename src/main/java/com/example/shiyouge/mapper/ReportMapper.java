package com.example.shiyouge.mapper;

import com.example.shiyouge.bean.Report;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ReportMapper {

    /**
     * 获得被举报帖子的ID
     * @return 被举报帖子的ID
     */
    List<Integer> getPostIdOfReport();

    /**
     * 获得被举报帖子的内容
     * @param postIdOfReport 被举报帖子的ID
     * @return 被举报帖子的内容
     */
    String getPostContnetByPostId(int postIdOfReport);

    /**
     * 获得被举报帖子的被举报次数
     * @param postIdOfReport 被举报帖子的ID
     * @return 被举报帖子的次数
     */
    String getReportTimesByPostId(int postIdOfReport);

    /**
     * 获得被举报帖子的被举报类型
     * @param postIdOfReport 被举报帖子的ID
     * @return 被举报帖子的举报类型
     */
    Report getReportTypeByPostId(int postIdOfReport);
}
