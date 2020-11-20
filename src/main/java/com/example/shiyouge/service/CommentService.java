package com.example.shiyouge.service;

import com.example.shiyouge.bean.Comment;
import com.example.shiyouge.mapper.CommentMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.List;

@Service
@Transactional
public class CommentService {
    @Autowired
    CommentMapper commentMapper;

    /**
     * 得到某帖子的全部评论，先评论的在前
     * @param postId 帖子ID
     * @return List<Commment>
     */
    public List<Comment> getAllCommentsByPostId(int postId){
        return commentMapper.getTheAllCommentsByPostId(postId);
    }

    /**
     * 创建评论信息
     * @param userId 用户ID
     * @param postId 帖子ID
     * @param content 评论内容 300字内
     */
    public void createTheNewComment(String userId, int postId, String content, Timestamp commentTime){
        commentMapper.createTheNewComment(userId, postId, content, commentTime);
    }
}
