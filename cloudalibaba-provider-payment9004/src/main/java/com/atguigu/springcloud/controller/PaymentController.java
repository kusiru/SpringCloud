package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;

/**
 * @Author: liang
 * @Date: 2021/4/11 8:45
 */
@RestController
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;

    public static HashMap<Long, Payment> hashMap = new HashMap<>();

    static {
        hashMap.put(1L,new Payment(1L,"123"));
        hashMap.put(2L,new Payment(2L,"456"));
        hashMap.put(3L,new Payment(3L,"789"));
    }

    @GetMapping(value = "/paymentSQL/{id}")
    public CommonResult<Payment> paymentSQL(@PathVariable("id") Long id) {
        Payment payment = hashMap.get(id);
        CommonResult<Payment> result = new CommonResult<>(200,
                "from mysql,serverPort:" + serverPort,payment);
        if (id == 4) {
            throw new IllegalArgumentException("IllegalArgumentException，非法参数异常");
        } else if (null == result.getData()) {
            throw new NullPointerException("NullPointerException，ID没有记录");
        }
        return result;
    }
}
