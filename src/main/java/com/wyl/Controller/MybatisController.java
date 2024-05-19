package com.wyl.Controller;

import com.wyl.dao.UserService;
import com.wyl.pojo.User;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MybatisController {
    @Resource
    private UserService userService;

    @RequestMapping("/getUserByName/{name}")
    public User getUserByName(@PathVariable String name) {
        return userService.getUserByName(name);
    }
    @RequestMapping("/getUser")
    public List<User> getUser(){
        return userService.getUser();
    }
    @RequestMapping("/getUserByIdAndName")
    public User getUserByIdAndName(){
        return userService.getUserByIdAndName(1,"啊");
    }
}
