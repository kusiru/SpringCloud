package com.atguigu.springcloud.service;

import com.atguigu.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * @Author: liang
 * @Date: 2021/4/4 3:09
 */
public interface PaymentService {

    /**
     * 创建
     *
     * @param payment
     * @return
     */
    int create(Payment payment);

    /**
     * 通过id获取payment
     *
     * @param id
     * @return
     */
    Payment getPaymentById(@Param("id") Long id);
}
