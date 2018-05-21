package com.ifox.hgx.mybatis.dao;

import com.ifox.hgx.mybatis.entities.Employee;

import java.util.List;

public interface EmployeeMapperDynamicSQL {
    List<Employee> getEmpsByConditionIf(Employee employee) ;
    List<Employee> getEmpsByConditionTrim(Employee employee) ;
    List<Employee> getEmpsByConditionChoose(Employee employee) ;
}
