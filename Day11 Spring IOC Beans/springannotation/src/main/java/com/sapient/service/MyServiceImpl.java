package com.sapient.service;

import org.springframework.stereotype.Component;

@Component("service1")
public class MyServiceImpl implements  MyService{
    /**
     * @return
     */
    @Override
    public String getInfo() {
        return "Service 1's Info";
    }
}
