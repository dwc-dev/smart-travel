package com.ruoyi.travel.test.controller;

import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.travel.test.domain.TestScenic;
import com.ruoyi.travel.test.service.TestScenicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/test/ticket_buy")
public class TestScenicController extends BaseController {

    @Autowired
    private TestScenicService testScenicService;

    @GetMapping("/list")
    public List<TestScenic> getScenicList(TestScenic testScenic) {
        startPage();
        return testScenicService.getScenicList(testScenic);
    }

    @GetMapping("/ticket")
    public TestScenic selectScenicWithTicketsById(@RequestParam("scenicId") Integer scenicId) {
        return testScenicService.selectScenicWithTicketsById(scenicId);
    }
}
