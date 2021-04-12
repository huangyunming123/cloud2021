package com.atguigu.cloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/testConfig")
@RefreshScope  //支持nacos的动态刷新配置
public class TestController {
    @Value("${config.info}")
    private String configInfo;
    @Value("${server.port}")
    private String port;
    @Value("${computer.name}")
    private String cname;

    @RequestMapping("/test1")
    public String test(){
        return configInfo+port+cname;
    }

}
