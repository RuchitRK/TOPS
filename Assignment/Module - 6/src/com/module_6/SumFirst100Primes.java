package com.module_6;

public class SumFirst100Primes {
	public static void main(String[] args) {
        int count = 0;
        int number = 2;
        long sum = 0;
        while (count < 100) {
            if (isPrime(number)) {
                sum += number;
                count++;
            }
            number++;
        }
        System.out.println("The sum of the first 100 prime numbers is: " + sum);
    }
    public static boolean isPrime(int num) {
        if (num <= 1) return false;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}