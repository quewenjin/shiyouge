package com.example.shiyouge.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface StudyRoomMapper {

    /**
     * 得到自习室人数
     * @param roomId 自习室号
     * @return 人数
     */
    int getThenumberOfStudyRoom(int roomId);

    /**
     * 更新自习室人数
     * @param roomId 自习室号
     * @param numberOfStudy 人数
     */
    void updateThenumberOfStudyRoom(@Param("roomId") int roomId, @Param("numberOfStudy") int numberOfStudy);
}
