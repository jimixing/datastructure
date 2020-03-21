package com.jimmy.data.structure.stack;

import java.lang.reflect.Array;

public class ArrayStack<T> {
	
	private static final int CAPACITY=30;
	private T[] array=null;
	private int current=0;
	
	public ArrayStack(Class<T>type ) {
		array=(T[])Array.newInstance(type, CAPACITY);
	}
	
	public void pushAll(T[] data) {
		assert data.length>=0;
		for(int i=0;i<data.length;i++) {
			push(data[i]);
		}
	}
	
	
	public void push(T data) {
		if(!isFull()) {
			array[current]=data;
			current++;
			return ;
		}
		throw new ArrayIndexOutOfBoundsException();
		
	}
	public T top() {
		if(!isEmpty()) {
			T tem=(T) array[current-1];
			return tem;
		}
		throw new ArrayIndexOutOfBoundsException();

	}
	
	public void printStack() {
		int i=0;
		for(;i<current;i++) {
			System.out.print(array[i]+",");
		}
	}
	
	public T pop() {
		if(!isEmpty()) {
			T tem=(T) array[--current];
			return tem;
		}
		throw new ArrayIndexOutOfBoundsException();
	}
	
	public int size() {
		return current;
	}
	
	public boolean isFull() {
		return current==CAPACITY-1;
		
		
	}
	public boolean isEmpty() {
		return current==0;
	}
	

}
