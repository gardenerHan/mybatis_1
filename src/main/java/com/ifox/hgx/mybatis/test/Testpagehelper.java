package com.ifox.hgx.mybatis.test;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.ifox.hgx.mybatis.dao.EmployeeMapper;
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

public class Testpagehelper {

    private SqlSessionFactory sqlSessionFactory;

    @Before
    //SqlSessionFactory实例
    public void getSqlSessionFactory() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }

    @Test
    public void testPagehelper(){
        SqlSession openSession = sqlSessionFactory.openSession(true) ;
        EmployeeMapper employeeMapper = openSession.getMapper(EmployeeMapper.class) ;
        Page<Object> page = PageHelper.startPage(1,3) ;
        System.out.println("总的条数:"+page.getTotal());
        List<Employee> employees = employeeMapper.getAll() ;
        for (Employee e:
             employees) {
            System.out.println(e);
        }
        System.out.println("总的条数:"+page.getTotal());
        System.out.println("总的页数:"+page.getPages());

    }
}
