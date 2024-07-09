package com.ruoyi.travel.order.controller;

import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.travel.order.service.TravelOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test/ticket_buy")
public class TravelOrderController {

    @Autowired
    private TravelOrderService travelOrderService;

    @PostMapping("/order")
    public String createOrder(@RequestBody OrderRequest request) {
        Long userId = SecurityUtils.getLoginUser().getUser().getUserId();
        travelOrderService.createOrder(userId, request.getTicketId(), request.getQuantity());
        return "Order created successfully";
    }

    public static class OrderRequest {
        private Integer scenicId;
        private Integer ticketId;
        private Integer quantity;

        public Integer getScenicId() {
            return scenicId;
        }

        public void setScenicId(Integer scenicId) {
            this.scenicId = scenicId;
        }

        public Integer getTicketId() {
            return ticketId;
        }

        public void setTicketId(Integer ticketId) {
            this.ticketId = ticketId;
        }

        public Integer getQuantity() {
            return quantity;
        }

        public void setQuantity(Integer quantity) {
            this.quantity = quantity;
        }
    }
}
