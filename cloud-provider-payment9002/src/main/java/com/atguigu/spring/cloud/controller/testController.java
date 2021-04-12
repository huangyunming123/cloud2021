package com.atguigu.spring.cloud.controller;


import com.atguigu.spring.cloud.FeignService.OrderService;
import com.atguigu.spring.cloud.entities.CommonResult;
import com.atguigu.spring.cloud.entities.Payment;
import com.atguigu.spring.cloud.service.OrderCreateService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
@Slf4j
@RequestMapping("/order")
public class testController {
    @Resource
    RestTemplate restTemplate;

    @Resource
    OrderService orderService;

    @Resource
    OrderCreateService orderCreateService;


    @RequestMapping("/query")
    public CommonResult<Payment> query( Payment payment){
        Integer id = payment.getId();
        String s = id.toString();
        CommonResult commonResult = restTemplate.getForObject("http://cloud-payment-service/payment/query/"+s, CommonResult.class);
        return commonResult;
    }

    @RequestMapping("create")
    public CommonResult<Payment> create( Payment payment){
        CommonResult commonResult = restTemplate.postForObject("http://cloud-payment-service/" + "payment/create", payment, CommonResult.class);
        return commonResult;
    }

    @RequestMapping("/feignTest")
    public CommonResult<Payment> feignTest(@RequestBody Payment payment){
        CommonResult<Payment> commonResult = orderService.query(payment);
        return commonResult;
    }


    @RequestMapping("/txTest")
    public CommonResult<Payment> txTest(@RequestBody Payment payment){

        int i = orderCreateService.insertData();
        orderService.insertData(payment);
        CommonResult<Payment> commonResult = new CommonResult();
        return commonResult;
    }

}
