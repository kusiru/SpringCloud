package com.atguigu.springcloud.myhandler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;

/**
 * @Author: liang
 * @Date: 2021/4/11 8:09
 */
public class CustomerBlockHandler {

    public static CommonResult handlerException(BlockException exception) {
        return new CommonResult(200,"按客户自定义,global handlerException--1",
                new Payment(2020L,"serial003"));
    }

    public static CommonResult handlerException2(BlockException exception) {
        return new CommonResult(200,"按客户自定义,global handlerException--2",
                new Payment(2020L,"serial003"));
    }
}
