package com.module_6;

import java.util.Scanner;

public class StringConcatenation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the first string: ");
        String str1 = scanner.nextLine();
        System.out.print("Enter the second string: ");
        String str2 = scanner.nextLine();
        String result1 = str1 + " " + str2;
        System.out.println("Using '+' operator: " + result1);
        String result2 = str1.concat(" ").concat(str2);
        System.out.println("Using concat() method: " + result2);
        scanner.close();
    }
}
