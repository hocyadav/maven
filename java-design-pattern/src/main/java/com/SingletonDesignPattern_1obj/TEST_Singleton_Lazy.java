package com.SingletonDesignPattern_1obj;

public class TEST_Singleton_Lazy {
	public static void main(String[] args) {
		Singleton_LazyConcept instance = Singleton_LazyConcept.getInstance();
		System.out.println(instance);
		
		Singleton_LazyConcept instance2 = Singleton_LazyConcept.getInstance();
		System.out.println(instance2);
		
		Singleton_LazyConcept instance3 = Singleton_LazyConcept.getInstance();
		System.out.println(instance3);
		
	}
}
