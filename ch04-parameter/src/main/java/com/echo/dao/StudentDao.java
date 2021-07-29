package com.echo.dao;

import com.echo.domain.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudentDao {
    Student selectById(Integer id);

    //dao接口方法形参是一个简单类型的
    //简单类型：java基本数据类型和String
    Student selectByEmail(String email);

    /*
        dao接口方法有多个简单类型参数
        使用 @Param 命名参数，注解是mybatis提供的
        位置：在形参定义的前面
        属性：value 自定义的参数名称
     */
    List<Student> selectByNameOrAge(@Param(value = "myName") String name,
                                    @Param(value = "myAge") Integer age);

    /*
    * 一个java对象作为参数（对象有属性，每个属性有set，get方法）
    */
    List<Student> selectByObject(Student student);

    /*
     * 使用位置，获取参数
     */
    List<Student> selectByPosition(String name, Integer age);

    /*
    使用$占位符
     */
    List<Student> queryStudent(@Param(value="StudentName") String name);

    List<Student> queryStudentOrderByColName(@Param(value = "ColName") String name);
}
