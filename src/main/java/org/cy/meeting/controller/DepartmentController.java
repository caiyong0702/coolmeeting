package org.cy.meeting.controller;

import org.cy.meeting.model.Department;
import org.cy.meeting.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin")
public class DepartmentController {
    @Autowired
    DepartmentService departmentService;
    @RequestMapping("/departments")
    public String departments(Model model){
        model.addAttribute("deps",departmentService.getAllDeps());
        return "departments";
    }
    @RequestMapping("/adddepartment")
    public String adddepartment(String departmentname){
        departmentService.adddepartment(departmentname);
        return "redirect:/admin/departments";
    }
    @RequestMapping("/deletedep")
    public String deletedep(Integer departmentid){
        departmentService.deletedep(departmentid);
        return "redirect:/admin/departments";
    }
    @RequestMapping(value = "/updatedep",method = RequestMethod.POST)
    @ResponseBody
    public String updatedep(Integer id, String name){
        Integer result=departmentService.updatedep(id,name);
        if (result == 1){
            return "success";
        }else{
            return "error";
        }
    }
}
