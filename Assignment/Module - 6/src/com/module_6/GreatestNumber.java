package com.module_6;

import java.util.Scanner;

public class GreatestNumber {
	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        System.out.print("Enter three numbers: ");
        int num1 = in.nextInt();
        int num2 = in.nextInt();
        int num3 = in.nextInt();
        
        if (num1 > num2 && num1 > num3)
            System.out.println("The greatest number is: " + num1);
        else if (num2 > num1 && num2 > num3)
            System.out.println("The greatest number is: " + num2);
        else
            System.out.println("The greatest number is: " + num3);
        in.close();
    }
}
