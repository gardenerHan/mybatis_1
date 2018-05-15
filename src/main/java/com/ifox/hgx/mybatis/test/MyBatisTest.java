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

    @Test
    public void testCRUD(){

        //获取Sqlsession对象,使用的openSession不带参数，不会自动提交
        SqlSession openSession = sqlSessionFactory.openSession(true) ;

        try {
            EmployeeMapper employeeMapper = openSession.getMapper(EmployeeMapper.class) ;

            //查找
            //Employee employee = employeeMapper.getEmpById(1) ;
            //System.out.println(employee);

            //增加
//            Employee employee = new Employee("hhh","hhh@qq.com","女") ;
//            System.out.println(employee);
//            employeeMapper.addEmp(employee);
//            System.out.println(employee);

            //修改
//            Employee employee = new Employee(1,"hgx_1","hgx_1@qq.com","男") ;
//            employeeMapper.updateEmp(employee);

            //删除
//                employeeMapper.deleteEmpById(2);
            //手动提交数据
            //openSession.commit();

            Employee e = employeeMapper.getEmpByIDAndName(1,"hgx_1") ;
            System.out.println(e);
        }finally {
            openSession.close();
        }



    }

}
