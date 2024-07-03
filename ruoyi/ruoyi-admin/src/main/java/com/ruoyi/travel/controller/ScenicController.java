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
import com.ruoyi.travel.service.IScenicService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 景区管理Controller
 * 
 * @author dwc
 * @date 2024-07-03
 */
@RestController
@RequestMapping("/system/scenic")
public class ScenicController extends BaseController
{
    @Autowired
    private IScenicService scenicService;

    /**
     * 查询景区管理列表
     */
    @PreAuthorize("@ss.hasPermi('system:scenic:list')")
    @GetMapping("/list")
    public TableDataInfo list(Scenic scenic)
    {
        startPage();
        List<Scenic> list = scenicService.selectScenicList(scenic);
        return getDataTable(list);
    }

    /**
     * 导出景区管理列表
     */
    @PreAuthorize("@ss.hasPermi('system:scenic:export')")
    @Log(title = "景区管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Scenic scenic)
    {
        List<Scenic> list = scenicService.selectScenicList(scenic);
        ExcelUtil<Scenic> util = new ExcelUtil<Scenic>(Scenic.class);
        util.exportExcel(response, list, "景区管理数据");
    }

    /**
     * 获取景区管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:scenic:query')")
    @GetMapping(value = "/{scenicId}")
    public AjaxResult getInfo(@PathVariable("scenicId") Long scenicId)
    {
        return success(scenicService.selectScenicByScenicId(scenicId));
    }

    /**
     * 新增景区管理
     */
    @PreAuthorize("@ss.hasPermi('system:scenic:add')")
    @Log(title = "景区管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Scenic scenic)
    {
        return toAjax(scenicService.insertScenic(scenic));
    }

    /**
     * 修改景区管理
     */
    @PreAuthorize("@ss.hasPermi('system:scenic:edit')")
    @Log(title = "景区管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Scenic scenic)
    {
        return toAjax(scenicService.updateScenic(scenic));
    }

    /**
     * 删除景区管理
     */
    @PreAuthorize("@ss.hasPermi('system:scenic:remove')")
    @Log(title = "景区管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{scenicIds}")
    public AjaxResult remove(@PathVariable Long[] scenicIds)
    {
        return toAjax(scenicService.deleteScenicByScenicIds(scenicIds));
    }
}
