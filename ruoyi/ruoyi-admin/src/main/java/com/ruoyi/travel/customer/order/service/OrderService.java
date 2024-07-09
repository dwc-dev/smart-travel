package com.ruoyi.travel.customer.order.service;

import com.ruoyi.travel.customer.order.domain.OrderInfo;
import com.ruoyi.travel.customer.order.mapper.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderMapper orderMapper;

    public List<OrderInfo> getOrderInfoByUserId(Long userId) {
        return orderMapper.selectOrderInfoByUserId(userId);
    }
}
