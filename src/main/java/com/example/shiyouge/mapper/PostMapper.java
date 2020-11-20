package com.example.shiyouge.mapper;

import com.example.shiyouge.bean.Post;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PostMapper {

    /**
     * 得到某分区所有帖子
     * @param partitionOfPost 分区-->倾诉区=1，互助区=2，告白区=3
     * @return List<Post>
     */
    List<Post> getTheAllPostOfPartition(int partitionOfPost);

    /**
     * 包含某内容的全部帖子
     * @param content 内容
     * @return List<Post>
     */
    List<Post> getThePostsByContent(String content);

    /**
     * 通过帖子ID得到帖子对象
     * @param postId 帖子ID
     * @return Post
     */
    Post getThePostByPostId(int postId);

}
