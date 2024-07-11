package com.ruoyi.travel.mapper;

import java.util.List;

import com.ruoyi.travel.domain.TravelFacility;

/**
 * 景区设施，存储景区设施Mapper接口
 *
 * @author ruoyi
 * @date 2024-07-10
 */
public interface TravelFacilityMapper {
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
     * 删除景区设施，存储景区设施
     *
     * @param facilityId 景区设施，存储景区设施主键
     * @return 结果
     */
    public int deleteTravelFacilityByFacilityId(Long facilityId);

    /**
     * 批量删除景区设施，存储景区设施
     *
     * @param facilityIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTravelFacilityByFacilityIds(Long[] facilityIds);
}
