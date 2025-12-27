package com.module_6;

import java.util.Scanner;

public class FindFactorial {
	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter a number to find its factorial: ");
        int number = in.nextInt();
        long factorial = 1;
        if (number < 0) {
            System.out.println("Negative numbers dont have factorials");
        } else {
            for (int i = 1; i <= number; i++) {
                factorial = factorial * i;
            }
            System.out.println("The factorial of " + number + " is: " + factorial);
        }
        in.close();
    }
}
