package com.sapient;

import com.sapient.client.MyClient;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext();
        appContext.scan("com.sapient");
        appContext.refresh();

        MyClient client = (MyClient) appContext.getBean("client1");
        client.doSomething();
    }
}
