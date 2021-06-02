package org.cy.meeting.mapper;

import org.apache.ibatis.annotations.Param;
import org.cy.meeting.model.Department;

import java.util.List;

public interface DepartmentMapper {

    public Department getDepById(Integer id);

    List<Department> getAllDeps();

    Integer adddepartment(String departmentname);

    Integer deletedep(Integer departmentid);

    Integer updatedep(@Param("id")Integer id, @Param("name")String name);

}
