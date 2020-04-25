package com.SingletonDesignPattern_1obj;



public class TEST_Singleton_sync2 {
	public static void main(String[] args) throws InterruptedException {
		Singleton_Sync2 instance = Singleton_Sync2.getInstance();
		System.out.println(instance);

		Singleton_Sync2 instance2 = Singleton_Sync2.getInstance();
		System.out.println(instance2);

		for(int i = 0; i < 1000; i++) {
			new Thread(new Runnable() {
				public void run() {
					Singleton_Sync2 instance3 = Singleton_Sync2.getInstance();
					System.out.println(instance3);
				}
			}).start();
		}
	}
}
