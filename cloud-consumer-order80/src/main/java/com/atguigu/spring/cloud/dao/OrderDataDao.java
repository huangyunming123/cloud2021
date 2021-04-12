package com.atguigu.spring.cloud.dao;

import com.atguigu.spring.cloud.entities.Payment;
import com.atguigu.spring.cloud.entities.Teacher;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderDataDao {

int insert(Payment payment);
int addData(Payment payment);
}
