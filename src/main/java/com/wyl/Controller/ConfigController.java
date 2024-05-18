package com.wyl.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConfigController {
    //slf4j的工具
    private static final Logger LOGGER = LoggerFactory.getLogger(ConfigController.class);
    //@Value 注解即可获取到配置文件中的配置信息，并赋值给下面的参数
    @Value("${url.orderUrl}")
    private String orderUrl;

    @RequestMapping("/config")
    public String testConfig() {
        System.out.println(orderUrl);
        return "success";
    }
}
