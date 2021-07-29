package com.echo.dao;

import com.echo.vo.ProvinceCity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProvinceDao {

    List<ProvinceCity> selectProvinceCityList(@Param(value = "pid") Integer id);
}
