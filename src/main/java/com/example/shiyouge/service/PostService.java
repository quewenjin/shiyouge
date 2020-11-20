package com.example.shiyouge.service;

import com.example.shiyouge.bean.Post;
import com.example.shiyouge.mapper.PostMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
}
