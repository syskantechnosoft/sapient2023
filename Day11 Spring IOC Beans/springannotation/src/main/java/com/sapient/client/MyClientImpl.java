package com.sapient.client;

import com.sapient.service.MyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("client1")
public class MyClientImpl implements  MyClient{
    @Autowired
    private MyService service1;

    @Override
    public void doSomething() {
        String info = service1.getInfo();
        System.out.println(info);
    }
}
