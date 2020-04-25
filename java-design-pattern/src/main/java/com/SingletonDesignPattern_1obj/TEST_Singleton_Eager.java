package com.SingletonDesignPattern_1obj;

public class TEST_Singleton_Eager {
	public static void main(String[] args) {
		Singleton_EagerConcept instance1 = Singleton_EagerConcept.getInstance();
		System.out.println(instance1);
		
		Singleton_EagerConcept instance2 = Singleton_EagerConcept.getInstance();
		System.out.println(instance2);//same instance as 1st
		
		Singleton_EagerConcept instance3 = Singleton_EagerConcept.getInstance();
		System.out.println(instance3);//same instance as 1st
		
	}
}
