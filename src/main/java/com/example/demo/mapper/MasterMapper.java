package com.example.demo.mapper;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.example.demo.bean.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
@DS("master")
public interface MasterMapper {
    int insertUser(User user);
}
