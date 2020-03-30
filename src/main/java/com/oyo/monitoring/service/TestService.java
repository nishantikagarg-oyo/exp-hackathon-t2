package com.oyo.monitoring.service;

import com.oyo.monitoring.annotation.MonitorMethod;
import org.springframework.stereotype.Service;

@Service
public class TestService {

    @MonitorMethod
    public String method1(){
        for (int i = 0; i < 5; i++) {
            System.out.println("Method 1 executing");
        }
        return "done";
    }

    @MonitorMethod
    public void method2(){
        for (int i = 0; i < 3; i++) {
            System.out.println("Method 2 executing");
        }
    }

    @MonitorMethod
    public void method3(){
        for (int i = 0; i < 2; i++) {
            System.out.println("Method 3 executing");
        }
    }
}
