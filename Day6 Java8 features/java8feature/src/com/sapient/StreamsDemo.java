package com.sapient;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class StreamsDemo {
    public static void main(String[] args) {
        List<Integer> numberList = new ArrayList<Integer>();
        //AutoBoxing - Java will convert the primitive int value to Integer object
        numberList.add(1);
        numberList.add(6);
        numberList.add(8);
        numberList.add(2);
        numberList.add(4);

        System.out.println(numberList);
        System.out.println("Size of NumberList :"+numberList.size());
        int i=0;
        //Iterating through Arraylist - Normal For Loop
        for (i=0;i<numberList.size();i++)
        {
            System.out.print(numberList.get(i)+" ");
        }

        //Using Enhanced For loop
        for (Integer num:numberList) {
            int n = num.intValue();
            System.out.println(n+1);

        }

        //Using lamdba
        numberList.forEach(n-> System.out.println(n));

        //using method reference
        numberList.forEach(System.out::println);

        //using streams
        long count = numberList.stream().count();
        System.out.println("Count of elements in numberlist :" + count);

        Set nameSet = new HashSet();
        nameSet.add("ABC");
        nameSet.add("XYZ");
        nameSet.add("MNO");
        nameSet.add("PQR");
        nameSet.add("ABC");
        System.out.println(nameSet);
        System.out.println("Size of nameSet :"+nameSet.size());

    }
}
