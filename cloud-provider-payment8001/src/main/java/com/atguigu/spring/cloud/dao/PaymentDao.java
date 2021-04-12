package com.atguigu.spring.cloud.dao;

import com.atguigu.spring.cloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PaymentDao {
    int create(Payment payment);

    List<Payment> query(int id);

    int add(Payment payment);


}
