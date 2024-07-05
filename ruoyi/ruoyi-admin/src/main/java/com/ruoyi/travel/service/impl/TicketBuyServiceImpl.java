package com.ruoyi.travel.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.travel.mapper.TicketBuyMapper;
import com.ruoyi.travel.domain.Scenic;
import com.ruoyi.travel.service.ITicketBuyService;

/**
 * 购票Service业务层处理
 *
 * @author dwc
 * @date 2024-07-05
 */
@Service
public class TicketBuyServiceImpl implements ITicketBuyService
{
    @Autowired
    private TicketBuyMapper ticketBuyMapper;

    /**
     * 查询购票
     *
     * @param scenicId 购票主键
     * @return 购票
     */
    @Override
    public Scenic selectScenicByScenicId(Long scenicId)
    {
        return ticketBuyMapper.selectScenicByScenicId(scenicId);
    }

    /**
     * 查询购票列表
     *
     * @param scenic 购票
     * @return 购票
     */
    @Override
    public List<Scenic> selectScenicList(Scenic scenic)
    {
        return ticketBuyMapper.selectScenicList(scenic);
    }

    /**
     * 新增购票
     *
     * @param scenic 购票
     * @return 结果
     */
    @Override
    public int insertScenic(Scenic scenic)
    {
        scenic.setCreateTime(DateUtils.getNowDate());
        return ticketBuyMapper.insertScenic(scenic);
    }

    /**
     * 修改购票
     *
     * @param scenic 购票
     * @return 结果
     */
    @Override
    public int updateScenic(Scenic scenic)
    {
        return ticketBuyMapper.updateScenic(scenic);
    }

    /**
     * 批量删除购票
     *
     * @param scenicIds 需要删除的购票主键
     * @return 结果
     */
    @Override
    public int deleteScenicByScenicIds(Long[] scenicIds)
    {
        return ticketBuyMapper.deleteScenicByScenicIds(scenicIds);
    }

    /**
     * 删除购票信息
     *
     * @param scenicId 购票主键
     * @return 结果
     */
    @Override
    public int deleteScenicByScenicId(Long scenicId)
    {
        return ticketBuyMapper.deleteScenicByScenicId(scenicId);
    }
}
