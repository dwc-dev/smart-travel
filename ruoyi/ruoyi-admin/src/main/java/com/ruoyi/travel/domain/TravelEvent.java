package com.ruoyi.travel.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 景区活动，存储景区活动对象 travel_event
 *
 * @author ruoyi
 * @date 2024-07-10
 */
public class TravelEvent extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 活动ID */
    private Long eventId;

    /** 景区ID */
    @Excel(name = "景区ID")
    private Long scenicId;

    /** 活动名称 */
    @Excel(name = "活动名称")
    private String name;

    /** 开始时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "开始时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date startTime;

    /** 结束时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "结束时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date endTime;

    /** 活动描述 */
    @Excel(name = "活动描述")
    private String description;

    public void setEventId(Long eventId)
    {
        this.eventId = eventId;
    }

    public Long getEventId()
    {
        return eventId;
    }
    public void setScenicId(Long scenicId)
    {
        this.scenicId = scenicId;
    }

    public Long getScenicId()
    {
        return scenicId;
    }
    public void setName(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }
    public void setStartTime(Date startTime)
    {
        this.startTime = startTime;
    }

    public Date getStartTime()
    {
        return startTime;
    }
    public void setEndTime(Date endTime)
    {
        this.endTime = endTime;
    }

    public Date getEndTime()
    {
        return endTime;
    }
    public void setDescription(String description)
    {
        this.description = description;
    }

    public String getDescription()
    {
        return description;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("eventId", getEventId())
            .append("scenicId", getScenicId())
            .append("name", getName())
            .append("startTime", getStartTime())
            .append("endTime", getEndTime())
            .append("description", getDescription())
            .toString();
    }
}
