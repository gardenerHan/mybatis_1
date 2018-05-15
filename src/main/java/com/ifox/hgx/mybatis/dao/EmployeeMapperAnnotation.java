package com.ifox.hgx.mybatis.dao;

import com.ifox.hgx.mybatis.entities.Employee;
import org.apache.ibatis.annotations.Select;

public interface EmployeeMapperAnnotation {

    @Select("select * from tab_employee where id = #{id}")
    Employee getEmpById(Integer id) ;
}
