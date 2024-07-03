package com.ruoyi.travel.service;

import java.util.List;
import com.ruoyi.travel.domain.Scenic;

/**
 * 景区管理Service接口
 * 
 * @author dwc
 * @date 2024-07-03
 */
public interface IScenicService 
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
     * 批量删除景区管理
     * 
     * @param scenicIds 需要删除的景区管理主键集合
     * @return 结果
     */
    public int deleteScenicByScenicIds(Long[] scenicIds);

    /**
     * 删除景区管理信息
     * 
     * @param scenicId 景区管理主键
     * @return 结果
     */
    public int deleteScenicByScenicId(Long scenicId);
}
