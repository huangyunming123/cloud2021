package com.atguigu.spring.cloud.ontroller;


import com.atguigu.spring.cloud.entities.CommonResult;
import com.atguigu.spring.cloud.entities.Payment;
import com.atguigu.spring.cloud.service.OrderCreateService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
@Slf4j
@RequestMapping("/order")
public class OrderController {
    @Resource
    RestTemplate restTemplate;

    @Resource
    OrderCreateService orderCreateService;

    @RequestMapping("/query")
    public CommonResult<Payment> query(@RequestBody Payment payment){
        Integer id = payment.getId();
        String s = id.toString();
//        CommonResult commonResult = restTemplate.getForObject("http://cloud-payment-service/payment/query/"+s, CommonResult.class);
        CommonResult<Payment> stringCommonResult = new CommonResult<>();
        stringCommonResult.setData(payment);
        return stringCommonResult;
    }

    @RequestMapping("/create")
    public CommonResult<Payment> create( Payment payment){
        CommonResult commonResult = restTemplate.postForObject("http://cloud-payment-service/" + "payment/create", payment, CommonResult.class);
        return commonResult;
    }

    @RequestMapping("/insertData")
    public CommonResult<Payment> insertData( Payment payment){
        int row = orderCreateService.insertData(payment);

        return  null;
    }


}
