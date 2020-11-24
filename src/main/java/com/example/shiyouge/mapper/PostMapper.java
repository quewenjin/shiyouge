package com.example.shiyouge.mapper;

import com.example.shiyouge.bean.Post;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.sql.Timestamp;
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

    /**
     * 设置是否被举报
     * @param postId 帖子ID
     * @param status 状态
     */
    void setThePostIfReported(@Param("postId") int postId, @Param("status") int status);

    /**
     * 得到帖子的举报次数
     * @param postId 帖子ID
     * @return
     */
    int getTheReportTimes(int postId);

    /**
     * 设置帖子的举报次数
     * @param postId 帖子ID
     * @param times 举报次数
     */
    void setTheReportTimes(@Param("postId") int postId, @Param("times") int times);

    /**
     * 得到帖子的举报类型
     * @param postId 帖子ID
     * @return
     */
    String getTheReportTypes(int postId);

    /**
     * 设置帖子的举报类型
     * @param postId 帖子ID
     * @param types 举报类型
     */
    void setTheReportTypes(@Param("postId") int postId, @Param("types") String types);

    /**
     * 创建帖子
     * @param userId 作者ID
     * @param content 内容
     * @param parttiion 分区
     * @param createTime 创建时间
     */
    void createThePost(@Param("userId") String userId, @Param("content") String content,
                         @Param("partition") int parttiion, @Param("createTime") Timestamp createTime);

    /**
     * 删帖
     * @param postId 帖子ID
     * @return 状态：succeed
     */
     int deletePostByPostId(int postId);

    /**
     * 取消举报状态
     * @param postId 帖子ID
     * @return 状态：succeed
     */
    int reportedCancel(int postId);

    /**
     * 得到全部帖子
     * @return 全部帖子
     */
    List<Post> getAllThePosts();
}
