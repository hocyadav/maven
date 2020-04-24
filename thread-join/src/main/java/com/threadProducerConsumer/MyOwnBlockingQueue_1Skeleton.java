package com.threadProducerConsumer;

import java.util.LinkedList;
import java.util.Queue;

public class MyOwnBlockingQueue_1Skeleton<E> {
	Queue<E> queue;
	int size = 16;//default size
	
	public MyOwnBlockingQueue_1Skeleton(int newSize) {
		this.queue = new LinkedList();
		this.size = newSize;
	}
	
	public void put(E obj) {
		queue.add(obj);
	}
	
	
	public E take() {
		E removeItem = queue.remove();
		return removeItem;
	}
}
