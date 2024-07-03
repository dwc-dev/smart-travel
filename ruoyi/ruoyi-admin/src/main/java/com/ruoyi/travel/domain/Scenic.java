package com.ruoyi.travel.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 景区管理对象 travel_scenic
 * 
 * @author dwc
 * @date 2024-07-03
 */
public class Scenic extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 景区ID */
    private Long scenicId;

    /** 景区名称 */
    @Excel(name = "景区名称")
    private String name;

    /** 省 */
    @Excel(name = "省")
    private String province;

    /** 市 */
    @Excel(name = "市")
    private String city;

    /** 区 */
    @Excel(name = "区")
    private String district;

    /** 景区简介 */
    @Excel(name = "景区简介")
    private String description;

    /** 景区图片URL */
    @Excel(name = "景区图片URL")
    private String imageUrl;

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
    public void setProvince(String province) 
    {
        this.province = province;
    }

    public String getProvince() 
    {
        return province;
    }
    public void setCity(String city) 
    {
        this.city = city;
    }

    public String getCity() 
    {
        return city;
    }
    public void setDistrict(String district) 
    {
        this.district = district;
    }

    public String getDistrict() 
    {
        return district;
    }
    public void setDescription(String description) 
    {
        this.description = description;
    }

    public String getDescription() 
    {
        return description;
    }
    public void setImageUrl(String imageUrl) 
    {
        this.imageUrl = imageUrl;
    }

    public String getImageUrl() 
    {
        return imageUrl;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("scenicId", getScenicId())
            .append("name", getName())
            .append("province", getProvince())
            .append("city", getCity())
            .append("district", getDistrict())
            .append("description", getDescription())
            .append("imageUrl", getImageUrl())
            .append("createTime", getCreateTime())
            .toString();
    }
}
