package com.ifox.hgx.mybatis.dao;

import com.ifox.hgx.mybatis.entities.Department;

public interface DepartmentMapper {
    Department getDept(Integer id) ;
    Department getDeptPlus(Integer id) ;

    Department getDeptAndEmpStep(Integer id) ;
}
