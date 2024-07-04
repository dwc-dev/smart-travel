package com.ruoyi.travel.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.travel.mapper.TravelTicketMapper;
import com.ruoyi.travel.domain.TravelTicket;
import com.ruoyi.travel.service.ITravelTicketService;

/**
 * 票务Service业务层处理
 * 
 * @author dwc
 * @date 2024-07-04
 */
@Service
public class TravelTicketServiceImpl implements ITravelTicketService 
{
    @Autowired
    private TravelTicketMapper travelTicketMapper;

    /**
     * 查询票务
     * 
     * @param ticketId 票务主键
     * @return 票务
     */
    @Override
    public TravelTicket selectTravelTicketByTicketId(Long ticketId)
    {
        return travelTicketMapper.selectTravelTicketByTicketId(ticketId);
    }

    /**
     * 查询票务列表
     * 
     * @param travelTicket 票务
     * @return 票务
     */
    @Override
    public List<TravelTicket> selectTravelTicketList(TravelTicket travelTicket)
    {
        return travelTicketMapper.selectTravelTicketList(travelTicket);
    }

    /**
     * 新增票务
     * 
     * @param travelTicket 票务
     * @return 结果
     */
    @Override
    public int insertTravelTicket(TravelTicket travelTicket)
    {
        travelTicket.setCreateTime(DateUtils.getNowDate());
        return travelTicketMapper.insertTravelTicket(travelTicket);
    }

    /**
     * 修改票务
     * 
     * @param travelTicket 票务
     * @return 结果
     */
    @Override
    public int updateTravelTicket(TravelTicket travelTicket)
    {
        return travelTicketMapper.updateTravelTicket(travelTicket);
    }

    /**
     * 批量删除票务
     * 
     * @param ticketIds 需要删除的票务主键
     * @return 结果
     */
    @Override
    public int deleteTravelTicketByTicketIds(Long[] ticketIds)
    {
        return travelTicketMapper.deleteTravelTicketByTicketIds(ticketIds);
    }

    /**
     * 删除票务信息
     * 
     * @param ticketId 票务主键
     * @return 结果
     */
    @Override
    public int deleteTravelTicketByTicketId(Long ticketId)
    {
        return travelTicketMapper.deleteTravelTicketByTicketId(ticketId);
    }
}
