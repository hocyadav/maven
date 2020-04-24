package com.SingletonDesignPattern_1obj;

//problem : we want only 1 obj throught program
//solution : Singleton
//use case: loggin , cache, drive
public class Singleton_EagerCOncept {
	

	private static Singleton_EagerCOncept singleton_EagerCOnceptObj = new Singleton_EagerCOncept();
	
	//1. private construtore
	
	private Singleton_EagerCOncept() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	//2. public method for get instance
	public Singleton_EagerCOncept getInstance() {
		return singleton_EagerCOnceptObj;
	}
}
