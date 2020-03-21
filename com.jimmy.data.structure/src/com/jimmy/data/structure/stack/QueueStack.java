package com.jimmy.data.structure.stack;

import com.jimmy.data.structure.queue.ArrayQueue;

public class QueueStack {
	private ArrayQueue<Integer> aq1=new ArrayQueue<Integer>(Integer.class);
	private ArrayQueue<Integer> aq2=new ArrayQueue<Integer>(Integer.class);
	
	
	public boolean isEmpty() {
		return aq1.isEmpty();
	}
	public int size() {
		return aq1.size();
	}
	
	public void push(int data) {
		if(!aq1.isFull()) {
			aq1.enqueue(data);
			return ;
		}
	}
	
	
	public int pop() {
		while(aq1.size()!=1) {
			aq2.enqueue(aq1.dequeue());
		}
		int data=aq1.dequeue();
		while(!aq2.isEmpty()) {
			aq1.enqueue(aq2.dequeue());
		}
		return data;
	}
	
	

}
