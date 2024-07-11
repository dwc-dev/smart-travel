package com.ruoyi.travel.service;

import com.ruoyi.travel.domain.TravelFacility;

import java.util.List;

/**
 * 景区设施，存储景区设施Service接口
 *
 * @author ruoyi
 * @date 2024-07-10
 */
public interface ITravelFacilityService
{
    /**
     * 查询景区设施，存储景区设施
     *
     * @param facilityId 景区设施，存储景区设施主键
     * @return 景区设施，存储景区设施
     */
    public TravelFacility selectTravelFacilityByFacilityId(Long facilityId);

    /**
     * 查询景区设施，存储景区设施列表
     *
     * @param travelFacility 景区设施，存储景区设施
     * @return 景区设施，存储景区设施集合
     */
    public List<TravelFacility> selectTravelFacilityList(TravelFacility travelFacility);

    /**
     * 新增景区设施，存储景区设施
     *
     * @param travelFacility 景区设施，存储景区设施
     * @return 结果
     */
    public int insertTravelFacility(TravelFacility travelFacility);

    /**
     * 修改景区设施，存储景区设施
     *
     * @param travelFacility 景区设施，存储景区设施
     * @return 结果
     */
    public int updateTravelFacility(TravelFacility travelFacility);

    /**
     * 批量删除景区设施，存储景区设施
     *
     * @param facilityIds 需要删除的景区设施，存储景区设施主键集合
     * @return 结果
     */
    public int deleteTravelFacilityByFacilityIds(Long[] facilityIds);

    /**
     * 删除景区设施，存储景区设施信息
     *
     * @param facilityId 景区设施，存储景区设施主键
     * @return 结果
     */
    public int deleteTravelFacilityByFacilityId(Long facilityId);
}
