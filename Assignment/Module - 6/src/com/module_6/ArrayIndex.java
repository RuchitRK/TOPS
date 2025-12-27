package com.module_6;

import java.util.Scanner;

public class ArrayIndex {
    public static void main(String[] args) {
        int[] numbers = {10, 20, 30, 40, 50, 60, 70};
        
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the value to find: ");
        int target = scanner.nextInt();
        int index = -1;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == target) {
                index = i;
                break;
            }
        }
        if (index != -1) {
            System.out.println("Element found at index: " + index);
        } else {
            System.out.println("Element not found in the array.");
        } 
        scanner.close();
    }
}