package com.atguigu.spring.cloud.service.impl;

import com.atguigu.spring.cloud.dao.PaymentDao;
import com.atguigu.spring.cloud.entities.Payment;
import com.atguigu.spring.cloud.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class PaymentServiceImpl implements PaymentService {
    @Resource
    PaymentDao paymentDao;


    @Override
    public int create(Payment payment) {
        int i = paymentDao.create(payment);
        return i;
    }

    @Override
    public List<Payment> query(int id) {
        List<Payment> query = paymentDao.query(id);
        return query;
    }
}
