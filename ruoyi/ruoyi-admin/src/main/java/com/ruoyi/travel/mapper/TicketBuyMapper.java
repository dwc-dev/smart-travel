package com.ruoyi.travel.mapper;

import java.util.List;
import com.ruoyi.travel.domain.Scenic;

/**
 * 购票Mapper接口
 *
 * @author dwc
 * @date 2024-07-05
 */
public interface TicketBuyMapper
{
    /**
     * 查询购票
     *
     * @param scenicId 购票主键
     * @return 购票
     */
    public Scenic selectScenicByScenicId(Long scenicId);

    /**
     * 查询购票列表
     *
     * @param scenic 购票
     * @return 购票集合
     */
    public List<Scenic> selectScenicList(Scenic scenic);

    /**
     * 新增购票
     *
     * @param scenic 购票
     * @return 结果
     */
    public int insertScenic(Scenic scenic);

    /**
     * 修改购票
     *
     * @param scenic 购票
     * @return 结果
     */
    public int updateScenic(Scenic scenic);

    /**
     * 删除购票
     *
     * @param scenicId 购票主键
     * @return 结果
     */
    public int deleteScenicByScenicId(Long scenicId);

    /**
     * 批量删除购票
     *
     * @param scenicIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteScenicByScenicIds(Long[] scenicIds);
}
