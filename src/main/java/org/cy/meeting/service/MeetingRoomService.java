package org.cy.meeting.service;

import org.cy.meeting.mapper.MeetingRoomMapper;
import org.cy.meeting.model.MeetingRoom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MeetingRoomService {
    @Autowired
    private MeetingRoomMapper meetingRoomMapper;
    public List<MeetingRoom> getAllMr(){
        return meetingRoomMapper.getAllMr();
    }
    public MeetingRoom getMrById(Integer roomid){
        return meetingRoomMapper.getMrById(roomid);
    }
    public Integer updateRoom(MeetingRoom meetingRoom){
        return meetingRoomMapper.updateRoom(meetingRoom);
    }
    public Integer addMr(MeetingRoom meetingRoom){
        return meetingRoomMapper.addMr(meetingRoom);
    }
}
