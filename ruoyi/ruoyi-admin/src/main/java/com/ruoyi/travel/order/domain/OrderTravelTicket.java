package com.ruoyi.travel.order.domain;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class OrderTravelTicket {
    private Integer ticketId;
    private Integer scenicId;
    private Integer quantity;
    private Integer type;
    private BigDecimal price;
    private Timestamp createTime;

    // Getters and Setters
    public Integer getTicketId() {
        return ticketId;
    }

    public void setTicketId(Integer ticketId) {
        this.ticketId = ticketId;
    }

    public Integer getScenicId() {
        return scenicId;
    }

    public void setScenicId(Integer scenicId) {
        this.scenicId = scenicId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "OrderTravelTicket{" +
            "ticketId=" + ticketId +
            ", scenicId=" + scenicId +
            ", quantity=" + quantity +
            ", type=" + type +
            ", price=" + price +
            ", createTime=" + createTime +
            '}';
    }
}
