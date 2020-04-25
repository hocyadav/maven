package com.threadProducerConsumer;

import java.util.Random;

import com.threadProducerConsumer.MyBQImpl.MyOwnBlockingQueue_using_Lock_and_Condition;

public class Producer_Consumer_using_Lock_andCondition {
	public static MyOwnBlockingQueue_using_Lock_and_Condition<Integer> myOwnBlockingQueue = new MyOwnBlockingQueue_using_Lock_and_Condition<Integer>(10);
	
 	public static void main(String[] args) throws InterruptedException {
 		Thread t1 = new Thread(new Runnable() {
			public void run() {
				try {
					producer();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		t1.start();

		
		Thread t2 = new Thread(new Runnable() {
			public void run() {
				try {
					consumer();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		t2.start();
 		
 		
	}
 	
 	
 	public static void producer() throws InterruptedException {//call queue put method
		while (true) {//infinite adding into queue
			Random random = new Random();
			int val = random.nextInt(100);
			myOwnBlockingQueue.put(val);
			System.out.println("producer "+val);
			Thread.sleep(2000);
		}
	}

	public static void consumer() throws InterruptedException {//call queue take method
		while (true) {
			Integer i = myOwnBlockingQueue.take();
			System.out.println("consumer "+i);
		}
	}
 	
 	
 	
}
