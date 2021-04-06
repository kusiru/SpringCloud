package com.atguigu.springcloud.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @Author: liang
 * @Date: 2021/4/6 5:41
 */
@Service
public class PaymentService {


    public String paymentInfo_OK(Integer id) {
        return "线程池：" + Thread.currentThread().getName()
                + "paymentInfo_OK,id：" + id + "\t" + "O(∩_∩)O哈哈~";
    }

    @HystrixCommand(fallbackMethod = "paymentInfo_TimeOutHandler",
            commandProperties = {@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "5000")})
    public String paymentInfo_Timeout(Integer id) {
//        int age = 10/0;
        int timeNumber = 3000;
        try {
            TimeUnit.MILLISECONDS.sleep(timeNumber);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池：" + Thread.currentThread().getName()
                + "paymentInfo_Timeout,id：" + id + "\t" + "O(∩_∩)O哈哈~" + "耗时：" + timeNumber + "毫秒";
    }

    public String paymentInfo_TimeOutHandler(Integer id) {
        return "线程池：" + Thread.currentThread().getName()
                + "paymentInfo_TimeOutHandler,id：" + id + "\t" + "系统繁忙~~~~~~~~";
    }
}
