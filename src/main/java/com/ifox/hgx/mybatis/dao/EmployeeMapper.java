package com.ifox.hgx.mybatis.dao;

import com.ifox.hgx.mybatis.entities.Employee;
import org.apache.ibatis.annotations.Param;

public interface EmployeeMapper {

    Employee getEmpById(Integer id);

    void addEmp(Employee employee);

    void updateEmp(Employee employee);

    void deleteEmpById(Integer id);

    Employee getEmpByIDAndName(@Param("id") Integer id,@Param("lastName") String lastName
                                ,@Param("tableName") String tableName) ;
}
