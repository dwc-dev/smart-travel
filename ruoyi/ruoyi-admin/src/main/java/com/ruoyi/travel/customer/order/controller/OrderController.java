package com.ruoyi.travel.customer.order.controller;

import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.travel.customer.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test/ticket_order")
public class OrderController extends BaseController {

    @Autowired
    private OrderService orderService;

    @PreAuthorize("@ss.hasPermi('system:customer_ticket_order:list')")
    @GetMapping("/information")
    public TableDataInfo getOrderInformation() {
        startPage();
        Long userId = SecurityUtils.getLoginUser().getUser().getUserId();
        return getDataTable(orderService.getOrderInfoByUserId(userId));
    }
}
