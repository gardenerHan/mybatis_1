package com.ifox.hgx.mybatis.dao;

import com.ifox.hgx.mybatis.entities.Employee;

public interface EmployeeMapperPlus {

    Employee getEmpById(Integer id) ;

    Employee getEmpAndDept(Integer id) ;

    Employee getEmpAndDeptByStep(Integer id) ;
}
