package com.example.shiyouge.mapper;

import com.example.shiyouge.bean.Collect;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface CollectMapper {

    /**
     * 通过用户ID和帖子ID确定收藏关系
     * @param userId 用户ID
     * @param postId 帖子ID
     * @return Collect
     */
    Collect getTheCollectByUserIdAndPostId(@Param("userId") String userId, @Param("postId") int postId);

}
