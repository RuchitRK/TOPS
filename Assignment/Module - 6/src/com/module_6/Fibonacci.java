package com.module_6;

import java.util.Scanner;

public class Fibonacci {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the number of terms for the Fibonacci series: ");
        int count = in.nextInt();
        int firstTerm = 0;
        int secondTerm = 1;
        System.out.println("Fibonacci Series " + count + " terms:");
        for (int i = 1; i <= count; i++) {
            System.out.print(firstTerm + " ");
            int nextTerm = firstTerm + secondTerm;
            firstTerm = secondTerm;
            secondTerm = nextTerm;
        }
        in.close();    
    }
}