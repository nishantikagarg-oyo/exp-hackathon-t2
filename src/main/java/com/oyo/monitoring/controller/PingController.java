package com.oyo.monitoring.controller;

import com.oyo.monitoring.annotation.MonitorMethod;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ping")
public class PingController {

    @MonitorMethod
    @GetMapping
    public String ping() {
        return "success";
    }
}
