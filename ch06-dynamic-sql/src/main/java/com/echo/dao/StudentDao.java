package com.echo.dao;

import com.echo.domain.Student;
import com.echo.vo.CustomObject;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface StudentDao {
    //if
    List<Student> selectIf(Student student);
}
