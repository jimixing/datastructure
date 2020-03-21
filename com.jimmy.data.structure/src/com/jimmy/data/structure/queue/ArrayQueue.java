package com.jimmy.data.structure.queue;

import java.lang.reflect.Array;

public class ArrayQueue<T> {
	private static final int CAPACITY=30;
	private T[] array=null;
	private int head=0;
	private int tail=0;
	
	
	public ArrayQueue(Class<T>type ) {
		array=(T[])Array.newInstance(type, CAPACITY);
	}
	
	
	public boolean isEmpty() {
		return tail==head;
	}
	
	public boolean isFull() {
		return tail+1==head;
		
	}
	
	public int size() {
		if(tail>=head) return tail-head;
		else {
			return CAPACITY-(head-tail)+1;
		}
	}
	
	public void enqueue(T data) {
		if(!isFull()) {
			array[tail++]=data;
			if(tail==CAPACITY) {
				tail=0;
			}
			return;
		}
		throw new ArrayIndexOutOfBoundsException();

	}
	
	public T dequeue() {
		if(!isEmpty()) {
			T value=array[head++];
			if(head==CAPACITY)head=0;
			return value ;
		}
		throw new ArrayIndexOutOfBoundsException();

	}
	
	public void enqueueAll(T data[]) {
		if(data.length>CAPACITY-size()) {
			throw new ArrayIndexOutOfBoundsException();
		}
		for(int i=0;i<data.length;i++) {
			enqueue(data[i]);
		}
	}
	
	
	public void printQueue() {
		int tem=head;
		while(tem<tail) {
			System.out.print(array[tem]+",");
			tem=tem==CAPACITY?0:tem+1;
		}
		System.out.println();
		
	}
	

}
