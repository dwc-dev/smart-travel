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
import com.ruoyi.travel.domain.TravelTicket;
import com.ruoyi.travel.service.ITravelTicketService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 票务Controller
 * 
 * @author dwc
 * @date 2024-07-04
 */
@RestController
@RequestMapping("/system/ticket")
public class TravelTicketController extends BaseController
{
    @Autowired
    private ITravelTicketService travelTicketService;

    /**
     * 查询票务列表
     */
    @PreAuthorize("@ss.hasPermi('system:ticket:list')")
    @GetMapping("/list")
    public TableDataInfo list(TravelTicket travelTicket)
    {
        startPage();
        List<TravelTicket> list = travelTicketService.selectTravelTicketList(travelTicket);
        return getDataTable(list);
    }

    /**
     * 导出票务列表
     */
    @PreAuthorize("@ss.hasPermi('system:ticket:export')")
    @Log(title = "票务", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TravelTicket travelTicket)
    {
        List<TravelTicket> list = travelTicketService.selectTravelTicketList(travelTicket);
        ExcelUtil<TravelTicket> util = new ExcelUtil<TravelTicket>(TravelTicket.class);
        util.exportExcel(response, list, "票务数据");
    }

    /**
     * 获取票务详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:ticket:query')")
    @GetMapping(value = "/{ticketId}")
    public AjaxResult getInfo(@PathVariable("ticketId") Long ticketId)
    {
        return success(travelTicketService.selectTravelTicketByTicketId(ticketId));
    }

    /**
     * 新增票务
     */
    @PreAuthorize("@ss.hasPermi('system:ticket:add')")
    @Log(title = "票务", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TravelTicket travelTicket)
    {
        return toAjax(travelTicketService.insertTravelTicket(travelTicket));
    }

    /**
     * 修改票务
     */
    @PreAuthorize("@ss.hasPermi('system:ticket:edit')")
    @Log(title = "票务", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TravelTicket travelTicket)
    {
        return toAjax(travelTicketService.updateTravelTicket(travelTicket));
    }

    /**
     * 删除票务
     */
    @PreAuthorize("@ss.hasPermi('system:ticket:remove')")
    @Log(title = "票务", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ticketIds}")
    public AjaxResult remove(@PathVariable Long[] ticketIds)
    {
        return toAjax(travelTicketService.deleteTravelTicketByTicketIds(ticketIds));
    }
}
