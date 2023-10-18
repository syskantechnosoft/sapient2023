package com.sapient;

public class ExceptionsDemo {
    public static void main(String[] args)  {
        int a =10;
        int numbers[] = {23,12,43,55};
        try {
            System.out.println("Before Exception");
            // Unchecked or Runtime Exception
            System.out.println(a);
            System.out.println(numbers[5]);
            System.out.println("After Exception");
        }
        catch (ArithmeticException ae){
            System.out.println("AE :"+ae.getMessage());
        } catch (RuntimeException re){
            System.out.println("RE:"+ re.getMessage());
        }
        finally {
            System.out.println("this is finally block!!!");
        }

        System.out.println("Program Ends here!!!");

    }
}
