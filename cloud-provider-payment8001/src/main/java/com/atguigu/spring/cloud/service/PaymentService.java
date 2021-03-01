package com.atguigu.spring.cloud.service;

import com.atguigu.spring.cloud.entities.Payment;

import java.util.List;

public interface PaymentService {
    int create(Payment payment);

    List<Payment> query(int id);

}
