package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author: liang
 * @Date: 2021/4/6 2:17
 */
@SpringBootApplication
//该注解用于向consul或zookeeper作为注册中心时注册服务
@EnableDiscoveryClient
public class ConsulMain80 {
    public static void main(String[] args) {
        SpringApplication.run(ConsulMain80.class,args);
    }
}
