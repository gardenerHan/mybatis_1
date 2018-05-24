package com.ifox.hgx.mybatis.dao;

import com.ifox.hgx.mybatis.entities.Employee;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface EmployeeMapper {

    Employee getEmpById(Integer id);

    void addEmp(Employee employee);

    void updateEmp(Employee employee);

    void deleteEmpById(Integer id);

    Employee getEmpByIDAndName(@Param("id") Integer id,@Param("lastName") String lastName
                                ,@Param("tableName") String tableName) ;

    List<Employee> getEmpsByLastName(String lastName) ;

    //返回一条记录的map:key就是列名，值就是对应的值
    Map<String,Object> getEmpByIdReturnMap(Integer id) ;

    //多条封装map,主键为id，值为javaBean
    @MapKey("id")
    Map<Integer,Employee> getEmpByLastNameReturnMap(String lastName ) ;

    List<Employee> getAll() ;
}
