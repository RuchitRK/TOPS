package com.module_6;

class MyRunnableThread implements Runnable {
 @Override
 public void run() {
     try {
         for (int i = 1; i <= 5; i++) {
             System.out.println("Runnable Thread is running: " + i);
             Thread.sleep(500); 
         }
     } catch (InterruptedException e) {
         System.out.println("Thread interrupted.");
     }
 }
}

public class RunnableDemo {
 public static void main(String[] args) {
     MyRunnableThread myRunnable = new MyRunnableThread();
     Thread thread = new Thread(myRunnable);
     thread.start();
     System.out.println("Main thread is finished starting the runnable thread.");
 }
}
