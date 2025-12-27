package com.module_6;

abstract class Parent {
	abstract void message();

}
class FirstSubclass extends Parent {
 @Override
 void message() {
     System.out.println("This is first subclass");
     }
}
class SecondSubclass extends Parent {
	@Override
	void message() {
     System.out.println("This is second subclass");
    }
}
public class AbstractParentDemo {
	public static void main(String[] args) {
	    Parent first = new FirstSubclass();
	    Parent second = new SecondSubclass();
	    first.message();
	    second.message();
	}
}
