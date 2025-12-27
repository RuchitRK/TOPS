package com.module_6;

import java.util.Scanner;

public class GradeSystem {
    public static void displayGrade(int marks) {
        if (marks >= 91 && marks <= 100) {
            System.out.println("Grade: AA");
        } 
        else if (marks >= 81 && marks <= 90) {
            System.out.println("Grade: AB");
        } 
        else if (marks >= 71 && marks <= 80) {
            System.out.println("Grade: BB");
        } 
        else if (marks >= 61 && marks <= 70) {
            System.out.println("Grade: BC");
        } 
        else if (marks >= 51 && marks <= 60) {
            System.out.println("Grade: CD");
        } 
        else if (marks >= 41 && marks <= 50) {
            System.out.println("Grade: DD");
        } 
        else if (marks <= 40 && marks >= 0) {
            System.out.println("Grade: Fail");
        } 
        else {
            System.out.println("Invalid Input! Please enter marks between 0 and 100.");
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your marks (out of 100): ");
        int userMarks = scanner.nextInt();
        displayGrade(userMarks);
        scanner.close();
    }
}