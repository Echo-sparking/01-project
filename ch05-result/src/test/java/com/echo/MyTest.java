package com.echo;

import com.echo.dao.ProvinceDao;
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
        Student student = dao.selectById(1001);
        System.out.println("查询的结果===="+student);
        //3. 关闭sqlSession对象
        session.close();
    }

    @Test
    public void testSelectById2(){
        //1. 获取SqlSession
        SqlSession session = MybatisUtil.getSqlSession();
        //2. 获取dao代理
        StudentDao dao = session.getMapper(StudentDao.class);
        CustomObject co = dao.selectById2(1003);
        System.out.println("查询的结果===="+co);
        //3. 关闭sqlSession对象
        session.close();
    }

    @Test
    public void testCountStudent(){
        //1. 获取SqlSession
        SqlSession session = MybatisUtil.getSqlSession();
        //2. 获取dao代理
        StudentDao dao = session.getMapper(StudentDao.class);
        long nums = dao.CountStudent();
        System.out.println("nums = " + nums);
        //3. 关闭sqlSession对象
        session.close();
    }

    @Test
    public void testSelectMap(){
        //1. 获取SqlSession
        SqlSession session = MybatisUtil.getSqlSession();
        //2. 获取dao代理
        StudentDao dao = session.getMapper(StudentDao.class);
        Map<Object, Object> map = dao.selectMap(1003);
        System.out.println("map==="+ map);
        //3. 关闭sqlSession对象
        session.close();

        System.out.println("id=" + map.get("id"));
        System.out.println("name="+ map.get("name"));
    }

    @Test
    public void testSelectProvinceCityList(){
        //1. 获取SqlSession
        SqlSession session = MybatisUtil.getSqlSession();
        //2. 获取dao代理
        ProvinceDao dao = session.getMapper(ProvinceDao.class);
        List<ProvinceCity> pcs = dao.selectProvinceCityList(1);
        pcs.forEach(pc -> System.out.println(pc));
        //3. 关闭sqlSession对象
        session.close();
    }

    @Test
    public void testSelectLikeOne(){
        SqlSession session = MybatisUtil.getSqlSession();
        StudentDao dao = session.getMapper(StudentDao.class);
        String name = "%李%";
        List<Student> students = dao.selectLikeOne(name);
        session.close();
        students.forEach(stu-> System.out.println(stu));
    }
}
