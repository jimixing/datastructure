package com.jimmy.data.structure.stack;

public class ListStack {
	private int current=0;
	private ListStackNode top;
	
	public boolean isEmpty() {
		return current==0;
	}
	
	public int size() {
		return current;
	}
	
	
	public void push(int data) {
		ListStackNode cur=new ListStackNode();
		cur.setData(data);
		cur.setNext(top);
		top=cur;
		current++;
	}
	
	public int pop() {
		if(!isEmpty()) {
			int tem= top.getData();
			top=top.getNext();
			current--;
			return tem;
		}
		throw new ArrayIndexOutOfBoundsException();
	}
	
	public int top() {
		if(!isEmpty()) {			
			return top.getData();
		}
		throw new ArrayIndexOutOfBoundsException();
	}

}
