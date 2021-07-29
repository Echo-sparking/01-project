package com.echo;

import com.echo.dao.StudentDao;
import com.echo.domain.Student;
import com.echo.utils.MybatisUtil;
import com.echo.vo.CustomObject;
import com.echo.vo.ProvinceCity;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;
import java.util.Map;

public class MyTest {
    @Test
    public void testSelectById(){
        //1. 获取SqlSession
        SqlSession session = MybatisUtil.getSqlSession();
        //2. 获取dao代理
        StudentDao dao = session.getMapper(StudentDao.class);
        Student student = new Student();
        /*student.setName("李四");
        student.setAge(26);*/
        student.setName("李四");
        List<Student> students = dao.selectIf(student);
        students.forEach(student1 -> System.out.println("student1==" + student1));
        //3. 关闭sqlSession对象
        session.close();
    }
}
