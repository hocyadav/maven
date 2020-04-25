package com.SingletonDesignPattern_1obj;

public class Singleton_Sync {
	//1. private static - instance type
	//2. public static - return instance
	//3. private constructor
	
	private static Singleton_Sync instance;//1

	//whole method is sync: i.e. block for both read and write
	public static synchronized Singleton_Sync getInstance() {//2
		if (instance == null) {
			instance = new Singleton_Sync();
		}
		return instance;
	}
	
	private Singleton_Sync() {	}//3
	
}
