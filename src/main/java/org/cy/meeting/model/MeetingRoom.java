package org.cy.meeting.model;

public class MeetingRoom {
    private Integer roomid;
    private Integer roomnum;
    private String roomname;
    private Integer capacity;
    private Integer status;
    private String description;

    public void setRoomid(Integer roomid) {
        this.roomid = roomid;
    }

    public void setRoomnum(Integer roomnum) {
        this.roomnum = roomnum;
    }

    public void setRoomname(String roomname) {
        this.roomname = roomname;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getRoomid() {
        return roomid;
    }

    public Integer getRoomnum() {
        return roomnum;
    }

    public String getRoomname() {
        return roomname;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public Integer getStatus() {
        return status;
    }

    public String getDescription() {
        return description;
    }
}
