package com.ruoyi.travel.order.service;

import com.ruoyi.travel.order.domain.TravelOrder;
import com.ruoyi.travel.order.domain.OrderTravelTicket;
import com.ruoyi.travel.order.mapper.TravelOrderMapper;
import com.ruoyi.travel.order.mapper.OrderTicketMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Service
public class TravelOrderService {

    @Autowired
    private OrderTicketMapper travelTicketMapper;

    @Autowired
    private TravelOrderMapper travelOrderMapper;

    @Transactional
    public void createOrder(Long userId, Integer ticketId, Integer quantity) {
        // Get ticket information
        OrderTravelTicket ticket = travelTicketMapper.selectTicketById(ticketId);

        if (ticket == null) {
            throw new RuntimeException("Ticket not found");
        }

        if (ticket.getQuantity() < quantity) {
            throw new RuntimeException("Not enough tickets available");
        }

        System.out.println(ticket);

        // Calculate total price
        BigDecimal totalPrice = ticket.getPrice().multiply(new BigDecimal(quantity));

        // Create order
        TravelOrder order = new TravelOrder();
        order.setUserId(userId);
        order.setTicketId(ticketId);
        order.setQuantity(quantity);
        order.setTotalPrice(totalPrice);

        // Insert order into database
        travelOrderMapper.insertOrder(order);

        // Update ticket quantity
        travelTicketMapper.updateTicketQuantity(ticketId, ticket.getQuantity() - quantity);
        System.out.println(ticket.getTicketId());
        System.out.println(ticket.getQuantity() - quantity);
    }
}
