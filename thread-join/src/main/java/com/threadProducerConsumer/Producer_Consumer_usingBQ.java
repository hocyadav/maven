package com.threadProducerConsumer;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Producer_Consumer_usingBQ {
	
	public static BlockingQueue<Integer> blockingQueue = new LinkedBlockingQueue<Integer>(10);

	public static void main(String[] args) {

		Thread t1 = new Thread(new Runnable() {
			public void run() {
				try {
					producer();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});

		Thread t2 = new Thread(new Runnable() {
			public void run() {
				try {
					consumer();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		
		t1.start();
		t2.start();
		
		//same output as above : coz que is empty and t2 will not get any data from queue
//		t2.start();
//		t1.start();
	}


	public static void producer() throws InterruptedException {//call queue put method
		blockingQueue.put(10);
		System.out.println("producer");
	}

	public static void consumer() throws InterruptedException {//call queue take method
		Integer i = blockingQueue.take();
		System.out.println(i);
		System.out.println("consumer");
	}

}
