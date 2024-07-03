package com.ruoyi.travel.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.travel.domain.Scenic;
import com.ruoyi.travel.service.IScenicService;

import java.util.List;

@RestController
@RequestMapping("/travel-openapi")
public class OpenApiController {

    @Autowired
    private IScenicService scenicService;

    @GetMapping("/scenic")
    public List<Scenic> listScenic() {
        List<Scenic> list = scenicService.selectScenicList(new Scenic());
        return list;
    }
}