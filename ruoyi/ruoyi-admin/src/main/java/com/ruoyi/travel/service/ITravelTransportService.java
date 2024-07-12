package com.ruoyi.travel.service;

import java.util.List;
import com.ruoyi.travel.domain.TravelTransport;

/**
 * 景区交通信息，存储景区周边交通信息Service接口
 * 
 * @author sj
 * @date 2024-07-12
 */
public interface ITravelTransportService 
{
    /**
     * 查询景区交通信息，存储景区周边交通信息
     * 
     * @param transportId 景区交通信息，存储景区周边交通信息主键
     * @return 景区交通信息，存储景区周边交通信息
     */
    public TravelTransport selectTravelTransportByTransportId(Long transportId);

    /**
     * 查询景区交通信息，存储景区周边交通信息列表
     * 
     * @param travelTransport 景区交通信息，存储景区周边交通信息
     * @return 景区交通信息，存储景区周边交通信息集合
     */
    public List<TravelTransport> selectTravelTransportList(TravelTransport travelTransport);

    /**
     * 新增景区交通信息，存储景区周边交通信息
     * 
     * @param travelTransport 景区交通信息，存储景区周边交通信息
     * @return 结果
     */
    public int insertTravelTransport(TravelTransport travelTransport);

    /**
     * 修改景区交通信息，存储景区周边交通信息
     * 
     * @param travelTransport 景区交通信息，存储景区周边交通信息
     * @return 结果
     */
    public int updateTravelTransport(TravelTransport travelTransport);

    /**
     * 批量删除景区交通信息，存储景区周边交通信息
     * 
     * @param transportIds 需要删除的景区交通信息，存储景区周边交通信息主键集合
     * @return 结果
     */
    public int deleteTravelTransportByTransportIds(Long[] transportIds);

    /**
     * 删除景区交通信息，存储景区周边交通信息信息
     * 
     * @param transportId 景区交通信息，存储景区周边交通信息主键
     * @return 结果
     */
    public int deleteTravelTransportByTransportId(Long transportId);
}
