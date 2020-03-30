package com.oyo.monitoring.controller;

import com.oyo.monitoring.service.TestService;
import com.oyo.monitoring.annotation.MonitorMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ping")
public class PingController {

    @Autowired
    TestService testService;

    @MonitorMethod
    @GetMapping
    public String ping() {
        String s = testService.method1();
        testService.method2();
        testService.method3();
//        hgchgc
        return s;
    }

}
