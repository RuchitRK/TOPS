package com.module_6;

public class MultipleCatch {
    public static void main(String[] args) {     
        try {
            int[] numbers = {10, 20, 30, 40, 0};
            int index = 4; 
            int divisor = numbers[index];
            int result = 100 / divisor; 
            System.out.println("Result: " + result);
        } catch (ArithmeticException e) {
            System.out.println("Error: Cannot divide by zero.");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error: You are trying to access an index that doesn't exist.");
        } catch (Exception e) {
            System.out.println("Error: Something else went wrong.");
        }
        System.out.println("Program The END");
    }
}
