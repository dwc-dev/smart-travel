package com.ruoyi.travel.service.impl;

import java.util.List;

import com.ruoyi.travel.domain.TravelEvent;
import com.ruoyi.travel.mapper.TravelEventMapper;
import com.ruoyi.travel.service.ITravelEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * 景区活动，存储景区活动Service业务层处理
 *
 * @author ruoyi
 * @date 2024-07-10
 */
@Service
public class TravelEventServiceImpl implements ITravelEventService
{
    @Autowired
    private TravelEventMapper travelEventMapper;

    /**
     * 查询景区活动，存储景区活动
     *
     * @param eventId 景区活动，存储景区活动主键
     * @return 景区活动，存储景区活动
     */
    @Override
    public TravelEvent selectTravelEventByEventId(Long eventId)
    {
        return travelEventMapper.selectTravelEventByEventId(eventId);
    }

    /**
     * 查询景区活动，存储景区活动列表
     *
     * @param travelEvent 景区活动，存储景区活动
     * @return 景区活动，存储景区活动
     */
    @Override
    public List<TravelEvent> selectTravelEventList(TravelEvent travelEvent)
    {
        return travelEventMapper.selectTravelEventList(travelEvent);
    }

    /**
     * 新增景区活动，存储景区活动
     *
     * @param travelEvent 景区活动，存储景区活动
     * @return 结果
     */
    @Override
    public int insertTravelEvent(TravelEvent travelEvent)
    {
        return travelEventMapper.insertTravelEvent(travelEvent);
    }

    /**
     * 修改景区活动，存储景区活动
     *
     * @param travelEvent 景区活动，存储景区活动
     * @return 结果
     */
    @Override
    public int updateTravelEvent(TravelEvent travelEvent)
    {
        return travelEventMapper.updateTravelEvent(travelEvent);
    }

    /**
     * 批量删除景区活动，存储景区活动
     *
     * @param eventIds 需要删除的景区活动，存储景区活动主键
     * @return 结果
     */
    @Override
    public int deleteTravelEventByEventIds(Long[] eventIds)
    {
        return travelEventMapper.deleteTravelEventByEventIds(eventIds);
    }

    /**
     * 删除景区活动，存储景区活动信息
     *
     * @param eventId 景区活动，存储景区活动主键
     * @return 结果
     */
    @Override
    public int deleteTravelEventByEventId(Long eventId)
    {
        return travelEventMapper.deleteTravelEventByEventId(eventId);
    }
}
