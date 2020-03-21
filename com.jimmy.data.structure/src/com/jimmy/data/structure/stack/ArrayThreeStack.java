package com.jimmy.data.structure.stack;

import java.lang.reflect.Array;

public class ArrayThreeStack<T> {
	private static final int CAPACITY=30;
	private T[] array=null;
	private int s1=0;
	private int s2=CAPACITY-1;
	private int s3Base=CAPACITY/3;
	private int s3=s3Base;
	
	public ArrayThreeStack(Class<T>type ) {
		array=(T[])Array.newInstance(type, CAPACITY);
	}
	
	public void pushS1(T data) {
		if(!isS1Full()) {
			array[s1++]=data;
			return ;
		}else {
			if(s2>s3-2) {
				int temp=s3+1;
				while(temp>s3Base) {
					array[temp]=array[temp-1];
					temp--;
				}
				s3Base++;
				array[s1++]=data;
			}else {
				throw new ArrayIndexOutOfBoundsException();
			}
		}	
	}
	public T popS1() {
		if(!isS1Empty()) {
			T tem=(T) array[s1-1];
			s1--;
			return tem;
		}
		throw new ArrayIndexOutOfBoundsException();
	}
	
	public T popS2() {
		if(!isS2Empty()) {
			T tem=(T) array[++s2];
			return tem;
		}
		throw new ArrayIndexOutOfBoundsException();
	}
	
	public T popS3() {
		if(!isS3Empty()) {
			T tem=(T) array[--s3];
			return tem;
		}
		throw new ArrayIndexOutOfBoundsException();
	}
	
	
	public void pushS2(T data) {
		if(!isS2Full()) {
			array[s2--]=data;
			return ;
		}else {
			if(s3Base>s1+1) {
				int tem=s3Base;
				while(tem<s3) {
					array[tem-1]=array[tem];
					tem++;
				}
			}else {
				throw new ArrayIndexOutOfBoundsException();
			}
			
			
		}
		
	}
	public void pushS3(T data) {
		if(!isS3Full()) {
			array[s3++]=data;
			return ;
		}else {
			if(s3+1>=s2) {
				int tem=s3+1;
				while(tem>s3Base) {
					array[tem]=array[tem-1];
					tem--;
				}
			}else {
				throw new ArrayIndexOutOfBoundsException();
			}
		}
	}
	
	
	
	public boolean isS3Full() {
		return s3+1==s2;
	}
	
	public boolean isS3Empty() {
		return s3==s3Base;
	}
	
	public boolean isS2Full() {
		return s2-1==s3;
	}
	public boolean isS2Empty() {
		return s2>=CAPACITY-1;
	}
	
	public boolean isS1Full() {
		return s1+1==s3Base;
	}
	public boolean isS1Empty() {
		return s1<=0;
	}
	

}
