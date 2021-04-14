package com.atguigu.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @Author: liang
 * @Date: 2021/4/7 14:03
 */
@RestController
@Slf4j
public class CircleBreakController {

    @Resource
    public RestTemplate restTemplate;

    public static final String SERVICE_URL = "http://nacos-payment-provider";

    @Resource
    private PaymentService paymentService;

    @GetMapping(value = "/consumer/paymentSQL/{id}")
    public CommonResult<Payment> paymentSQL(@PathVariable("id") Long id) {
        CommonResult<Payment> result = paymentService.paymentSQL(id);
        return result;
    }



    /**
     * fallback只负责业务异常
     * blockHandler只负责sentinel控制台配置违规
     * exceptionsToIgnore 忽略异常
     * @param id
     * @return
     */
    @GetMapping(value = "/consumer/fallback/{id}")
    @SentinelResource(value = "fallback",blockHandler = "blockHandler"
            ,fallback = "handlerFallback",exceptionsToIgnore = IllegalArgumentException.class)
    public CommonResult<Payment> fallback(@PathVariable("id") Long id) {
        CommonResult result = restTemplate.getForObject(SERVICE_URL + "/paymentSQL/" + id, CommonResult.class, id);
        if (id == 4) {
            throw new IllegalArgumentException("IllegalArgumentException，非法参数异常");
        } else if (null == result.getData()) {
            throw new NullPointerException("NullPointerException，ID没有记录");
        }
        return result;
    }


    public CommonResult blockHandler(@PathVariable("id") Long id, BlockException blockException) {
        Payment payment = new Payment(id,null);
        return new CommonResult(445,"blockHandler-sentinel限流，无此流水，blockException信息："
                + blockException.getMessage(),payment);
    }

    public CommonResult handlerFallback(@PathVariable("id") Long id,Throwable e) {
        Payment payment = new Payment(id,null);
        return new CommonResult(444,"兜底异常handlerFallback，exception信息："
                + e.getMessage(),payment);
    }
}
