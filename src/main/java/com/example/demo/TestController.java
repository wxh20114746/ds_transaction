package com.example.demo;


import com.example.demo.service.SlaveService;
import com.example.demo.service.TempService;
import com.example.demo.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("tx")
public class TestController {

    @Resource
    private TempService tempService;

    @Resource
    private SlaveService slaveService;

    @Resource
    private UserService userService;

    @GetMapping("test1")
    public Integer temp_rollback_test(@RequestParam(required = false,defaultValue = "1") int a) {
        return tempService.temp(a);
    }


    @GetMapping("test2")
    public Integer all_commit_test1(@RequestParam(required = false,defaultValue = "1") int a) {
        // 不加事务，
        return userService.add(a);
        // 都成功，异常都不回滚
    }

    @GetMapping("test3")
    public Integer all_commit_test(@RequestParam(required = false,defaultValue = "1") int a) {
        // 使用ds事务
        return userService.add2(a);
        // 成功，各自创建自己的事务， 同时成功，同时失败
    }

    @GetMapping("test8")
    public Integer mid_error_test8(@RequestParam(required = false,defaultValue = "1") int a) {
        // spring同一个事务操作两个源
        return userService.add6(a);
        // 失败， 第二个找不到表
    }


    @GetMapping("test4")
    public Integer all_commit_test4(@RequestParam(required = false,defaultValue = "1") int a) {
       // spring事务
        return userService.add3(a);
        // 失败， 后面的事务找不到
    }

    @GetMapping("test5")
    public Integer all_commit_test5(@RequestParam(required = false,defaultValue = "1") int a) {
        // spring定义不同事务, 默认传播操作两个源
        return slaveService.slave2(a);
        // 失败， 实际只创建一个事务
    }

    @GetMapping("test6")
    public Integer all_commit_test6(@RequestParam(required = false,defaultValue = "1") int a) {
        //  spring定义不同事务,传播为 new ，操作两个源
        return slaveService.slave4(a);
        // 成功， 实际创建2个事务
    }

    @GetMapping("test7")
    public Integer all_commit_test7(@RequestParam(required = false,defaultValue = "1") int a) {
        // spring同一个事务操作两个源
        return slaveService.slave3(a);
        // 失败， 第二个找不到表
    }
}
