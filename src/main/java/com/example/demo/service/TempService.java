package com.example.demo.service;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.example.demo.bean.Car;
import com.example.demo.bean.Role;
import com.example.demo.mapper.SlaveMapper;
import com.example.demo.mapper.TempMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
@DS("temp")
public class TempService {
    @Resource
    private TempMapper tempMapper;

    @Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
    public int temp(int a) {
        Car car = new Car();
        car.setCar("AE86");
        tempMapper.insertCar(car);
        return 1 / a;
    }

    @Transactional
    public int temp(Car car) {
        return tempMapper.insertCar(car);
    }
}
