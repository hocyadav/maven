package com.SingletonDesignPattern_1obj;

public class Singleton_LazyConcept {
	//private static Singleton_LazyConcept singleton_EagerCOnceptObj = new Singleton_LazyConcept();//Eager
	
	//1. private static - instance type
	private static Singleton_LazyConcept obj;//lazy
	
	//2. private constructor - get instance will give instance not by constructor
	private Singleton_LazyConcept() {	}
	
	//2. public static method - get instance
	public static Singleton_LazyConcept getInstance() {
		if (obj == null) {//if null then create new set static obj as new - else dont update obj
			obj = new Singleton_LazyConcept();
		}
		return obj;
	}
}
