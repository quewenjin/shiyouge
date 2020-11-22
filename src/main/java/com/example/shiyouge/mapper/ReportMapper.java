package com.example.shiyouge.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ReportMapper {

    /**
     * 得到色情低俗次数
     * @param postId 帖子ID
     * @return 次数
     */
    int getTheVulgarNum(int postId);

    /**
     * 设置色情低俗次数
     * @param postId 帖子ID
     * @param num 次数
     */
    void setTheVulgarNum(@Param("postId") int postId, @Param("num") int num);

    /**
     * 得到政治敏感次数
     * @param postId 帖子ID
     * @return 次数
     */
    int getTheSensitivityNum(int postId);

    /**
     * 设置政治敏感次数
     * @param postId 帖子ID
     * @param num 次数
     */
    void setTheSensitivityNum(@Param("postId") int postId, @Param("num") int num);

    /**
     * 得到违法次数
     * @param postId 帖子ID
     * @return 次数
     */
    int getTheIllegalNum(int postId);

    /**
     * 设置违法次数
     * @param postId 帖子ID
     * @param num 次数
     */
    void setTheIllegalNum(@Param("postId") int postId, @Param("num") int num);

    /**
     * 得到广告次数
     * @param postId 帖子ID
     * @return 次数
     */
    int getTheAdvertisementNum(int postId);

    /**
     * 设置广告次数
     * @param postId 帖子ID
     * @param num 次数
     */
    void setTheAdvertisementNum(@Param("postId") int postId, @Param("num") int num);

    /**
     * 得到病毒木马次数
     * @param postId 帖子ID
     * @return 次数
     */
    int getTheVirusNum(int postId);

    /**
     * 设置病毒木马次数
     * @param postId 帖子ID
     * @param num 次数
     */
    void setTheVirusNum(@Param("postId") int postId, @Param("num") int num);

    /**
     * 得到病毒木马次数
     * @param postId 帖子ID
     * @return 次数
     */
    int getTheOthersNum(int postId);

    /**
     * 设置病毒木马次数
     * @param postId 帖子ID
     * @param num 次数
     */
    void setTheOthersNum(@Param("postId") int postId, @Param("num") int num);
}
