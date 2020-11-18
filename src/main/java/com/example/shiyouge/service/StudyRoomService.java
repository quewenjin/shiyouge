package com.example.shiyouge.service;

import com.example.shiyouge.mapper.StudyRoomMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class StudyRoomService {
    @Autowired
    StudyRoomMapper studyRoomMapper;

    /**
     * 得到自习室人数
     * @param roomId 自习室号
     * @return 人数
     */
    public int getnumberOfStudyRoom(int roomId){
        return studyRoomMapper.getThenumberOfStudyRoom(roomId);
    }
}
