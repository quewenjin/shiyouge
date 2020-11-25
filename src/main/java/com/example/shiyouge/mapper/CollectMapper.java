package com.example.shiyouge.mapper;

import com.example.shiyouge.bean.Collect;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CollectMapper {

    /**
     * 通过用户ID和帖子ID确定收藏关系
     * @param userId 用户ID
     * @param postId 帖子ID
     * @return Collect
     */
    Collect getTheCollectByUserIdAndPostId(@Param("userId") String userId, @Param("postId") int postId);

    /**
     * 得到用户收藏的所有帖子的ID
     * @param userId ID
     * @return 帖子ID
     */
    List<Integer> getThePostIdOfCollect(String userId);

    /**
     * 收藏帖子
     * @param userId ID
     * @param postId ID
     */
    void createCollection(@Param("userId") String userId, @Param("postId") int postId);

    /**
     * 取消收藏
     * @param userId ID
     * @param postId ID
     */
    void cancelCollection(@Param("userId") String userId, @Param("postId") int postId);
}
