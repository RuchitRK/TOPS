package com.module_6;

import java.util.Scanner;

public class StringCompare {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the first string: ");
        String str1 = scanner.nextLine();
        System.out.print("Enter the second string: ");
        String str2 = scanner.nextLine();
        if (str1.equals(str2)) {
            System.out.println("Result: The strings are Equal.");
        } else {
            System.out.println("Result: The strings are Not Equal.");
        }
        int result = str1.compareTo(str2);
        if (result == 0) {
            System.out.println("Comparison: Both strings are identical.");
        } else if (result > 0) {
            System.out.println("Comparison: \"" + str1 + "\" comes after \"" + str2 + "\" alphabetically.");
        } else {
            System.out.println("Comparison: \"" + str1 + "\" comes before \"" + str2 + "\" alphabetically.");
        }
        scanner.close();
    }
}