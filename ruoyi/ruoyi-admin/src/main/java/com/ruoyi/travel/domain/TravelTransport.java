package com.ruoyi.travel.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 景区交通信息，存储景区周边交通对象 travel_transport
 *
 * @author ruoyi
 * @date 2024-07-12
 */
public class TravelTransport extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long transportId;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long scenicId;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String transportType;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
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
