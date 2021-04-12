package com.atguigu.spring.cloud.service.impl;

import com.atguigu.spring.cloud.FeignService.OrderService;
import com.atguigu.spring.cloud.dao.OrderDao;
import com.atguigu.spring.cloud.entities.CommonResult;
import com.atguigu.spring.cloud.entities.Payment;
import com.atguigu.spring.cloud.entities.Teacher;
import com.atguigu.spring.cloud.service.OrderCreateService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.UUID;

@Service
public class OrderServiceImpl implements OrderCreateService {

    @Resource
    OrderDao orderDao;

    @Resource
    OrderService orderService;


    @Override
    public int insertData() {
        Teacher teacher = new Teacher();
        teacher.setId(UUID.randomUUID().toString());
        teacher.setName("zzzlecc");
        int insert = orderDao.insert(teacher);


        return 0;
    }
}
