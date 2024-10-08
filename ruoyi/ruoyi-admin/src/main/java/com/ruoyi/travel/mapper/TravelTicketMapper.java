package com.ruoyi.travel.mapper;

import java.util.List;
import com.ruoyi.travel.domain.TravelTicket;

/**
 * 票务Mapper接口
 * 
 * @author dwc
 * @date 2024-07-05
 */
public interface TravelTicketMapper 
{
    /**
     * 查询票务
     * 
     * @param ticketId 票务主键
     * @return 票务
     */
    public TravelTicket selectTravelTicketByTicketId(Long ticketId);

    /**
     * 查询票务列表
     * 
     * @param travelTicket 票务
     * @return 票务集合
     */
    public List<TravelTicket> selectTravelTicketList(TravelTicket travelTicket);

    /**
     * 新增票务
     * 
     * @param travelTicket 票务
     * @return 结果
     */
    public int insertTravelTicket(TravelTicket travelTicket);

    /**
     * 修改票务
     * 
     * @param travelTicket 票务
     * @return 结果
     */
    public int updateTravelTicket(TravelTicket travelTicket);

    /**
     * 删除票务
     * 
     * @param ticketId 票务主键
     * @return 结果
     */
    public int deleteTravelTicketByTicketId(Long ticketId);

    /**
     * 批量删除票务
     * 
     * @param ticketIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTravelTicketByTicketIds(Long[] ticketIds);
}
