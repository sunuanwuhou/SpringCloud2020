package com.qm.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author qiumeng
 * @version 1.0
 * @description
 * @date 2020/7/28 14:32
 */
@EnableDiscoveryClient
@SpringBootApplication
public class PaymentMain8081 {

    public static void main(String[] args) {
        SpringApplication.run(PaymentMain8081.class,args);
    }
}
