package com.ruoyi.travel.mapper;

import com.ruoyi.travel.domain.TravelTransport;

import java.util.List;


/**
 * 景区交通信息，存储景区周边交通Mapper接口
 *
 * @author ruoyi
 * @date 2024-07-12
 */
public interface TravelTransportMapper
{
    /**
     * 查询景区交通信息，存储景区周边交通
     *
     * @param transportId 景区交通信息，存储景区周边交通主键
     * @return 景区交通信息，存储景区周边交通
     */
    public TravelTransport selectTravelTransportByTransportId(Long transportId);

    /**
     * 查询景区交通信息，存储景区周边交通列表
     *
     * @param travelTransport 景区交通信息，存储景区周边交通
     * @return 景区交通信息，存储景区周边交通集合
     */
    public List<TravelTransport> selectTravelTransportList(TravelTransport travelTransport);

    /**
     * 新增景区交通信息，存储景区周边交通
     *
     * @param travelTransport 景区交通信息，存储景区周边交通
     * @return 结果
     */
    public int insertTravelTransport(TravelTransport travelTransport);

    /**
     * 修改景区交通信息，存储景区周边交通
     *
     * @param travelTransport 景区交通信息，存储景区周边交通
     * @return 结果
     */
    public int updateTravelTransport(TravelTransport travelTransport);

    /**
     * 删除景区交通信息，存储景区周边交通
     *
     * @param transportId 景区交通信息，存储景区周边交通主键
     * @return 结果
     */
    public int deleteTravelTransportByTransportId(Long transportId);

    /**
     * 批量删除景区交通信息，存储景区周边交通
     *
     * @param transportIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTravelTransportByTransportIds(Long[] transportIds);
}
