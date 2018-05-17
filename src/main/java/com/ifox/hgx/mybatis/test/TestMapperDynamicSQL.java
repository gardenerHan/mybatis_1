package com.ifox.hgx.mybatis.test;

import com.ifox.hgx.mybatis.dao.EmployeeMapperDynamicSQL;
import com.ifox.hgx.mybatis.entities.Employee;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class TestMapperDynamicSQL {

    private SqlSessionFactory sqlSessionFactory ;

    @Before
    //SqlSessionFactory实例
    public void getSqlSessionFactory() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }

    @Test
    public void testGetEmpsByConditionIf(){
        SqlSession  openSession = sqlSessionFactory.openSession(true) ;

        try {
            EmployeeMapperDynamicSQL mapperDynamicSQL = openSession.getMapper(EmployeeMapperDynamicSQL.class) ;

            Employee employee = new Employee() ;
//        employee.setId(1);

            employee.setLastName("%h%") ;
           // List list = mapperDynamicSQL.getEmpsByConditionIf(employee) ;
            List list = mapperDynamicSQL.getEmpsByConditionTrim(employee) ;
            System.out.println(list);
        }finally {
            openSession.close();
        }

    }
}
