package com.atguigu.springcloud.confg;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @className: MybatisConfig
 * @description:
 * @author: liusCoding
 * @create: 2020-06-12 09:19
 */

@Configuration
@MapperScan("com.atguigu.springcloud.dao")
public class MybatisConfig {
}
