package com.wyl.Controller;

import com.wyl.utils.JsonResult;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.wyl.pojo.*;

//RestController包含
//@Target({ElementType.TYPE})
//@Retention(RetentionPolicy.RUNTIME)
//@Documented
//@Controller
//@ResponseBody
@RestController
public class StartController {
    //最基础的用法
    @RequestMapping(value = "/sb")
    public  String say() {
        return "Hello,springBoot!";
    }
    //返回User对象ResponseBody给其封装成Json数据输出给页面
    @RequestMapping("/user")
    public User getUser() {
        return new User(1, "测试", "123456");
    }
    //用了JsonResult工具类，定义统一的 Json结构
    @RequestMapping("/list")
    public JsonResult<List> getUserList() {
        List<User> userList = new ArrayList<>();
        User user1 = new User(1, "测试", "123456");
        User user2 = new User(2, "测试课", "123456");
        userList.add(user1);
        userList.add(user2);
        //JsonResult工具类的用法
        return new JsonResult<>(userList, "获取用户列表成功");
    }
    //map用法
    @RequestMapping("/map")
    public Map<String, Object> getMap() {
        Map<String, Object> map = new HashMap<>(3);
        User user = new User(1, "测试", "123456");
        map.put("作者信息", "test");
        map.put("博客地址", "https://blog.csdn.net/cuiqwei/article/details/118188540");
        map.put("CSDN地址", "null");
        map.put("测试数量", 001);
        return map;
    }
    //@PathVariable 注解主要是用来获取 url 参数，Spring Boot 支持 restfull 风格的 url
    //比如一个 GET 请求携带一个参数 id 过来，我们将 id 作为参数接收，可以使用 @PathVariable 注解
    @GetMapping("/user/{id}")
    public String testPathVariable(@PathVariable Integer id) {
        return "获取到的id为：" + id;
    }
    //http://localhost:8080/user/rq?id=1 。我们使用该 url 带上参数 id 来测试一下如下代码：

    @GetMapping("/user/rq")
    public String testRequestParam(@RequestParam Integer id) {
        return "获取到的id为：" + id;
    }
}
