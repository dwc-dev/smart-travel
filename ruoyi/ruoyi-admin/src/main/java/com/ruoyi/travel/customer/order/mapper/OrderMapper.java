package com.ruoyi.travel.customer.order.mapper;

import com.ruoyi.travel.customer.order.domain.OrderInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface OrderMapper {

    @Select("SELECT s.name AS scenicName, o.quantity, t.type, o.total_price AS totalPrice, o.order_time AS orderTime " +
        "FROM travel_order o " +
        "JOIN travel_ticket t ON o.ticket_id = t.ticket_id " +
        "JOIN travel_scenic s ON t.scenic_id = s.scenic_id " +
        "WHERE o.user_id = #{userId}")
    List<OrderInfo> selectOrderInfoByUserId(Long userId);
}
