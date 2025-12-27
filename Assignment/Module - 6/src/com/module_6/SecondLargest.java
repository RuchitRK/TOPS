package com.module_6;

public class SecondLargest {
    public static void main(String[] args) {
        int[] numbers = {10, 20, 4, 45, 99, 99, 20};
        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] > largest) {
                secondLargest = largest;
                largest = numbers[i];
            }
            else if (numbers[i] > secondLargest && numbers[i] != largest) {
                secondLargest = numbers[i];
            }
        }
        System.out.println("Array: " + java.util.Arrays.toString(numbers));
        if (secondLargest == Integer.MIN_VALUE) {
            System.out.println("There is no second largest element.");
        } else {
            System.out.println("The Second Largest element is: " + secondLargest);
        }
    }
}
