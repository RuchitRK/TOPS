package com.module_6;

import java.util.ArrayList;

public class UpdateArrayList {
    public static void main(String[] args) {
        ArrayList<String> colors = new ArrayList<>();
        colors.add("Red");
        colors.add("Blue");
        colors.add("Yellow");
        colors.add("Orange");
        
        System.out.println("Original List: " + colors);
        colors.set(1, "Green");
        System.out.println("Updated List:  " + colors);
    }
}
