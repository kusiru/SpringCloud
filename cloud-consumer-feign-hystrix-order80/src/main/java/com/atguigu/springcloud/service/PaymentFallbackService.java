package com.atguigu.springcloud.service;

import org.springframework.stereotype.Component;

/**
 * @Author: liang
 * @Date: 2021/4/6 7:17
 */
@Component
public  class PaymentFallbackService implements PaymentHystrixService{


    @Override
    public String paymentInfo_OK(Integer id) {
        return "-----paymentFallbackService fall backpaymentInfo_OK,o(╥﹏╥)o";
    }

    @Override
    public String paymentInfo_Timeout(Integer id) {
        return "-----paymentFallbackService fall paymentInfo_Timeout,o(╥﹏╥)o";

    }
}
