package com.ifox.hgx.mybatis.dao;

import com.ifox.hgx.mybatis.entities.Employee;

import java.util.List;

public interface EmployeeMapperPlus {

    Employee getEmpById(Integer id);

    Employee getEmpAndDept(Integer id);

    Employee getEmpAndDeptByStep(Integer id);

    List<Employee> getEmpsByDeptId(Integer id);
}
