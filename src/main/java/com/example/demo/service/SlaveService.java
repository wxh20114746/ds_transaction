package com.example.demo.service;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.example.demo.bean.Car;
import com.example.demo.bean.Role;
import com.example.demo.bean.User;
import com.example.demo.mapper.SlaveMapper;
import com.example.demo.mapper.TempMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
@DS("slave")
public class SlaveService {
    @Resource
    private SlaveMapper slaveMapper;
    @Resource
    private TempService tempService;
    @Resource
    private TempMapper tempMapper;

    @Transactional(propagation = Propagation.REQUIRES_NEW,rollbackFor = Exception.class)
    public void slave(){
        Role role = new Role();
        role.setRole("管理员");
        slaveMapper.insertRole(role);
    }

    @Transactional
    public void slave(Role role){
        slaveMapper.insertRole(role);
    }

    @Transactional
    public int slave2(int num) {
        Role role = new Role();
        role.setRole("管理员");
        slaveMapper.insertRole(role);
        Car car = new Car();
        car.setCar("AE86");
        tempService.temp(car);
        return 1 / num;
    }

    @Transactional
    public int slave4(int num) {
        Role role = new Role();
        role.setRole("管理员");
        slaveMapper.insertRole(role);
        tempService.temp(num);
        return 1 / num;
    }

    @Transactional
    public int slave3(int num) {
        Role role = new Role();
        role.setRole("管理员");
        slaveMapper.insertRole(role);
        Car car = new Car();
        car.setCar("AE86");
        tempMapper.insertCar(car);
        return 1 / num;
    }


}
