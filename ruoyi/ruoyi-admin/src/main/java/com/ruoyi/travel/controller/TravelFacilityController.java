package com.ruoyi.travel.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.travel.domain.TravelFacility;
import com.ruoyi.travel.service.ITravelFacilityService;
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
 * 景区设施，存储景区设施Controller
 *
 * @author ruoyi
 * @date 2024-07-10
 */
@RestController
@RequestMapping("/system/facility")
public class TravelFacilityController extends BaseController
{
    @Autowired
    private ITravelFacilityService travelFacilityService;

    /**
     * 查询景区设施，存储景区设施列表
     */
    @PreAuthorize("@ss.hasPermi('system:facility:list')")
    @GetMapping("/list")
    public TableDataInfo list(TravelFacility travelFacility)
    {
        startPage();
        List<TravelFacility> list = travelFacilityService.selectTravelFacilityList(travelFacility);
        return getDataTable(list);
    }

    /**
     * 导出景区设施，存储景区设施列表
     */
    @PreAuthorize("@ss.hasPermi('system:facility:export')")
    @Log(title = "景区设施，存储景区设施", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TravelFacility travelFacility)
    {
        List<TravelFacility> list = travelFacilityService.selectTravelFacilityList(travelFacility);
        ExcelUtil<TravelFacility> util = new ExcelUtil<TravelFacility>(TravelFacility.class);
        util.exportExcel(response, list, "景区设施，存储景区设施数据");
    }

    /**
     * 获取景区设施，存储景区设施详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:facility:query')")
    @GetMapping(value = "/{facilityId}")
    public AjaxResult getInfo(@PathVariable("facilityId") Long facilityId)
    {
        return success(travelFacilityService.selectTravelFacilityByFacilityId(facilityId));
    }

    /**
     * 新增景区设施，存储景区设施
     */
    @PreAuthorize("@ss.hasPermi('system:facility:add')")
    @Log(title = "景区设施，存储景区设施", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TravelFacility travelFacility)
    {
        return toAjax(travelFacilityService.insertTravelFacility(travelFacility));
    }

    /**
     * 修改景区设施，存储景区设施
     */
    @PreAuthorize("@ss.hasPermi('system:facility:edit')")
    @Log(title = "景区设施，存储景区设施", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TravelFacility travelFacility)
    {
        return toAjax(travelFacilityService.updateTravelFacility(travelFacility));
    }

    /**
     * 删除景区设施，存储景区设施
     */
    @PreAuthorize("@ss.hasPermi('system:facility:remove')")
    @Log(title = "景区设施，存储景区设施", businessType = BusinessType.DELETE)
	@DeleteMapping("/{facilityIds}")
    public AjaxResult remove(@PathVariable Long[] facilityIds)
    {
        return toAjax(travelFacilityService.deleteTravelFacilityByFacilityIds(facilityIds));
    }
}
