package com.atguigu.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * @Author: liang
 * @Date: 2021/4/6 3:41
 */
public interface LoadBalancer {

    /**
     * 服務實例
     * @param serviceInstances
     * @return
     */
    ServiceInstance instances(List<ServiceInstance> serviceInstances);
}
