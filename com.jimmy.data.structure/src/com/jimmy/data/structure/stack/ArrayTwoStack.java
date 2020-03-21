package com.jimmy.data.structure.stack;

import java.lang.reflect.Array;

public class ArrayTwoStack<T> {
	
	private static final int CAPACITY=30;
	private T[] array=null;
	private int s1Top=0;
	private int s2Top=CAPACITY-1;
	
	public ArrayTwoStack(Class<T>type ) {
		array=(T[])Array.newInstance(type, CAPACITY);
	}
	
	public void pushS1(T data) {
		if(!isFull()) {
			array[s1Top++]=data;
			return ;
		}
		throw new ArrayIndexOutOfBoundsException();
	}
	
	
	public T popS1() {
		if(!isS1Empty()) {
			return array[--s1Top];
		}
		throw new ArrayIndexOutOfBoundsException();

	}
	
	public T popS2() {
		if(!isS2Empty()) {
			return array[++s2Top];
		}
		throw new ArrayIndexOutOfBoundsException();

	}
	
	public void pushS2(T data) {
		if(!isFull()) {
			array[s2Top--]=data;
			return ;
		}
		throw new ArrayIndexOutOfBoundsException();
	}
	
	
	public boolean isFull() {

		 return s1Top+1==s2Top;
	}
	public boolean isS1Empty() {
		return s1Top<=0;
	}
	public boolean isS2Empty() {
		return s2Top>=CAPACITY-1;
	}
	

}
