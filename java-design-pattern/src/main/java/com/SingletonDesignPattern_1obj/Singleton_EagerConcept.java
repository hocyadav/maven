package com.SingletonDesignPattern_1obj;

//problem : we want only 1 obj throught program
//solution : Singleton
//use case: logging , cache, drive
public class Singleton_EagerConcept {
	//1. private static - instance
	private static Singleton_EagerConcept singleton_EagerCOnceptObj = new Singleton_EagerConcept();
	
	//3. private constructor - we will get instance from 2, so make constructor private
	private Singleton_EagerConcept() {	}
	
	//2. public static  - to get instance
	public static Singleton_EagerConcept getInstance() {
		return singleton_EagerCOnceptObj;
	}
}
