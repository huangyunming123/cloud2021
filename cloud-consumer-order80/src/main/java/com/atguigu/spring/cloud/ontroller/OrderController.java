package com.atguigu.spring.cloud.ontroller;


import com.atguigu.spring.cloud.entities.CommonResult;
import com.atguigu.spring.cloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
@Slf4j
@RequestMapping("/order")
public class OrderController {
    @Resource
    RestTemplate restTemplate;

    @RequestMapping("/query")
    public CommonResult<Payment> query( Payment payment){
        Integer id = payment.getId();
        String s = id.toString();
        CommonResult commonResult = restTemplate.getForObject("http://localhost:8001/payment/query/"+s, CommonResult.class);
        return commonResult;
    }

    @RequestMapping("create")
    public CommonResult<Payment> create( Payment payment){
        CommonResult commonResult = restTemplate.postForObject("http://localhost:8001" + "payment/create", payment, CommonResult.class);
        return commonResult;
    }

}
