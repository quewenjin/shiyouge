package com.example.shiyouge.mapper;

import com.example.shiyouge.bean.Comment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.sql.Timestamp;
import java.util.List;

@Mapper
public interface CommentMapper {

    /**
     * 得到某帖子的全部评论，先评论的在前
     * @param postId 帖子ID
     * @return List<Commment>
     */
    List<Comment> getTheAllCommentsByPostId(int postId);

    /**
     * 创建评论信息
     * @param userId 用户ID
     * @param postId 帖子ID
     * @param content 评论内容 300字内
     * @param commentTime 评论时间
     */
    void createTheNewComment(@Param("userId") String userId, @Param("postId") int postId,
                             @Param("content") String content, @Param("commentTime") Timestamp commentTime);
}
