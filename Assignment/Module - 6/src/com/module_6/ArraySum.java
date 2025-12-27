package com.module_6;

public class ArraySum {
    public static void main(String[] args) {
        int[] num = {10, 20, 30, 40, 50, 60};
        int sum = 0;
        for (int i = 0; i < num.length; i++) {
            sum = sum + num[i];
        }
        System.out.println("The sum of the array elements is: " + sum);
    }
}
