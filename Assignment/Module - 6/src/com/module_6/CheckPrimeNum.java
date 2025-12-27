package com.module_6;

import java.util.Scanner;

public class CheckPrimeNum {
	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        // Input from user
        System.out.print("Enter a number to check: ");
        int num = in.nextInt();
        
        boolean isPrime = true;

        if (num <= 1) {
            isPrime = false;
        } else {
            for (int i = 2; i <= Math.sqrt(num); i++) {
                if (num % i == 0) {
                    isPrime = false;
                    break;
                }
            }
        }
        if (isPrime) {
            System.out.println(num + " is a Prime number.");
        } else {
            System.out.println(num + " is not a Prime number.");
        }
        in.close();
    }
}
