package org.example;

//import org.mockito.Mock;

import java.util.Arrays;
import java.util.List;

public class ToDoServiceStub implements ToDoService   {

    @Override
    public List<String> getToDos(String user) {
        return Arrays.asList(" Use Core Java ", " Use Spring Core ", " Use Hibernate ", " Use Spring MVC ", "Use Spring Boot");
    }
}
