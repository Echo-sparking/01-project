package com.echo;

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
        //2. 指定sqlId
        String sqlId = "com.echo.dao.StudentDao" +"."+ "selectById";
        //3. 执行SqlSession方法，执行sql语句
        Student student = session.selectOne(sqlId,1001);
        System.out.println("查询的结果===="+student);
        //4. 关闭sqlSession对象
        session.close();
    }

    @Test
    public void testSelectStudents(){
        //1. 获取SqlSession
        SqlSession session = MybatisUtil.getSqlSession();
        //2. 指定sqlId
        String sqlId = "com.echo.dao.StudentDao" +"."+ "selectStudents";
        //3. 执行SqlSession方法，执行sql语句
        List<Student> students = session.selectList(sqlId);
        System.out.println("查询的结果===="+students);
        //4. 关闭sqlSession对象
        session.close();
    }

    @Test
    public void testInsertStudent(){
        //1. 获取SqlSession
        SqlSession session = MybatisUtil.getSqlSession();
        //2. 指定sqlId
        String sqlId = "com.echo.dao.StudentDao" +"."+ "insertStudent";
        //3. 执行SqlSession方法，执行sql语句
        Student student = new Student();
        student.setId(1007);
        student.setName("东皇");
        student.setEmail("donghuan@qq.com");
        student.setAge(26);
        int rows = session.insert(sqlId,student);
        session.commit();
        System.out.println("insert的行数===="+rows);
        //4. 关闭sqlSession对象
        session.close();
    }
}
