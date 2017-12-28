package com.shuoyi.controller;

import com.shuoyi.Service.CityService;
import com.shuoyi.model.user.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by zhaosy-c on 2017/12/28.
 */
@Controller
@RequestMapping("/api/common")
public class BasicController {

    @Autowired
    private CityService cityService;

    @GetMapping("/test")
    @ResponseBody
    public City testCity(){

        return cityService.getCityByPrimary(1);
    }
}
