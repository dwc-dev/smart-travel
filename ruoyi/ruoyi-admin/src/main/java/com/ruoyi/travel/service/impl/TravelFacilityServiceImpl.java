package com.ruoyi.travel.service.impl;

import java.util.List;

import com.ruoyi.travel.domain.TravelFacility;
import com.ruoyi.travel.mapper.TravelFacilityMapper;
import com.ruoyi.travel.service.ITravelFacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * 景区设施，存储景区设施Service业务层处理
 *
 * @author ruoyi
 * @date 2024-07-10
 */
@Service
public class TravelFacilityServiceImpl implements ITravelFacilityService
{
    @Autowired
    private TravelFacilityMapper travelFacilityMapper;

    /**
     * 查询景区设施，存储景区设施
     *
     * @param facilityId 景区设施，存储景区设施主键
     * @return 景区设施，存储景区设施
     */
    @Override
    public TravelFacility selectTravelFacilityByFacilityId(Long facilityId)
    {
        return travelFacilityMapper.selectTravelFacilityByFacilityId(facilityId);
    }

    /**
     * 查询景区设施，存储景区设施列表
     *
     * @param travelFacility 景区设施，存储景区设施
     * @return 景区设施，存储景区设施
     */
    @Override
    public List<TravelFacility> selectTravelFacilityList(TravelFacility travelFacility)
    {
        return travelFacilityMapper.selectTravelFacilityList(travelFacility);
    }

    /**
     * 新增景区设施，存储景区设施
     *
     * @param travelFacility 景区设施，存储景区设施
     * @return 结果
     */
    @Override
    public int insertTravelFacility(TravelFacility travelFacility)
    {
        return travelFacilityMapper.insertTravelFacility(travelFacility);
    }

    /**
     * 修改景区设施，存储景区设施
     *
     * @param travelFacility 景区设施，存储景区设施
     * @return 结果
     */
    @Override
    public int updateTravelFacility(TravelFacility travelFacility)
    {
        return travelFacilityMapper.updateTravelFacility(travelFacility);
    }

    /**
     * 批量删除景区设施，存储景区设施
     *
     * @param facilityIds 需要删除的景区设施，存储景区设施主键
     * @return 结果
     */
    @Override
    public int deleteTravelFacilityByFacilityIds(Long[] facilityIds)
    {
        return travelFacilityMapper.deleteTravelFacilityByFacilityIds(facilityIds);
    }

    /**
     * 删除景区设施，存储景区设施信息
     *
     * @param facilityId 景区设施，存储景区设施主键
     * @return 结果
     */
    @Override
    public int deleteTravelFacilityByFacilityId(Long facilityId)
    {
        return travelFacilityMapper.deleteTravelFacilityByFacilityId(facilityId);
    }
}
