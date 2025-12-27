package com.module_6;

import java.util.ArrayList;

public class RemoveElementDemo {
    public static void main(String[] args) {
        ArrayList<String> fruits = new ArrayList<>();
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Grapes");
        fruits.add("Mango");

        System.out.println("Original List: " + fruits);
        fruits.remove(2);
        System.out.println("After removing 3rd element: " + fruits);
    }
}

