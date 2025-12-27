package com.module_6;

public class Pattern2 {
	    public static void main(String[] args) {
	    	for (int x = 1; x <= 5; x++) {
				for (int y = 1; y <= x; y++) {
					System.out.print(y%2);
				}
				System.out.println();
			}
	    }
}
