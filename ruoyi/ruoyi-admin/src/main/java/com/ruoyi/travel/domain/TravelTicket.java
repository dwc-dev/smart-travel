package com.ruoyi.travel.domain;

import java.math.BigDecimal;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 票务对象 travel_ticket
 * 
 * @author dwc
 * @date 2024-07-05
 */
public class TravelTicket extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 票务ID */
    @Excel(name = "票务ID")
    private Long ticketId;

    /** 景区ID */
    @Excel(name = "景区ID")
    private Long scenicId;

    /** 票的数量 */
    @Excel(name = "票的数量")
    private Long quantity;

    /** 票的类型 */
    @Excel(name = "票的类型")
    private Long type;

    /** 票的价格 */
    @Excel(name = "票的价格")
    private BigDecimal price;

    public void setTicketId(Long ticketId) 
    {
        this.ticketId = ticketId;
    }

    public Long getTicketId() 
    {
        return ticketId;
    }
    public void setScenicId(Long scenicId) 
    {
        this.scenicId = scenicId;
    }

    public Long getScenicId() 
    {
        return scenicId;
    }
    public void setQuantity(Long quantity) 
    {
        this.quantity = quantity;
    }

    public Long getQuantity() 
    {
        return quantity;
    }
    public void setType(Long type) 
    {
        this.type = type;
    }

    public Long getType() 
    {
        return type;
    }
    public void setPrice(BigDecimal price) 
    {
        this.price = price;
    }

    public BigDecimal getPrice() 
    {
        return price;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("ticketId", getTicketId())
            .append("scenicId", getScenicId())
            .append("quantity", getQuantity())
            .append("type", getType())
            .append("price", getPrice())
            .append("createTime", getCreateTime())
            .toString();
    }
}
