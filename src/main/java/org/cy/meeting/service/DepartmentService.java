package org.cy.meeting.service;

import org.cy.meeting.mapper.DepartmentMapper;
import org.cy.meeting.model.Department;
import org.cy.meeting.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {
    @Autowired
    DepartmentMapper departmentMapper;
    public Department getDepById(Integer id){
        return departmentMapper.getDepById(id);
    }
    public List<Department> getAllDeps(){
        return departmentMapper.getAllDeps();
    }
    public Integer adddepartment(String departmentname){
        return departmentMapper.adddepartment(departmentname);
    }
    public Integer deletedep(Integer departmentid){
        return departmentMapper.deletedep(departmentid);
    }
    public Integer updatedep(Integer id, String name){
        return departmentMapper.updatedep(id,name);
    }
}
