package com.example.shiyouge.service;

import com.example.shiyouge.bean.Collect;
import com.example.shiyouge.mapper.CollectMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CollectService {
    @Autowired
    CollectMapper collectMapper;

    /**
     * 确定某用户是否收藏了某帖子
     * @param userId 用户ID
     * @param postId 帖子ID
     * @return 是则返回 1，否则返回 0
     */
    public int ifUserCollectPost(String userId, int postId){
        Collect collect = collectMapper.getTheCollectByUserIdAndPostId(userId, postId);
        if (collect != null){
            return 1;
        } else {
            return 0;
        }
    }

    /**
     * 得到用户收藏的所有帖子的ID
     * @param userId ID
     * @return 帖子ID
     */
    public List<Integer> getThePostIdOfCollect(String userId){
        return collectMapper.getThePostIdOfCollect(userId);
    }

    /**
     * 收藏帖子
     * @param userId ID
     * @param postId ID
     */
    public void createCollection(String userId, int postId){
        collectMapper.createCollection(userId, postId);
    }

    /**
     * 取消收藏
     * @param userId ID
     * @param postId ID
     */
    public void cancelCollection(String userId, int postId){
        collectMapper.cancelCollection(userId, postId);
    }
}
