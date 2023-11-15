package com.example.demo.mapper;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.example.demo.bean.Role;
import com.example.demo.bean.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
@DS("slave")
public interface SlaveMapper {
    int insertRole(Role role);
}
