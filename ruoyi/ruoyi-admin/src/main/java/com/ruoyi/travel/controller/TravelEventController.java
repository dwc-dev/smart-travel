package com.ruoyi.travel.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.travel.domain.TravelEvent;
import com.ruoyi.travel.service.ITravelEventService;
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
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 景区活动，存储景区活动Controller
 *
 * @author ruoyi
 * @date 2024-07-10
 */
@RestController
@RequestMapping("/system/event")
public class TravelEventController extends BaseController
{
    @Autowired
    private ITravelEventService travelEventService;

    /**
     * 查询景区活动，存储景区活动列表
     */
    @PreAuthorize("@ss.hasPermi('system:event:list')")
    @GetMapping("/list")
    public TableDataInfo list(TravelEvent travelEvent)
    {
        startPage();
        List<TravelEvent> list = travelEventService.selectTravelEventList(travelEvent);
        return getDataTable(list);
    }

    /**
     * 导出景区活动，存储景区活动列表
     */
    @PreAuthorize("@ss.hasPermi('system:event:export')")
    @Log(title = "景区活动，存储景区活动", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TravelEvent travelEvent)
    {
        List<TravelEvent> list = travelEventService.selectTravelEventList(travelEvent);
        ExcelUtil<TravelEvent> util = new ExcelUtil<TravelEvent>(TravelEvent.class);
        util.exportExcel(response, list, "景区活动，存储景区活动数据");
    }

    /**
     * 获取景区活动，存储景区活动详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:event:query')")
    @GetMapping(value = "/{eventId}")
    public AjaxResult getInfo(@PathVariable("eventId") Long eventId)
    {
        return success(travelEventService.selectTravelEventByEventId(eventId));
    }

    /**
     * 新增景区活动，存储景区活动
     */
    @PreAuthorize("@ss.hasPermi('system:event:add')")
    @Log(title = "景区活动，存储景区活动", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TravelEvent travelEvent)
    {
        return toAjax(travelEventService.insertTravelEvent(travelEvent));
    }

    /**
     * 修改景区活动，存储景区活动
     */
    @PreAuthorize("@ss.hasPermi('system:event:edit')")
    @Log(title = "景区活动，存储景区活动", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TravelEvent travelEvent)
    {
        return toAjax(travelEventService.updateTravelEvent(travelEvent));
    }

    /**
     * 删除景区活动，存储景区活动
     */
    @PreAuthorize("@ss.hasPermi('system:event:remove')")
    @Log(title = "景区活动，存储景区活动", businessType = BusinessType.DELETE)
	@DeleteMapping("/{eventIds}")
    public AjaxResult remove(@PathVariable Long[] eventIds)
    {
        return toAjax(travelEventService.deleteTravelEventByEventIds(eventIds));
    }
}
