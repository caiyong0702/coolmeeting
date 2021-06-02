package org.cy.meeting.controller;

import org.cy.meeting.model.MeetingRoom;
import org.cy.meeting.service.MeetingRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MeetingRoomController {
    @Autowired
    private MeetingRoomService meetingRoomService;
    @RequestMapping("/meetingrooms")
    public String meetingroomes(Model model){
        model.addAttribute("mrs",meetingRoomService.getAllMr());
        return "meetingrooms";
    }
    @RequestMapping("/roomdetails")
    public String roomdetails(Integer roomid, Model model){
        model.addAttribute("mr",meetingRoomService.getMrById(roomid));
        return "roomdetails";
    }
    @RequestMapping(value = "/updateroom",method = RequestMethod.POST)
    public String updateRoom(MeetingRoom meetingRoom){
        Integer result=meetingRoomService.updateRoom(meetingRoom);
        if (result == 1) {
            return "redirect:/meetingrooms";
        }else{
            return "forward:/roomdetails";
        }
    }
    @RequestMapping("/admin/addmeetingroom")
    public String addmeetingroom(){
        return "addmeetingroom";
    }
    @RequestMapping("/admin/doAddMr")
    public String doAddMr(MeetingRoom meetingRoom){
        Integer result=meetingRoomService.addMr(meetingRoom);
        return "redirect:/meetingrooms";
    }
}
