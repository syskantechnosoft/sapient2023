package com.sapient;
@FunctionalInterface
public interface SimpleInterface {
    public void draw();

//    public void print();

    public default void add() {
        System.out.println("add method");
    }

    public default  void sub() {
        System.out.println("sub method");
    }

    public static void display(){

    }
}
