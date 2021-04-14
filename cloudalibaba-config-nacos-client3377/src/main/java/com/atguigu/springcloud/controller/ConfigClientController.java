package com.atguigu.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: liang
 * @Date: 2021/4/7 14:28
 */
@RestController
@Slf4j
@RefreshScope//支持nacos的动态刷新功能@RefreshScope(proxyMode = ScopedProxyMode.DEFAULT)
public class ConfigClientController {


    @Value("${config.info}")
    public  String configInfo;

    @GetMapping("/config/info")
    public String getConfigInfo() {
        return configInfo;
    }
}
