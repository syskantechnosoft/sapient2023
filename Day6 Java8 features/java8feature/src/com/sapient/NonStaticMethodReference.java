package com.sapient;

interface Sayable {
    void say();
}

public class NonStaticMethodReference {

    public void saySomething() {
        System.out.println("Saying something");
    }

    public static void main(String[] args) {
        NonStaticMethodReference obj1 = new NonStaticMethodReference();
        Sayable s1 = obj1::saySomething;
        s1.say();
    }
}
