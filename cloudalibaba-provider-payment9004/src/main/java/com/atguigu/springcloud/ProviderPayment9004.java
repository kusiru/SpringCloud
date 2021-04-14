package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author: liang
 * @Date: 2021/4/11 8:43
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ProviderPayment9004 {
    public static void main(String[] args) {
        SpringApplication.run(ProviderPayment9004.class,args);
    }
}
