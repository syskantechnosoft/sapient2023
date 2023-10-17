package com.sapient;

import java.util.ArrayList;
import java.util.List;

public class Starter {
    public static void main(String[] args) {
        SimpleInterface si = new SimpleInterface() {
            @Override
            public void draw() {
                System.out.println("From Anonymous Inner class");
            }
        };
        si.draw();
        si.add();
        SimpleInterface si1 = new SimpleInterface() {
            @Override
            public void draw() {
                System.out.println("another Anonymous Inner class implementation");
            }

            @Override
            public void add() {
                SimpleInterface.super.add();
                System.out.println("This is from latest version");
            }
        };
        si1.draw();
        si1.add();

        SimpleInterface si2 = ()->System.out.println("This is lambda implementation");
        si2.draw();


        List<String> list=new ArrayList<String>();
        list.add("ankit");
        list.add("mayank");
        list.add("irfan");
        list.add("jai");

        //lambda implementaion
        System.out.println("Lambda Output");
        list.forEach((n)->System.out.println(n));

        //Method Reference Implementation
        System.out.println("Method Reference Output");
        list.forEach(System.out::println);
    }
}
