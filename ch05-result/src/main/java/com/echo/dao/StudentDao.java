package com.echo.dao;

import com.echo.domain.Student;
import com.echo.vo.CustomObject;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface StudentDao {
    Student selectById(Integer id);

    CustomObject selectById2(@Param(value = "sid") Integer id);

    long CountStudent();

    Map<Object, Object> selectMap(@Param(value = "stuid") Integer id);

    List<Student> selectLikeOne(@Param("name") String name);
}
