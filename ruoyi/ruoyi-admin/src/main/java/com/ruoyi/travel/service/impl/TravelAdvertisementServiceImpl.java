package com.ruoyi.travel.service.impl;

import java.util.List;

import com.ruoyi.travel.domain.TravelAdvertisement;
import com.ruoyi.travel.mapper.TravelAdvertisementMapper;
import com.ruoyi.travel.service.ITravelAdvertisementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * 景区广告，存储景区广告Service业务层处理
 *
 * @author ruoyi
 * @date 2024-07-11
 */
@Service
public class TravelAdvertisementServiceImpl implements ITravelAdvertisementService
{
    @Autowired
    private TravelAdvertisementMapper travelAdvertisementMapper;

    /**
     * 查询景区广告，存储景区广告
     *
     * @param adId 景区广告，存储景区广告主键
     * @return 景区广告，存储景区广告
     */
    @Override
    public TravelAdvertisement selectTravelAdvertisementByAdId(Long adId)
    {
        return travelAdvertisementMapper.selectTravelAdvertisementByAdId(adId);
    }

    /**
     * 查询景区广告，存储景区广告列表
     *
     * @param travelAdvertisement 景区广告，存储景区广告
     * @return 景区广告，存储景区广告
     */
    @Override
    public List<TravelAdvertisement> selectTravelAdvertisementList(TravelAdvertisement travelAdvertisement)
    {
        return travelAdvertisementMapper.selectTravelAdvertisementList(travelAdvertisement);
    }

    /**
     * 新增景区广告，存储景区广告
     *
     * @param travelAdvertisement 景区广告，存储景区广告
     * @return 结果
     */
    @Override
    public int insertTravelAdvertisement(TravelAdvertisement travelAdvertisement)
    {
        return travelAdvertisementMapper.insertTravelAdvertisement(travelAdvertisement);
    }

    /**
     * 修改景区广告，存储景区广告
     *
     * @param travelAdvertisement 景区广告，存储景区广告
     * @return 结果
     */
    @Override
    public int updateTravelAdvertisement(TravelAdvertisement travelAdvertisement)
    {
        return travelAdvertisementMapper.updateTravelAdvertisement(travelAdvertisement);
    }

    /**
     * 批量删除景区广告，存储景区广告
     *
     * @param adIds 需要删除的景区广告，存储景区广告主键
     * @return 结果
     */
    @Override
    public int deleteTravelAdvertisementByAdIds(Long[] adIds)
    {
        return travelAdvertisementMapper.deleteTravelAdvertisementByAdIds(adIds);
    }

    /**
     * 删除景区广告，存储景区广告信息
     *
     * @param adId 景区广告，存储景区广告主键
     * @return 结果
     */
    @Override
    public int deleteTravelAdvertisementByAdId(Long adId)
    {
        return travelAdvertisementMapper.deleteTravelAdvertisementByAdId(adId);
    }
}
