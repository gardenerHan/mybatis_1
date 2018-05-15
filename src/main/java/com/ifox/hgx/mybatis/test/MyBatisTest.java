package com.ifox.hgx.mybatis.test;

import com.ifox.hgx.mybatis.dao.EmployeeMapper;
import com.ifox.hgx.mybatis.dao.EmployeeMapperAnnotation;
import com.ifox.hgx.mybatis.entities.Employee;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;


import java.io.IOException;
import java.io.InputStream;

public class MyBatisTest {



    private  SqlSessionFactory sqlSessionFactory ;


    @Before
    //SqlSessionFactory实例
    public void getSqlSessionFactory() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }

    @Test
    public void test1() throws IOException {
        //获取Sqlsession实例，能直接执行已经映射的sql语句
        SqlSession openSession = sqlSessionFactory.openSession() ;

        try {
            Employee employee =  openSession.selectOne("com.ifox.hgx.mybatis.dao.EmployeeMapper.getEmpById",1) ;

            System.out.println(employee);

        }finally {
            openSession.close();
        }
    }

    @Test
    public void test2() throws IOException {
        //1.获取SqlSessionFactory对象


        //获取sqlSession对象
        SqlSession openSession = sqlSessionFactory.openSession() ;

        try {
            //获取接口的实现类对象
            EmployeeMapper employeeMapper = openSession.getMapper(EmployeeMapper.class) ;

            Employee employee =  employeeMapper.getEmpById(1) ;

            System.out.println(employeeMapper.getClass());
            System.out.println(employee);
        }

        finally {
            openSession.close();
        }


    }

    //@Select("select * from tab_employee where id = #{id}") 方式
    @Test
    public void test3() throws IOException {
        //1.获取SqlSessionFactory对象


        //获取sqlSession对象
        SqlSession openSession = sqlSessionFactory.openSession() ;

        try {
            //获取接口的实现类对象
            EmployeeMapperAnnotation employeeMapperAnnotation = openSession.getMapper(EmployeeMapperAnnotation.class) ;

            Employee employee =  employeeMapperAnnotation.getEmpById(1) ;

            System.out.println(employeeMapperAnnotation.getClass());
            System.out.println(employee);
        }

        finally {
            openSession.close();
        }


    }

}
