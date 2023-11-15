package com.example.demo.service;

import com.baomidou.dynamic.datasource.annotation.DSTransactional;
import com.example.demo.bean.Car;
import com.example.demo.bean.Role;
import com.example.demo.bean.User;
import com.example.demo.mapper.MasterMapper;
import com.example.demo.mapper.SlaveMapper;
import com.example.demo.mapper.TempMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
public class UserService {

    @Resource
    private MasterMapper masterMapper;
    @Resource
    private SlaveService slaveService;
    @Resource
    private SlaveMapper slaveMapper;
    @Resource
    private TempService tempService;
    @Resource
    private TempMapper tempMapper;

    @DSTransactional
    public int add2(int num) {
        User user = new User();
        user.setUsername("张三");
        user.setPassword("123456");
        masterMapper.insertUser(user);
        Role role = new Role();
        role.setRole("管理员");
        slaveService.slave(role);
        Car car = new Car();
        car.setCar("AE86");
        tempService.temp(car);
        return 1 / num;
    }


    @DSTransactional
    public int add6(int num) {
        User user = new User();
        user.setUsername("张三");
        user.setPassword("123456");
        masterMapper.insertUser(user);
        Role role = new Role();
        role.setRole("管理员");
        slaveService.slave(role);
        Car car = new Car();
        car.setCar("AE86");
        int i = 1 / num;
        tempService.temp(car);
        return i;
    }

    @Transactional
    public int add3(int num) {
        User user = new User();
        user.setUsername("张三");
        user.setPassword("123456");
        masterMapper.insertUser(user);
        Role role = new Role();
        role.setRole("管理员");
        slaveService.slave(role);
        Car car = new Car();
        car.setCar("AE86");
        tempService.temp(car);
        return 1 / num;
    }


    public int add(int num) {
        User user = new User();
        user.setUsername("张三");
        user.setPassword("123456");
        masterMapper.insertUser(user);
        Role role = new Role();
        role.setRole("管理员");
        slaveMapper.insertRole(role);
        Car car = new Car();
        car.setCar("AE86");
        tempMapper.insertCar(car);
        return 1 / num;
    }

}
