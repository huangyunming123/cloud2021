package com.atguigu.spring.cloud.service.impl;

import com.atguigu.spring.cloud.dao.OrderDataDao;
import com.atguigu.spring.cloud.entities.Payment;
import com.atguigu.spring.cloud.entities.Teacher;
import com.atguigu.spring.cloud.service.OrderCreateService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.UUID;
@Resource
@Service
public class OrderServiceImpl implements OrderCreateService {

    @Resource
    OrderDataDao orderDao;

    @Override
    public int insertData(Payment payment) {
        int insert = orderDao.insert(payment);
        return 0;
    }
}
