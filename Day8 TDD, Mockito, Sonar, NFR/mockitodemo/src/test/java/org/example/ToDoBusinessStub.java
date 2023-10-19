package org.example;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class ToDoBusinessStub {

    @Test
    public void test() {

        ToDoService doServiceStub = new ToDoServiceStub();

        ToDoBusiness business = new ToDoBusiness(doServiceStub);

        List<String> retrievedtodos = business.getTodosforSpring(" Dummy ");

        assertEquals(3, retrievedtodos.size());
        System.out.println(" Stub is working correctly...!!");
    }
}
