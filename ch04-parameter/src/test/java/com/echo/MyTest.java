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
    public void testOneParameter(){
        SqlSession session = MybatisUtil.getSqlSession();
        StudentDao dao = session.getMapper(StudentDao.class);
        Student student = dao.selectByEmail("zhangfei@qq.com");
        System.out.println("查询的结果====" + student);
        session.close();
    }

    @Test
    public void testSelectByNameOrAge(){
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        List<Student> students = dao.selectByNameOrAge("李四", 26);
        students.forEach(student -> System.out.println("student==" + student));
        sqlSession.close();
    }

    @Test
    public void testSelectByObject(){
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        Student student = new Student();
        student.setName("李思思");
        student.setAge(22);
        List<Student> students = dao.selectByObject(student);
        students.forEach(stu -> System.out.println("student==" + stu));
        sqlSession.close();
    }

    @Test
    public void testSelectByPosition(){
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        List<Student> students = dao.selectByPosition("李思思",22);
        students.forEach(stu -> System.out.println("student==" + stu));
        sqlSession.close();
    }

    @Test
    public void testQueryStudent(){
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        List<Student> students = dao.queryStudent("'李四'");
        students.forEach(student -> System.out.println("student==" + student));
        sqlSession.close();
    }

    @Test
    public void testQueryStudentOrderByColName(){
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        List<Student> students = dao.queryStudentOrderByColName("id");
        students.forEach(student -> System.out.println("student==" + student));
        sqlSession.close();
    }
}
