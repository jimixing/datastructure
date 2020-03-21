package com.jimmy.data.structure.queue;

import com.jimmy.data.structure.stack.ArrayStack;

public class StackQueue {

	private ArrayStack<Integer> stack1=new ArrayStack<Integer>(Integer.class);
	private ArrayStack<Integer> stack2=new ArrayStack<Integer>(Integer.class);
	
	public int size() {
		return stack1.size();
	}
	
	public void enqueue(int data) {
		stack1.push(data);
	}
	
	public int dequeue() {
		while(!stack1.isEmpty()) {
			stack2.push(stack1.pop());
		}
		int value=stack2.pop();
		while(!stack2.isEmpty()) {
			stack1.push(stack2.pop());
		}
		return value;
	}
	public boolean isEmpty() {
		return stack1.isEmpty();
	}
	
	
	
	



}
