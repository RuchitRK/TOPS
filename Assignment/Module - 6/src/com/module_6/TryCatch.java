package com.module_6;

import java.util.Scanner;

public class TryCatch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Enter the numerator: ");
            int num1 = scanner.nextInt();
            System.out.print("Enter the denominator: ");
            int num2 = scanner.nextInt();
            int result = num1 / num2;
            System.out.println("Result: " + result);
        } catch (ArithmeticException e) {
            System.out.println("Error: You cannot divide a number by zero 0");
        } catch (Exception e) {
            System.out.println("Error: Invalid input hai. Please enter integers only.");
        }
        System.out.println("Program execution continues normally");
        scanner.close();
    }
}
