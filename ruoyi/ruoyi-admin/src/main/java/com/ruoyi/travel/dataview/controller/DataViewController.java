package com.ruoyi.travel.dataview.controller;

import com.ruoyi.travel.dataview.domain.ProvinceTicketCount;
import com.ruoyi.travel.dataview.service.DataViewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/test/data-view/province-ticket-count")
public class DataViewController {

    @Autowired
    private DataViewService dataViewService;

    @GetMapping
    public List<ProvinceTicketCount> getProvinceTicketCount() {
        System.out.println(dataViewService.getProvinceTicketCount());
        return dataViewService.getProvinceTicketCount();
    }
}
