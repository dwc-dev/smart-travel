package com.ruoyi.travel.customer.buy.mapper;

import com.ruoyi.travel.customer.buy.domain.TravelOrder;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TravelOrderMapper {
    @Insert("INSERT INTO travel_order (user_id, ticket_id, quantity, total_price, order_time) VALUES (#{userId}, #{ticketId}, #{quantity}, #{totalPrice}, NOW())")
    void insertOrder(TravelOrder order);
}
