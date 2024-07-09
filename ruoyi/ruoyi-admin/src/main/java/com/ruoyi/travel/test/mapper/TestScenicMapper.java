package com.ruoyi.travel.test.mapper;

import com.ruoyi.travel.test.domain.TestScenic;

import java.util.List;

public interface TestScenicMapper {
    List<TestScenic> selectAllScenicWithTickets(TestScenic testScenic);
    TestScenic selectScenicWithTicketsById(Integer id);
}
