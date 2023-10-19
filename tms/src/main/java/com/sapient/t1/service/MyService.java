package com.sapient.t1.service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MyService {

    public String doSomething() {
        log.info("Doing something...");
        return "Done";
    }
}

