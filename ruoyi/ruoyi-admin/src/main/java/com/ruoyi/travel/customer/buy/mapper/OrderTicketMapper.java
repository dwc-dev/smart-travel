package com.ruoyi.travel.customer.buy.mapper;

import com.ruoyi.travel.customer.buy.domain.OrderTravelTicket;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface OrderTicketMapper {
    @Select("SELECT ticket_id AS ticketId, scenic_id AS scenicId, quantity, type, price, create_time AS createTime FROM travel_ticket WHERE ticket_id = #{ticketId}")
    OrderTravelTicket selectTicketById(@Param("ticketId") Integer ticketId);

    @Update("UPDATE travel_ticket SET quantity = #{quantity} WHERE ticket_id = #{ticketId}")
    void updateTicketQuantity(@Param("ticketId") Integer ticketId, @Param("quantity") Integer quantity);
}
