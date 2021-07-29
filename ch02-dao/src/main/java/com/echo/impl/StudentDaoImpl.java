package com.echo.impl;


import com.echo.dao.StudentDao;
import com.echo.domain.Student;
import com.echo.utils.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class StudentDaoImpl implements StudentDao {
    @Override
    public Student selectById(Integer id) {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        String sqlId = "com.echo.dao.StudentDao.selectById";
        Student student = sqlSession.selectOne(sqlId,id);
        sqlSession.close();
        return student;
    }

    @Override
    public List<Student> selectStudents() {
        //1. 获取SqlSession
        SqlSession session = MybatisUtil.getSqlSession();
        //2. 指定sqlId
        String sqlId = "com.echo.dao.StudentDao.selectStudents";
        //3. 执行SqlSession方法，执行sql语句
        List<Student> students = session.selectList(sqlId);
        System.out.println("students===="+students);
        //4. 关闭sqlSession对象
        session.close();
        return students;
    }

    @Override
    public int insertStudent(Student student) {
        //1. 获取SqlSession
        SqlSession session = MybatisUtil.getSqlSession();
        //2. 指定sqlId
        String sqlId = "com.echo.dao.StudentDao.insertStudent";
        //3. 执行SqlSession方法，执行sql语句
        int rows = session.insert(sqlId,student);
        session.commit();
        System.out.println("insert的行数===="+rows);
        //4. 关闭sqlSession对象
        session.close();
        return rows;
    }
}
