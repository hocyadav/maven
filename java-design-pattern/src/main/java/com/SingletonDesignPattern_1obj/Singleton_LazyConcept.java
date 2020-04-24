package com.SingletonDesignPattern_1obj;

public class Singleton_LazyConcept {
	

	//private static Singleton_LazyConcept singleton_EagerCOnceptObj = new Singleton_LazyConcept();
	private static Singleton_LazyConcept obj;//when we want then only create class
	//1. private construtore
	
	private Singleton_LazyConcept() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	//2. public method for get instance
	public Singleton_LazyConcept getInstance() {
		if (obj == null) {
			return new Singleton_LazyConcept();
		}else {
			return obj;
		}
		
	}
}
