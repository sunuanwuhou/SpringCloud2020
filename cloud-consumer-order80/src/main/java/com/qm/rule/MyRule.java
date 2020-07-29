package com.qm.rule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RoundRobinRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author qiumeng
 * @version 1.0
 * @description
 * @date 2020/7/29 16:43
 */
@Configuration
public class MyRule {

    @Bean("1111")
    public IRule myRule() {
        return new RoundRobinRule(); // 定义为随机
    }
}
