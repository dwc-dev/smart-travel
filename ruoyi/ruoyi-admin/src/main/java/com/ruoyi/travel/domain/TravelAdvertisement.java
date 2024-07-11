package com.ruoyi.travel.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 景区广告，存储景区广告对象 travel_advertisement
 *
 * @author ruoyi
 * @date 2024-07-11
 */
public class TravelAdvertisement extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 广告ID */
    private Long adId;

    /** 景区ID */
    @Excel(name = "景区ID")
    private Long scenicId;

    /** 广告标题 */
    @Excel(name = "广告标题")
    private String title;

    /** 广告内容 */
    @Excel(name = "广告内容")
    private String content;

    /** 开始时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "开始时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date startTime;

    /** 结束时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "结束时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date endTime;

    public void setAdId(Long adId)
    {
        this.adId = adId;
    }

    public Long getAdId()
    {
        return adId;
    }
    public void setScenicId(Long scenicId)
    {
        this.scenicId = scenicId;
    }

    public Long getScenicId()
    {
        return scenicId;
    }
    public void setTitle(String title)
    {
        this.title = title;
    }

    public String getTitle()
    {
        return title;
    }
    public void setContent(String content)
    {
        this.content = content;
    }

    public String getContent()
    {
        return content;
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

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("adId", getAdId())
            .append("scenicId", getScenicId())
            .append("title", getTitle())
            .append("content", getContent())
            .append("startTime", getStartTime())
            .append("endTime", getEndTime())
            .toString();
    }
}
