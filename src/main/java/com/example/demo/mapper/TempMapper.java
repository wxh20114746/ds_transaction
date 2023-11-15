package com.example.demo.mapper;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.example.demo.bean.Car;
import com.example.demo.bean.Role;
import org.apache.ibatis.annotations.Mapper;

@Mapper
@DS("temp")
public interface TempMapper {
    int insertCar(Car car);
}
