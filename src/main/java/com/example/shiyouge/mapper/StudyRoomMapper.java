package com.example.shiyouge.mapper;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface StudyRoomMapper {

    /**
     * 得到自习室人数
     * @param roomId 自习室号
     * @return 人数
     */
    int getThenumberOfStudyRoom(int roomId);
}
