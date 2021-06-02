package org.cy.meeting.service;

import org.cy.meeting.mapper.EmployeeMapper;
import org.cy.meeting.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    EmployeeMapper employeeMapper;
    public Employee doLogin(String username, String password){
        Employee employee=employeeMapper.loadEmpByUsername(username);
        System.out.println(employee);
        if (employee == null || !employee.getPassword().equals(password)){
            return null;
        }
        return employee;
    }

    public Integer doReg(Employee employee){
        Employee emp=employeeMapper.loadEmpByUsername(employee.getUsername());
        if(emp != null){
            return -1;
        }
        employee.setRole(1);
        employee.setStatus(0);
        return employeeMapper.doReg(employee);
    }
    public List<Employee> getAllEmps(Integer status) {
        return employeeMapper.getAllEmpsByStatus(status);
    }
    public Integer updatestatus(Integer employeeid, Integer status){
        return employeeMapper.updatestatus(employeeid,status);
    }
    public List<Employee> getAllEmps(Employee employee, Integer page, Integer pageSize){
        page=(page-1)*pageSize;
        return employeeMapper.getAllEmps(employee,page,pageSize);
    }
    public Long getTotal(Employee employee){
        return employeeMapper.getTotal(employee);
    }
    public List<Employee> getEmpsByDepId(Integer depId){
        return employeeMapper.getEmpsByDepId(depId);
    }
}
