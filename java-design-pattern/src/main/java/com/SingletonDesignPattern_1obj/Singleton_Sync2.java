package com.SingletonDesignPattern_1obj;

public class Singleton_Sync2 {
	//1. private static - instance type
	//2. public static - return instance
	//3. private constructor
	
	private static Singleton_Sync2 instance;//1

	//not whole method is sync : only for write , for read no blocking
	public static Singleton_Sync2 getInstance() {//2
		if (instance == null) {//for write make sync
			synchronized (Singleton_Sync.class) {
				if (instance == null) {
					instance = new Singleton_Sync2();
				}
			}
		}
		return instance;//for read no sync
	}
	
	private Singleton_Sync2() {	}//3
	
}
