package com.sapient;

interface MyInterface {
    void display(String str);
}

public class MethodReference {
    public static void display(String str){
        System.out.println("Static method "+str);
    }

    public static void main(String[] args) {
        MyInterface myInterface = (s)->{
            System.out.println("Lambda Implementation :"+s);
        };
        myInterface.display("ABCD");

        //static method reference
        MyInterface myInterface1 = MethodReference::display;
        myInterface1.display("XYZ");
    }
}


class Employee {

}
