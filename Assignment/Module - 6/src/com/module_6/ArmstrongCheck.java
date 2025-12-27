package com.module_6;

import java.util.Scanner;

public class ArmstrongCheck {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter a number to check: ");
        int number = in.nextInt();
        int originalNumber = number;
        int sum = 0;
        int remainder;
        while (originalNumber > 0) {
            remainder = originalNumber % 10;
            sum = sum + (remainder * remainder * remainder);
            originalNumber = originalNumber / 10;
        }
        if (sum == number) {
            System.out.println(number + " is an Armstrong number.");
        } else {
            System.out.println(number + " is not an Armstrong number.");
        }
        in.close();
    }
}