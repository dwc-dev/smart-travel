package com.ruoyi.travel.dataview.service;

import com.ruoyi.travel.dataview.domain.ProvinceTicketCount;
import com.ruoyi.travel.dataview.mapper.DataViewMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DataViewService {

    @Autowired
    private DataViewMapper dataViewMapper;

    public List<ProvinceTicketCount> getProvinceTicketCount() {
        return dataViewMapper.getProvinceTicketCount();
    }
}
