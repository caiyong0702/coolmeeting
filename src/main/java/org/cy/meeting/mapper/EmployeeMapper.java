package org.cy.meeting.mapper;

import org.apache.ibatis.annotations.Param;
import org.cy.meeting.model.Department;
import org.cy.meeting.model.Employee;
import org.cy.meeting.service.DepartmentService;

import java.util.List;

public interface EmployeeMapper {
    Employee loadEmpByUsername(String username);
    Integer doReg(Employee employee);
    List<Employee> getAllEmpsByStatus(Integer status);
    Integer updatestatus(@Param("employeeid") Integer employeeid, @Param("status") Integer status);
    List<Employee> getAllEmps(@Param("emp") Employee employee, @Param("page") Integer page, @Param("pagesize") Integer pageSize);
    Long getTotal(Employee employee);
    List<Employee> getEmpsByDepId(Integer depId);
}
