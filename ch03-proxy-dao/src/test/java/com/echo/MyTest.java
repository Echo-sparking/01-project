package com.echo;

import com.echo.dao.StudentDao;
import com.echo.domain.Student;
import com.echo.utils.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class MyTest {
    @Test
    public void testSelectById(){
        //1. 获取SqlSession
        SqlSession session = MybatisUtil.getSqlSession();
        //2. 获取dao代理
        StudentDao dao = session.getMapper(StudentDao.class);
        Student student = dao.selectById(1001);
        System.out.println("查询的结果===="+student);
        //3. 关闭sqlSession对象
        session.close();
    }

    @Test
    public void testSelectStudents(){
        //1. 获取SqlSession
        SqlSession session = MybatisUtil.getSqlSession();
        //2. 获取dao代理
        StudentDao dao = session.getMapper(StudentDao.class);
        List<Student> students = dao.selectStudents();
        students.forEach(student -> System.out.println("student: " + student));
        //3. 关闭sqlSession对象
        session.close();
    }

}
