package com.ruoyi.travel.test.service.impl;

import com.ruoyi.travel.test.domain.TestScenic;
import com.ruoyi.travel.test.mapper.TestScenicMapper;
import com.ruoyi.travel.test.service.TestScenicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestScenicServiceImpl implements TestScenicService {

    @Autowired
    private TestScenicMapper testScenicMapper;

    @Override
    public List<TestScenic> getScenicList() {
        return testScenicMapper.selectAllScenicWithTickets();
    }

    @Override
    public TestScenic selectScenicWithTicketsById(Integer id) {
        return testScenicMapper.selectScenicWithTicketsById(id);
    }


}
