package org.cy.meeting.controller;

import org.cy.meeting.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class ApproveController {
    public static final Integer pending_approve=0;
    @Autowired
    EmployeeService employeeService;
    @RequestMapping("/approveaccount")
    public String approveaccount(Model model){
        model.addAttribute("emps",employeeService.getAllEmps(pending_approve));
        System.out.println("test git first");
        System.out.println("test git second");
        System.out.println("test git third");
        System.out.println("test git forth");
        return "approveaccount";
    }
    @RequestMapping("/updatestatus")
    public String approve(Integer employeeid, Integer status){
        Integer result=employeeService.updatestatus(employeeid,status);
        return "redirect:/admin/approveaccount";
    }
}
