package com.qm.springcloud.controller;

import com.qm.springcloud.CommonResult;
import com.qm.springcloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
@Slf4j
public class OrderConsulController {

    public static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE";

    @Resource
    private RestTemplate restTemplate;

    // @Resource
    // private LoadBalancer loadBalancer;

    @Resource
    private DiscoveryClient discoveryClient;

    @GetMapping("/consumer/payment/create")
    public CommonResult<Payment> create(Payment payment) {
        return restTemplate.postForObject(PAYMENT_URL + "/payment/create", payment, CommonResult.class);
    }

    @GetMapping("/consumer/payment/create2")
    public CommonResult< Payment > create2(Payment payment) {
        ResponseEntity<CommonResult> entity = restTemplate.postForEntity(PAYMENT_URL + "/payment/create", payment, CommonResult.class);
        if(entity.getStatusCode().is2xxSuccessful()){
            return entity.getBody();
        } else {
            return new CommonResult<>(444,"插入数据失败！");
        }
    }

    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult< Payment > getPayment(@PathVariable("id") Long id) {
        return restTemplate.getForObject(PAYMENT_URL + "/payment/get/" + id, CommonResult.class);
    }

    @GetMapping("/consumer/payment/getForEntity/{id}")
    public CommonResult< Payment > getPayment2(@PathVariable("id") Long id) {
        ResponseEntity<CommonResult> entity = restTemplate.getForEntity(PAYMENT_URL + "/payment/get/" + id, CommonResult.class);

        if(entity.getStatusCode().is2xxSuccessful()) {
            return entity.getBody();
        } else {
            return new CommonResult<>(444,"操作失败！");
        }
    }
    // @GetMapping("/consumer/payment/lb")
    // public String getPaymentLB() {
    //     // 通过容器中的 discoveryClient和服务名来获取服务集群
    //     List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
    //     if(instances == null || instances.size() <= 0) {
    //         return null;
    //     }
    //     // 传入服务集群来计算出获取具体的服务实例
    //     ServiceInstance serviceInstance = loadBalancer.instances(instances);
    //     URI uri = serviceInstance.getUri();
    //     return  restTemplate.getForObject(uri+"/payment/lb",String.class);
    // }

    @GetMapping(value="/consumer/payment/zipkin")
    public String paymentZipkin() {
        return restTemplate.getForObject( "http://localhost:8001/payment/zipkin/",String.class);
    }
}