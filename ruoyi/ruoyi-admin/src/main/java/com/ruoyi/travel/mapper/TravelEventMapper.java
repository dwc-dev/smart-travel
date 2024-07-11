package com.ruoyi.travel.mapper;

import com.ruoyi.travel.domain.TravelEvent;

import java.util.List;


/**
 * 景区活动，存储景区活动Mapper接口
 *
 * @author ruoyi
 * @date 2024-07-10
 */
public interface TravelEventMapper
{
    /**
     * 查询景区活动，存储景区活动
     *
     * @param eventId 景区活动，存储景区活动主键
     * @return 景区活动，存储景区活动
     */
    public TravelEvent selectTravelEventByEventId(Long eventId);

    /**
     * 查询景区活动，存储景区活动列表
     *
     * @param travelEvent 景区活动，存储景区活动
     * @return 景区活动，存储景区活动集合
     */
    public List<TravelEvent> selectTravelEventList(TravelEvent travelEvent);

    /**
     * 新增景区活动，存储景区活动
     *
     * @param travelEvent 景区活动，存储景区活动
     * @return 结果
     */
    public int insertTravelEvent(TravelEvent travelEvent);

    /**
     * 修改景区活动，存储景区活动
     *
     * @param travelEvent 景区活动，存储景区活动
     * @return 结果
     */
    public int updateTravelEvent(TravelEvent travelEvent);

    /**
     * 删除景区活动，存储景区活动
     *
     * @param eventId 景区活动，存储景区活动主键
     * @return 结果
     */
    public int deleteTravelEventByEventId(Long eventId);

    /**
     * 批量删除景区活动，存储景区活动
     *
     * @param eventIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTravelEventByEventIds(Long[] eventIds);
}
