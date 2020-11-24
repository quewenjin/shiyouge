package com.example.shiyouge.service;

import com.example.shiyouge.bean.Post;
import com.example.shiyouge.mapper.PostMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import java.sql.Timestamp;
import java.util.List;

@Service
@Transactional
public class PostService {
    @Autowired
    PostMapper postMapper;

    /**
     * 得到某分区所有帖子
     * @param partitionOfPost 分区-->倾诉区=1，互助区=2，告白区=3
     * @return List<Post>
     */
    public List<Post> getAllPostOfPartition(int partitionOfPost){
        return postMapper.getTheAllPostOfPartition(partitionOfPost);
    }

    /**
     * 包含某内容的全部帖子
     * @param content 内容
     * @return List<Post>
     */
    public List<Post> getPostsByContent(String content){
        return postMapper.getThePostsByContent(content);
    }

    /**
     * 通过帖子ID得到帖子对象
     * @param postId 帖子ID
     * @return Post
     */
    public Post getPostByPostId(int postId){
        return postMapper.getThePostByPostId(postId);
    }

    /**
     * 设置是否被举报
     * @param postId 帖子ID
     * @param status 状态
     */
    public void setThePostIfReported(int postId, int status){
        postMapper.setThePostIfReported(postId, status);
    }

    /**
     * 得到帖子的举报次数
     * @param postId 帖子ID
     * @return
     */
    public int getReportTimes(int postId){
        return postMapper.getTheReportTimes(postId);
    }

    /**
     * 设置帖子的举报次数
     * @param postId 帖子ID
     * @param times 举报次数
     */
    public void setReportTimes(int postId, int times){
        postMapper.setTheReportTimes(postId, times);
    }

    /**
     * 创建帖子
     * @param userId 作者ID
     * @param content 内容
     * @param parttiion 分区
     * @param createTime 创建时间
     */
    public void createThePost(String userId, String content, int parttiion, Timestamp createTime){
        postMapper.createThePost(userId, content, parttiion, createTime);
    }

    /**
     * 删帖
     * @param postId 帖子ID
     * @return 状态：succeed
     */
    public int deletePostByPostId(int postId) {return postMapper.deletePostByPostId(postId);}

    /**
     * 取消举报状态
     * @param postId 帖子ID
     * @return 状态：succeed
     */
    public int reportedCancel(int postId) {return postMapper.reportedCancel(postId);}

    /**
     * 得到全部帖子
     * @return 全部帖子
     */
    public List<Post> getAllThePosts(){
        return postMapper.getAllThePosts();
    }
}
