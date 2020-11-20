package com.example.shiyouge.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.shiyouge.bean.Comment;
import com.example.shiyouge.bean.Post;
import com.example.shiyouge.mapper.CommentMapper;
import com.example.shiyouge.mapper.PostMapper;
import com.example.shiyouge.service.CollectService;
import com.example.shiyouge.service.CommentService;
import com.example.shiyouge.service.PostService;
import com.example.shiyouge.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/treeHole")
public class TreeHoleController {
    @Autowired
    PostService postService;
    @Autowired
    UserService userService;
    @Autowired
    CollectService collectService;
    @Autowired
    CommentService commentService;

    /**
     * 得到某分区的所有帖子
     * @return json数组：编号，内容，时间，评论数，收藏数（按时间排序，近期发布在前）
     */
    @RequestMapping(value = "/getPostsOfPartition", method = RequestMethod.POST)
    public String getPostsOfPartition(@RequestBody Map<String, Object> params) {
        int partition = Integer.parseInt(params.get("partition").toString());
        JSONObject json = new JSONObject();
        if (partition!=1 && partition!=2 && partition!=3){
            json.put("status", "wrong");
            return json.toString();
        } else {
            json.put("status", "succeed");
            JSONArray jsonArray = new JSONArray();
            List<Post> posts = postService.getAllPostOfPartition(partition);
            for (Post post: posts) {
                JSONObject jo = new JSONObject();
                jo.put("postId", post.getPostId());
                jo.put("postContent", post.getPostContent());
                jo.put("publishTime", post.getPublishTime());
                jo.put("commentedTimes", post.getCommentedTimes());
                jo.put("collectedTimes", post.getCollectedTimes());
                jsonArray.add(jo);
            }
            json.put("posts", jsonArray);
            return json.toString();
        }
    }

    /**
     * 查询包含某内容的全部帖子
     * @return json数组：编号，内容，时间，评论数，收藏数（按时间排序，近期发布在前）
     */
    @RequestMapping(value = "/getPostsByContent", method = RequestMethod.POST)
    public String getPostsByContent(@RequestBody Map<String, Object> params) {
        String content = params.get("content").toString();
        JSONArray jsonArray = new JSONArray();
        List<Post> posts = postService.getPostsByContent(content);
        for (Post post: posts) {
            JSONObject jo = new JSONObject();
            jo.put("postId", post.getPostId());
            jo.put("postContent", post.getPostContent());
            jo.put("publishTime", post.getPublishTime());
            jo.put("commentedTimes", post.getCommentedTimes());
            jo.put("collectedTimes", post.getCollectedTimes());
            jsonArray.add(jo);
        }
        return jsonArray.toString();
    }

    /**
     * 查看帖子详细内容及评论
     * @return json对象：作者昵称，用户对该帖子是否收藏，评论的json数组
     */
    @RequestMapping(value = "/postDetail", method = RequestMethod.POST)
    public String postDetail(@RequestBody Map<String, Object> params) {
        String userId = params.get("userId").toString();
        int postId = Integer.parseInt(params.get("postId").toString());
        //得到对应的Post对象
        Post post = postService.getPostByPostId(postId);
        JSONObject json = new JSONObject();
        json.put("nicknameOfAuthor", userService.getNickNameByUserId(post.getUserIdOfPost()));
        //是否收藏，是则 1，否则 0
        json.put("ifCollect", collectService.ifUserCollectPost(userId, postId));
        //评论的json数组
        JSONArray jsonArray = new JSONArray();
        List<Comment> commments = commentService.getAllCommentsByPostId(postId);
        for (Comment comment: commments) {
            JSONObject jo = new JSONObject();
            jo.put("commentTime", comment.getCommentTime());
            jo.put("commentContent", comment.getCommentContent());
            jsonArray.add(jo);
        }
        json.put("comments", jsonArray);
        return json.toString();
    }

    /**
     * 用户写评论
     * @param params 用户ID + 帖子ID + 评论内容
     * @return 状态：created
     */
    @RequestMapping(value = "/createComment", method = RequestMethod.POST)
    public String createComment(@RequestBody Map<String, Object> params) {
        String userId = params.get("userId").toString();
        int postId = Integer.parseInt(params.get("postId").toString());
        String content = params.get("content").toString();
        Date date = new Date();
        Timestamp createTime =  new Timestamp(date.getTime());
        //在数据库创建评论信息
        commentService.createTheNewComment(userId, postId, content, createTime);
        JSONObject json = new JSONObject();
        json.put("status", "created");
        return json.toString();
    }

    /**
     * 用户写帖子
     * @param params 用户ID + 评论内容 + 分区
     * @return 状态：created
     */
    @RequestMapping(value = "/createPost", method = RequestMethod.POST)
    public String createPost(@RequestBody Map<String, Object> params) {
        String userId = params.get("userId").toString();
        String content = params.get("content").toString();
        int partition = Integer.parseInt(params.get("partition").toString());
        Date date = new Date();
        Timestamp createTime =  new Timestamp(date.getTime());
        //在数据库创建评论
        postService.createThePost(userId, content, partition, createTime);
        JSONObject json = new JSONObject();
        json.put("status", "created");
        return json.toString();
    }

}
