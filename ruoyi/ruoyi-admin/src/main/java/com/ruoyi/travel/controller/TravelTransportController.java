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
import com.ruoyi.travel.domain.TravelTransport;
import com.ruoyi.travel.service.ITravelTransportService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 景区交通信息，存储景区周边交通信息Controller
 * 
 * @author sj
 * @date 2024-07-12
 */
@RestController
@RequestMapping("/system/transport")
public class TravelTransportController extends BaseController
{
    @Autowired
    private ITravelTransportService travelTransportService;

    /**
     * 查询景区交通信息，存储景区周边交通信息列表
     */
    @PreAuthorize("@ss.hasPermi('system:transport:list')")
    @GetMapping("/list")
    public TableDataInfo list(TravelTransport travelTransport)
    {
        startPage();
        List<TravelTransport> list = travelTransportService.selectTravelTransportList(travelTransport);
        return getDataTable(list);
    }

    /**
     * 导出景区交通信息，存储景区周边交通信息列表
     */
    @PreAuthorize("@ss.hasPermi('system:transport:export')")
    @Log(title = "景区交通信息，存储景区周边交通信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TravelTransport travelTransport)
    {
        List<TravelTransport> list = travelTransportService.selectTravelTransportList(travelTransport);
        ExcelUtil<TravelTransport> util = new ExcelUtil<TravelTransport>(TravelTransport.class);
        util.exportExcel(response, list, "景区交通信息，存储景区周边交通信息数据");
    }

    /**
     * 获取景区交通信息，存储景区周边交通信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:transport:query')")
    @GetMapping(value = "/{transportId}")
    public AjaxResult getInfo(@PathVariable("transportId") Long transportId)
    {
        return success(travelTransportService.selectTravelTransportByTransportId(transportId));
    }

    /**
     * 新增景区交通信息，存储景区周边交通信息
     */
    @PreAuthorize("@ss.hasPermi('system:transport:add')")
    @Log(title = "景区交通信息，存储景区周边交通信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TravelTransport travelTransport)
    {
        return toAjax(travelTransportService.insertTravelTransport(travelTransport));
    }

    /**
     * 修改景区交通信息，存储景区周边交通信息
     */
    @PreAuthorize("@ss.hasPermi('system:transport:edit')")
    @Log(title = "景区交通信息，存储景区周边交通信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TravelTransport travelTransport)
    {
        return toAjax(travelTransportService.updateTravelTransport(travelTransport));
    }

    /**
     * 删除景区交通信息，存储景区周边交通信息
     */
    @PreAuthorize("@ss.hasPermi('system:transport:remove')")
    @Log(title = "景区交通信息，存储景区周边交通信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{transportIds}")
    public AjaxResult remove(@PathVariable Long[] transportIds)
    {
        return toAjax(travelTransportService.deleteTravelTransportByTransportIds(transportIds));
    }
}
