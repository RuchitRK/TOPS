package com.module_6;

import java.util.ArrayList;

public class ArrayListIteration {
    public static void main(String[] args) {
        ArrayList<String> fruits = new ArrayList<>();
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Cherry");
        fruits.add("Mango");
        System.out.println("Iterate:");
        for (String fruit : fruits) {
            System.out.println(fruit);
        }
        // Alternative
		/*
		 * for (int i = 0; i < fruits.size(); i++) { System.out.println(fruits.get(i));
		 * }
		 */
    }
}
