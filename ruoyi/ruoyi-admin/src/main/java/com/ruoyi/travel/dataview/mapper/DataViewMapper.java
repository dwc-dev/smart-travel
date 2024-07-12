package com.ruoyi.travel.dataview.mapper;

import com.ruoyi.travel.dataview.domain.ProvinceTicketCount;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface DataViewMapper {

    @Select("SELECT s.province AS name, SUM(o.quantity) AS value " +
        "FROM travel_order o " +
        "JOIN travel_ticket t ON o.ticket_id = t.ticket_id " +
        "JOIN travel_scenic s ON t.scenic_id = s.scenic_id " +
        "GROUP BY s.province")
    List<ProvinceTicketCount> getProvinceTicketCount();
}
