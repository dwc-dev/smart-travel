package com.ruoyi.travel.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.travel.domain.Scenic;
import com.ruoyi.travel.service.ITicketBuyService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 购票Controller
 *
 * @author dwc
 * @date 2024-07-05
 */
@RestController
@RequestMapping("/system/ticket_buy")
public class TicketBuyController extends BaseController
{
    @Autowired
    private ITicketBuyService ticketBuyService;

    /**
     * 查询购票列表
     */
    @PreAuthorize("@ss.hasPermi('system:ticket_buy:list')")
    @GetMapping("/list")
    public TableDataInfo list(Scenic scenic)
    {
        startPage();
        List<Scenic> list = ticketBuyService.selectScenicList(scenic);
        return getDataTable(list);
    }

    /**
     * 导出购票列表
     */
    @PreAuthorize("@ss.hasPermi('system:ticket_buy:export')")
    @Log(title = "购票", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Scenic scenic)
    {
        List<Scenic> list = ticketBuyService.selectScenicList(scenic);
        ExcelUtil<Scenic> util = new ExcelUtil<Scenic>(Scenic.class);
        util.exportExcel(response, list, "购票数据");
    }

    /**
     * 获取购票详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:ticket_buy:query')")
    @GetMapping(value = "/{scenicId}")
    public AjaxResult getInfo(@PathVariable("scenicId") Long scenicId)
    {
        return success(ticketBuyService.selectScenicByScenicId(scenicId));
    }

    /**
     * 新增购票
     */
    @PreAuthorize("@ss.hasPermi('system:ticket_buy:add')")
    @Log(title = "购票", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Scenic scenic)
    {
        return toAjax(ticketBuyService.insertScenic(scenic));
    }

    /**
     * 修改购票
     */
    @PreAuthorize("@ss.hasPermi('system:ticket_buy:edit')")
    @Log(title = "购票", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Scenic scenic)
    {
        return toAjax(ticketBuyService.updateScenic(scenic));
    }

    /**
     * 删除购票
     */
    @PreAuthorize("@ss.hasPermi('system:ticket_buy:remove')")
    @Log(title = "购票", businessType = BusinessType.DELETE)
	@DeleteMapping("/{scenicIds}")
    public AjaxResult remove(@PathVariable Long[] scenicIds)
    {
        return toAjax(ticketBuyService.deleteScenicByScenicIds(scenicIds));
    }
}
