package com.ruoyi.travel.service;

import com.ruoyi.travel.domain.TravelAdvertisement;

import java.util.List;


/**
 * 景区广告，存储景区广告Service接口
 *
 * @author ruoyi
 * @date 2024-07-11
 */
public interface ITravelAdvertisementService
{
    /**
     * 查询景区广告，存储景区广告
     *
     * @param adId 景区广告，存储景区广告主键
     * @return 景区广告，存储景区广告
     */
    public TravelAdvertisement selectTravelAdvertisementByAdId(Long adId);

    /**
     * 查询景区广告，存储景区广告列表
     *
     * @param travelAdvertisement 景区广告，存储景区广告
     * @return 景区广告，存储景区广告集合
     */
    public List<TravelAdvertisement> selectTravelAdvertisementList(TravelAdvertisement travelAdvertisement);

    /**
     * 新增景区广告，存储景区广告
     *
     * @param travelAdvertisement 景区广告，存储景区广告
     * @return 结果
     */
    public int insertTravelAdvertisement(TravelAdvertisement travelAdvertisement);

    /**
     * 修改景区广告，存储景区广告
     *
     * @param travelAdvertisement 景区广告，存储景区广告
     * @return 结果
     */
    public int updateTravelAdvertisement(TravelAdvertisement travelAdvertisement);

    /**
     * 批量删除景区广告，存储景区广告
     *
     * @param adIds 需要删除的景区广告，存储景区广告主键集合
     * @return 结果
     */
    public int deleteTravelAdvertisementByAdIds(Long[] adIds);

    /**
     * 删除景区广告，存储景区广告信息
     *
     * @param adId 景区广告，存储景区广告主键
     * @return 结果
     */
    public int deleteTravelAdvertisementByAdId(Long adId);
}
