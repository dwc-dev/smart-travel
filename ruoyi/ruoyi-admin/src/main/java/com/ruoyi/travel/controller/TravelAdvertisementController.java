package com.ruoyi.travel.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.travel.domain.TravelAdvertisement;
import com.ruoyi.travel.service.ITravelAdvertisementService;
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
 * 景区广告，存储景区广告Controller
 *
 * @author ruoyi
 * @date 2024-07-11
 */
@RestController
@RequestMapping("/system/advertisement")
public class TravelAdvertisementController extends BaseController
{
    @Autowired
    private ITravelAdvertisementService travelAdvertisementService;

    /**
     * 查询景区广告，存储景区广告列表
     */
    @PreAuthorize("@ss.hasPermi('system:advertisement:list')")
    @GetMapping("/list")
    public TableDataInfo list(TravelAdvertisement travelAdvertisement)
    {
        startPage();
        List<TravelAdvertisement> list = travelAdvertisementService.selectTravelAdvertisementList(travelAdvertisement);
        return getDataTable(list);
    }

    /**
     * 导出景区广告，存储景区广告列表
     */
    @PreAuthorize("@ss.hasPermi('system:advertisement:export')")
    @Log(title = "景区广告，存储景区广告", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TravelAdvertisement travelAdvertisement)
    {
        List<TravelAdvertisement> list = travelAdvertisementService.selectTravelAdvertisementList(travelAdvertisement);
        ExcelUtil<TravelAdvertisement> util = new ExcelUtil<TravelAdvertisement>(TravelAdvertisement.class);
        util.exportExcel(response, list, "景区广告，存储景区广告数据");
    }

    /**
     * 获取景区广告，存储景区广告详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:advertisement:query')")
    @GetMapping(value = "/{adId}")
    public AjaxResult getInfo(@PathVariable("adId") Long adId)
    {
        return success(travelAdvertisementService.selectTravelAdvertisementByAdId(adId));
    }

    /**
     * 新增景区广告，存储景区广告
     */
    @PreAuthorize("@ss.hasPermi('system:advertisement:add')")
    @Log(title = "景区广告，存储景区广告", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TravelAdvertisement travelAdvertisement)
    {
        return toAjax(travelAdvertisementService.insertTravelAdvertisement(travelAdvertisement));
    }

    /**
     * 修改景区广告，存储景区广告
     */
    @PreAuthorize("@ss.hasPermi('system:advertisement:edit')")
    @Log(title = "景区广告，存储景区广告", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TravelAdvertisement travelAdvertisement)
    {
        return toAjax(travelAdvertisementService.updateTravelAdvertisement(travelAdvertisement));
    }

    /**
     * 删除景区广告，存储景区广告
     */
    @PreAuthorize("@ss.hasPermi('system:advertisement:remove')")
    @Log(title = "景区广告，存储景区广告", businessType = BusinessType.DELETE)
	@DeleteMapping("/{adIds}")
    public AjaxResult remove(@PathVariable Long[] adIds)
    {
        return toAjax(travelAdvertisementService.deleteTravelAdvertisementByAdIds(adIds));
    }
}
