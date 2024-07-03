package com.ruoyi.travel.mapper;

import java.util.List;
import com.ruoyi.travel.domain.Scenic;

/**
 * 景区管理Mapper接口
 * 
 * @author dwc
 * @date 2024-07-03
 */
public interface ScenicMapper 
{
    /**
     * 查询景区管理
     * 
     * @param scenicId 景区管理主键
     * @return 景区管理
     */
    public Scenic selectScenicByScenicId(Long scenicId);

    /**
     * 查询景区管理列表
     * 
     * @param scenic 景区管理
     * @return 景区管理集合
     */
    public List<Scenic> selectScenicList(Scenic scenic);

    /**
     * 新增景区管理
     * 
     * @param scenic 景区管理
     * @return 结果
     */
    public int insertScenic(Scenic scenic);

    /**
     * 修改景区管理
     * 
     * @param scenic 景区管理
     * @return 结果
     */
    public int updateScenic(Scenic scenic);

    /**
     * 删除景区管理
     * 
     * @param scenicId 景区管理主键
     * @return 结果
     */
    public int deleteScenicByScenicId(Long scenicId);

    /**
     * 批量删除景区管理
     * 
     * @param scenicIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteScenicByScenicIds(Long[] scenicIds);
}
