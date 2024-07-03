package com.ruoyi.travel.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.travel.mapper.ScenicMapper;
import com.ruoyi.travel.domain.Scenic;
import com.ruoyi.travel.service.IScenicService;

/**
 * 景区管理Service业务层处理
 * 
 * @author dwc
 * @date 2024-07-03
 */
@Service
public class ScenicServiceImpl implements IScenicService 
{
    @Autowired
    private ScenicMapper scenicMapper;

    /**
     * 查询景区管理
     * 
     * @param scenicId 景区管理主键
     * @return 景区管理
     */
    @Override
    public Scenic selectScenicByScenicId(Long scenicId)
    {
        return scenicMapper.selectScenicByScenicId(scenicId);
    }

    /**
     * 查询景区管理列表
     * 
     * @param scenic 景区管理
     * @return 景区管理
     */
    @Override
    public List<Scenic> selectScenicList(Scenic scenic)
    {
        return scenicMapper.selectScenicList(scenic);
    }

    /**
     * 新增景区管理
     * 
     * @param scenic 景区管理
     * @return 结果
     */
    @Override
    public int insertScenic(Scenic scenic)
    {
        scenic.setCreateTime(DateUtils.getNowDate());
        return scenicMapper.insertScenic(scenic);
    }

    /**
     * 修改景区管理
     * 
     * @param scenic 景区管理
     * @return 结果
     */
    @Override
    public int updateScenic(Scenic scenic)
    {
        return scenicMapper.updateScenic(scenic);
    }

    /**
     * 批量删除景区管理
     * 
     * @param scenicIds 需要删除的景区管理主键
     * @return 结果
     */
    @Override
    public int deleteScenicByScenicIds(Long[] scenicIds)
    {
        return scenicMapper.deleteScenicByScenicIds(scenicIds);
    }

    /**
     * 删除景区管理信息
     * 
     * @param scenicId 景区管理主键
     * @return 结果
     */
    @Override
    public int deleteScenicByScenicId(Long scenicId)
    {
        return scenicMapper.deleteScenicByScenicId(scenicId);
    }
}
