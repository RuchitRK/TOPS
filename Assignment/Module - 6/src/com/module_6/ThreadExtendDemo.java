package com.module_6;

class MyThread extends Thread {
 @Override
 public void run() {
     try {
         for (int i = 1; i <= 5; i++) {
             System.out.println("MyThread is running: " + i);
             Thread.sleep(500);
         }
     } catch (InterruptedException e) {
         System.out.println("Thread interrupted.");
     }
 }
}
public class ThreadExtendDemo {
 public static void main(String[] args) {
     MyThread t1 = new MyThread();
     t1.start(); 
     System.out.println("Main thread initiated the child thread.");
 }
}
