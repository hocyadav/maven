package com.SingletonDesignPattern_1obj;

import java.util.HashSet;
import java.util.Set;

//option + ctrl + R,L,M : rename, extract to Local, extract to Method
//ctrl + 3 : Universal search
//shift + ctrl + O : import (fast import) but to know what to import use below
//ctrl + . : go to error --> ctrl + 1 : get suggestion and fix
public class TEST_Singleton_sync {
	public static void main(String[] args) throws InterruptedException {
		Singleton_Sync instance = Singleton_Sync.getInstance();
		System.out.println(instance);

		Singleton_Sync instance2 = Singleton_Sync.getInstance();
		System.out.println(instance2);

		for(int i = 0; i < 1000; i++) {
			new Thread(new Runnable() {
				public void run() {
					Singleton_Sync instance3 = Singleton_Sync.getInstance();
					System.out.println(instance3);
				}
			}).start();
		}
	}
}
