package org.cy.meeting.controller;

import org.cy.meeting.model.Department;
import org.cy.meeting.model.Employee;
import org.cy.meeting.service.DepartmentService;
import org.cy.meeting.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class LoginController {
    @Autowired
    EmployeeService employeeService;
    @Autowired
    DepartmentService departmentService;
    @RequestMapping("/")
    public String login(){
        return "login";
    }
    @RequestMapping("/doLogin")
    public String doLogin(String username, String password, Model model, HttpSession httpSession){
        Employee employee=employeeService.doLogin(username,password);
        if (employee == null){
            model.addAttribute("error","用户名或密码输入错误,登录失败");
            return "forward:/";
        }else{
            if(employee.getStatus() == 0){
                model.addAttribute("error","用户待审批");
                return "forward:/";
            }else if(employee.getStatus() == 2){
                model.addAttribute("error","用户审批未通过");
                return "forward:/";
            }else{
                httpSession.setAttribute("currentuser",employee);
                return "redirect:/notifications";
            }
        }
    }
    @RequestMapping("/register")
    public String register(Model model){
        List<Department> deps=departmentService.getAllDeps();
        model.addAttribute("deps",deps);
        return "register";
    }
    @RequestMapping("/doReg")
    public String doReg(Employee employee, Model model){
        Integer result=employeeService.doReg(employee);
        if (result == 1){
            return "redirect:/";
        }else{
            model.addAttribute("error","注册失败");
            model.addAttribute("employee",employee);
            return "forward:/register";
        }
    }
}
