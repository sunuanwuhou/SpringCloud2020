package com.qm.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author qiumeng
 * @version 1.0
 * @description
 * @date 2020/7/28 16:32
 */
@EnableDiscoveryClient
@SpringBootApplication
// @RibbonClient(name = "CLOUD-PAYMENT-SERVICE",configuration = MyRule.class)
public class OrderConsulMain80 {

    public static void main(String[] args) {
        SpringApplication.run(OrderConsulMain80.class, args);
    }
}
