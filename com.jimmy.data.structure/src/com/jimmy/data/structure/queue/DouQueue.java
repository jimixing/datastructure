package com.jimmy.data.structure.queue;

import java.lang.reflect.Array;

public class DouQueue<T> {
	private static final int CAPACITY=30;
	private T[] array=null;
	private int head=0;
	private int tail=0;
	
	public DouQueue(Class<T>type ) {
		array=(T[])Array.newInstance(type, CAPACITY);
	}
	
	
	public boolean isEmpty() {
		return tail==head;
	}
	
	public boolean isFull() {
		return tail+1==head;
		
	}
	
	public T head() {
		return array[head];
	}
	public T tail() {
		return array[tail-1];
	}
	
	public int size() {
		if(tail>=head) return tail-head;
		else {
			return CAPACITY-(head-tail)+1;
		}
	}
	
	public void enqueueHead(T data) {
		if(!isFull()) {
			array[head]=data;
			if(head<0) {
				head=CAPACITY-1;
			}else {
				head--;
			}
			return;
		}
		throw new ArrayIndexOutOfBoundsException();
	}
	
	public void enqueueEnd(T data) {
		if(!isFull()) {
			array[tail++]=data;
			if(tail==CAPACITY) {
				tail=0;
			}
			return;
		}
		throw new ArrayIndexOutOfBoundsException();
	}
	
	public T dequeueHead() {
		if(!isEmpty()) {
			T value=array[head++];
			if(head==CAPACITY)head=0;
			return value ;
		}
		throw new ArrayIndexOutOfBoundsException();
	}
	
	
	public T dequeueEnd() {
		if(!isEmpty()) {
			T value=array[tail--];
			if(tail<0)tail=CAPACITY-1;
			return value ;
		}
		throw new ArrayIndexOutOfBoundsException();
	}
	
	

}
