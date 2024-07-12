package com.ruoyi.travel.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 景区交通信息，存储景区周边交通信息对象 travel_transport
 * 
 * @author sj
 * @date 2024-07-12
 */
public class TravelTransport extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 交通ID */
    private Long transportId;

    /** 景区ID */
    @Excel(name = "景区ID")
    private Long scenicId;

    /** 交通类型 */
    @Excel(name = "交通类型")
    private String transportType;

    /** 交通信息描述 */
    @Excel(name = "交通信息描述")
    private String routeDescription;

    public void setTransportId(Long transportId) 
    {
        this.transportId = transportId;
    }

    public Long getTransportId() 
    {
        return transportId;
    }
    public void setScenicId(Long scenicId) 
    {
        this.scenicId = scenicId;
    }

    public Long getScenicId() 
    {
        return scenicId;
    }
    public void setTransportType(String transportType) 
    {
        this.transportType = transportType;
    }

    public String getTransportType() 
    {
        return transportType;
    }
    public void setRouteDescription(String routeDescription) 
    {
        this.routeDescription = routeDescription;
    }

    public String getRouteDescription() 
    {
        return routeDescription;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("transportId", getTransportId())
            .append("scenicId", getScenicId())
            .append("transportType", getTransportType())
            .append("routeDescription", getRouteDescription())
            .toString();
    }
}
