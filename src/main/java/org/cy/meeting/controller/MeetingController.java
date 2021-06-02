package org.cy.meeting.controller;

import org.cy.meeting.model.Department;
import org.cy.meeting.model.Employee;
import org.cy.meeting.service.DepartmentService;
import org.cy.meeting.service.EmployeeService;
import org.cy.meeting.service.MeetingRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class MeetingController {
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private DepartmentService departmentService;
    @Autowired
    private MeetingRoomService meetingRoomService;
    @RequestMapping("/bookmeeting")
    public String bookmeeting(Model model){
        model.addAttribute("mrs",meetingRoomService.getAllMr());
        return "bookmeeting";
    }
    @RequestMapping("/alldeps")
    @ResponseBody
    public List<Department> getAllDeps(){
        return departmentService.getAllDeps();
    }
    @RequestMapping("/getempbydepid")
    @ResponseBody
    public List<Employee> getEmpsByDepId(Integer depId){
        return employeeService.getEmpsByDepId(depId);
    }
}
