package com.Assignment.Module7; 
import org.testng.annotations.Test; 
public class TestNGgroup_16 { 
	@Test(groups = {"red"}) 
	public void red1() { 
		System.out.println("This is red1"); 
	} 
	@Test(groups = {"red"}) 
	public void red2() { 
		System.out.println("This is red2"); 
	} 
	@Test(groups = {"red"}) 
	public void red3() {
		System.out.println("This is red3"); 
	} 
	@Test(groups = {"green"}) 
	public void green1() { 
		System.out.println("This is green1"); 
	}
	@Test(groups = {"green"})
	public void green2() {
		System.out.println("This is green2"); 
	} 
	@Test(groups = {"green"}) 
	public void green3() { 
		System.out.println("This is green3");
	}
}