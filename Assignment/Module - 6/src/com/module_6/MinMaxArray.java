package com.module_6;

public class MinMaxArray {
    public static void main(String[] args) {
        int[] numbers = {25, 11, 7, 75, 56, 105, 43};
        int max = numbers[0];
        int min = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] > max) {
                max = numbers[i];
            }
            if (numbers[i] < min) {
                min = numbers[i];
            }
        }
        System.out.println("Array Elements: " + java.util.Arrays.toString(numbers));
        System.out.println("Maximum Value: " + max);
        System.out.println("Minimum Value: " + min);
    }
}
