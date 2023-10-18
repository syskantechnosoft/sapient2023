package com.sapient;

public class SelaedClassDemo {
    public static void main(String[] args) {
        Human h1 = new Anjali();
        Human h2 = new Vartika();
        Human h3 = new Manish();
        Human h4 = new Test();
        Human h5 = new Human();

        h1.printName();
        h2.printName();
        h3.printName();
        h4.printName();
        h5.printName();
    }
}


sealed class Human permits Anjali, Manish, Test, Vartika
{
    public void printName()
    {
        System.out.println("Default");
    }
}

non-sealed class Manish extends Human
{
    public void printName()
    {
        System.out.println("Manish Sharma");
    }
}

non-sealed class Vartika extends Human
{
    public void printName()
    {
        System.out.println("Vartika Dadheech");
    }
}

final class Anjali extends Human
{
    public void printName()
    {
        System.out.println("Anjali Sharma");
    }
}

final class Test extends Human {
    public void printName()
    {
        System.out.println("Test");
    }
}





