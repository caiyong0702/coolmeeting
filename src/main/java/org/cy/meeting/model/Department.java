package org.cy.meeting.model;

public class Department {
    private Integer departmentid;
    private String departmentname;

    public Integer getDepartmentid() {
        return departmentid;
    }

    public String getDepartmentname() {
        return departmentname;
    }

    public void setDepartmentid(Integer departmentid) {
        this.departmentid = departmentid;
    }

    public void setDepartmentname(String departmentname) {
        this.departmentname = departmentname;
    }

    @Override
    public String toString() {
        return "Department{" +
                "departmentid=" + departmentid +
                ", departmentname='" + departmentname + '\'' +
                '}';
    }
}
