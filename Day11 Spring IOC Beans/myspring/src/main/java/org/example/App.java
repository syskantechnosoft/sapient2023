package org.example;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

/**
 * Hello world!
 *
 */
public class App 
{
    @Autowired
    private static Trainer t1;
    public static void main( String[] args )
    {
        Employee emp = new Employee();

        //Tightly coupled code
        Employee emp1 = new Employee(100,"ABC", "abc@gmail.com");

        emp.setId(101);
        emp.setName("XYZ");
        emp.setEmail("xyz@gmail.com");
        System.out.println(emp);
        System.out.println(emp1);

        //loosely coupled code

        Resource resource=new ClassPathResource("ApplicationContext.xml");
        BeanFactory factory=new XmlBeanFactory(resource);

      ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");

      //Injecting the bean at runtime
        Employee emp2 = (Employee)factory.getBean("empBean");
        System.out.println(emp2);

        //Injecting the bean at runtime
        Employee emp3 = (Employee) context.getBean("empBean1");
        System.out.println(emp3);

//        System.out.println(App.t1.getId());


    }
}
