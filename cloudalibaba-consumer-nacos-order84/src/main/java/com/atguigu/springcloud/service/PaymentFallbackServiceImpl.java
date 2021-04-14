package com.atguigu.springcloud.service;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import org.springframework.stereotype.Component;

/**
 * @Author: liang
 * @Date: 2021/4/13 3:46
 */
@Component
public class PaymentFallbackServiceImpl implements PaymentService{

    @Override
    public CommonResult<Payment> paymentSQL(Long id) {
        return new CommonResult<>(444,
                "服务降级返回，---PaymentFallbackService",
            new Payment(id,"errorSerial"));
        }
}
