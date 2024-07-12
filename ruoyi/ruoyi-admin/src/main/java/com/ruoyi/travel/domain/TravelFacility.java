package com.ruoyi.travel.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 景区设施，存储景区设施对象 travel_facility
 *
 * @author ruoyi
 * @date 2024-07-10
 */
public class TravelFacility extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 设施ID */
    private Long facilityId;

    /** 景区ID */
    @Excel(name = "景区ID")
    private Long scenicId;

    /** 设施名称 */
    @Excel(name = "设施名称")
    private String name;

    /** 设施类型 */
    @Excel(name = "设施类型")
    private Long type;

    /** 设施描述 */
    @Excel(name = "设施描述")
    private String description;

    public void setFacilityId(Long facilityId)
    {
        this.facilityId = facilityId;
    }

    public Long getFacilityId()
    {
        return facilityId;
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
    public void setType(Long type)
    {
        this.type = type;
    }

    public Long getType()
    {
        return type;
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
            .append("facilityId", getFacilityId())
            .append("scenicId", getScenicId())
            .append("name", getName())
            .append("type", getType())
            .append("description", getDescription())
            .toString();
    }
}
