package com.atguigu.spring.cloud.controller;

import com.atguigu.spring.cloud.entities.CommonResult;
import com.atguigu.spring.cloud.entities.Payment;
import com.atguigu.spring.cloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/payment")
@Slf4j
public class PaymentController {

    @Autowired
    PaymentService paymentService;

//    @RequestBody 添加请求体中的
@RequestMapping("/create")
public CommonResult create(@RequestBody Payment payment){
    int i = paymentService.create(payment);
    log.info("插入成功！！");
        if(i>0){
            return new CommonResult(200,"success");
        }else {
            return new CommonResult(500,"error");
        }
}

@GetMapping("/query/{id}")
public CommonResult query(@PathVariable int id){
    log.info("查询ing！");
    List<Payment> query = paymentService.query(id);
    return new CommonResult(200,"success",query);
}


    @RequestMapping("/testAdd")
    public String addData(Payment payment){
    try {
        paymentService.addData(payment);
    }catch (Exception e){
        e.printStackTrace();
    }
    return "success";
}

    public static void main(String[] args) {
        ArrayList<Object> list = new ArrayList<>();
    }
}
