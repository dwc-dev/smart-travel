package com.ruoyi.travel.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.travel.mapper.TravelTransportMapper;
import com.ruoyi.travel.domain.TravelTransport;
import com.ruoyi.travel.service.ITravelTransportService;

/**
 * 景区交通信息，存储景区周边交通信息Service业务层处理
 * 
 * @author ruoyi
 * @date 2024-07-12
 */
@Service
public class TravelTransportServiceImpl implements ITravelTransportService 
{
    @Autowired
    private TravelTransportMapper travelTransportMapper;

    /**
     * 查询景区交通信息，存储景区周边交通信息
     * 
     * @param transportId 景区交通信息，存储景区周边交通信息主键
     * @return 景区交通信息，存储景区周边交通信息
     */
    @Override
    public TravelTransport selectTravelTransportByTransportId(Long transportId)
    {
        return travelTransportMapper.selectTravelTransportByTransportId(transportId);
    }

    /**
     * 查询景区交通信息，存储景区周边交通信息列表
     * 
     * @param travelTransport 景区交通信息，存储景区周边交通信息
     * @return 景区交通信息，存储景区周边交通信息
     */
    @Override
    public List<TravelTransport> selectTravelTransportList(TravelTransport travelTransport)
    {
        return travelTransportMapper.selectTravelTransportList(travelTransport);
    }

    /**
     * 新增景区交通信息，存储景区周边交通信息
     * 
     * @param travelTransport 景区交通信息，存储景区周边交通信息
     * @return 结果
     */
    @Override
    public int insertTravelTransport(TravelTransport travelTransport)
    {
        return travelTransportMapper.insertTravelTransport(travelTransport);
    }

    /**
     * 修改景区交通信息，存储景区周边交通信息
     * 
     * @param travelTransport 景区交通信息，存储景区周边交通信息
     * @return 结果
     */
    @Override
    public int updateTravelTransport(TravelTransport travelTransport)
    {
        return travelTransportMapper.updateTravelTransport(travelTransport);
    }

    /**
     * 批量删除景区交通信息，存储景区周边交通信息
     * 
     * @param transportIds 需要删除的景区交通信息，存储景区周边交通信息主键
     * @return 结果
     */
    @Override
    public int deleteTravelTransportByTransportIds(Long[] transportIds)
    {
        return travelTransportMapper.deleteTravelTransportByTransportIds(transportIds);
    }

    /**
     * 删除景区交通信息，存储景区周边交通信息信息
     * 
     * @param transportId 景区交通信息，存储景区周边交通信息主键
     * @return 结果
     */
    @Override
    public int deleteTravelTransportByTransportId(Long transportId)
    {
        return travelTransportMapper.deleteTravelTransportByTransportId(transportId);
    }
}
