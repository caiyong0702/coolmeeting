package org.cy.meeting.mapper;

import org.cy.meeting.model.MeetingRoom;

import java.util.List;

public interface MeetingRoomMapper {
    List<MeetingRoom> getAllMr();
    MeetingRoom getMrById(Integer roomid);
    Integer updateRoom(MeetingRoom meetingRoom);
    Integer addMr(MeetingRoom meetingRoom);

}
