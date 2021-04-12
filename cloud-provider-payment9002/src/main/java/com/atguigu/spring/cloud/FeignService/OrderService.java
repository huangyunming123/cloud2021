package com.atguigu.spring.cloud.FeignService;


import com.atguigu.spring.cloud.entities.CommonResult;
import com.atguigu.spring.cloud.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@FeignClient(value = "cloud-consumer-order")
public interface OrderService {

    @PostMapping(value = "/order/query")
    public CommonResult<Payment> query(@RequestBody Payment payment);

    @PostMapping(value = "/order/insertData")
    public CommonResult<Payment> insertData(@RequestBody Payment payment);
}
