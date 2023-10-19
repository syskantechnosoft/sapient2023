package com.sapient.t1.service;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

//import static org.junit.jupiter.api.Assertions.assertTrue;

import org.mockito.Mockito;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class MyServiceTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void doSomething() {
        //assertTrue(true);
        return;
    }

    @Test
    void testDoSomething() {
        MyService myService = new MyService();
        MyService spyService = Mockito.spy(myService);

        when(spyService.doSomething()).thenReturn("Mocked");

        String result = spyService.doSomething();
        assertEquals("Mocked", result);
    }


}