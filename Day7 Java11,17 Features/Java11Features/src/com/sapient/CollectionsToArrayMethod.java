package com.sapient;

import java.util.Arrays;
import java.util.List;

public class CollectionsToArrayMethod {

    public static void main(String[] args) {
        List sampleList = Arrays.asList("Java", "Kotlin");
        String[] sampleArray = (String[]) sampleList.toArray(String[]::new);
        System.out.println(Arrays.toString(sampleArray));
        System.out.println(sampleList);
//        assertThat(sampleArray).containsExactly("Java", "Kotlin");

        //Primitive String representation
        String str = "ABCD";
        //String object representation
        String str1 = new String("XYZ");

        Employee emp = new Employee();

        System.out.println(str);
        System.out.println(str1);
        System.out.println(emp);
        System.out.println(emp.hashCode());
    }
}
