package com.echo;

import com.echo.dao.StudentDao;
import com.echo.domain.Student;
import com.echo.impl.StudentDaoImpl;
import org.junit.Test;

import java.util.List;

public class MyTest2 {
    @Test
    public void testSelectOne(){
        //要使用dao的方法
        //接口类型 变量=new 接口的实现类();
        StudentDao dao = new StudentDaoImpl();
        Student student = dao.selectById(1002);
        System.out.println("通过dao执行方法，得到的对象====" + student);

    }
    @Test
    public void testSelectStudents(){
        //要使用dao的方法
        //接口类型 变量=new 接口的实现类();
        StudentDao dao = new StudentDaoImpl();
        List<Student> students = dao.selectStudents();
        students.forEach(student -> System.out.println("student = " + student));
    }

    @Test
    public void testInsertStudent(){
        StudentDao dao = new StudentDaoImpl();
        Student student = new Student();
        student.setId(1008);
        student.setName("周强");
        student.setEmail("zhouqiang@qq.com");
        student.setAge(27);
        int rows = dao.insertStudent(student);
        System.out.println("通过dao执行方法，影响的行数====" + rows);
    }
}
