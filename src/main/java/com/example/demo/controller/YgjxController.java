package com.example.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.service.YgjxService;


@Controller
//@RequestMapping("com/test")
public class YgjxController {
    @Autowired
    private YgjxService ygjxService;

    @RequestMapping("test")
    @ResponseBody
    public void test(String userId){
        ygjxService.jxtest(userId);
    }
}
