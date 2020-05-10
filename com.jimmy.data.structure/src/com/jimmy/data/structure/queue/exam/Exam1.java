package com.jimmy.data.structure.queue.exam;

import com.jimmy.data.structure.queue.ArrayQueue;
import com.jimmy.data.structure.queue.DouQueue;
import com.jimmy.data.structure.queue.QueueUtil;
import com.jimmy.data.structure.stack.ArrayStack;

public class Exam1 {
	public void question1_reverseQueue() {
		ArrayQueue<Integer> aq=QueueUtil.generateQueue(10);
		aq.printQueue();
		ArrayStack<Integer> as=new  ArrayStack<Integer>(Integer.class);
		while(!aq.isEmpty()) {
			as.push(aq.dequeue());
		}
		while(!as.isEmpty()) {
			aq.enqueue(as.pop());
		}
		aq.printQueue();	
		
	}
	public void question4_maxwindow() {
	//	int[] data=new int[]{1,3,-1,-3,5,3,6,7}; 
		int[] data=new int[]{2,3,4,2,6,2,5,1};
		int window=3;
		DouQueue<Integer> dq=new DouQueue<Integer>(Integer.class);
		ArrayQueue<Integer> aq=new ArrayQueue<Integer>(Integer.class);
		for(int i=0;i<data.length;i++) {
			while(!dq.isEmpty()&&data[i]>data[dq.tail()]) {
				dq.dequeueEnd();
			}
			dq.enqueueEnd(i);
			while(!dq.isEmpty()&&i-dq.head()+1>window) {
				dq.dequeueHead();
			}
			
			if(i+1>=window) {
				aq.enqueue(data[dq.head()]);
			}
		}
		aq.printQueue();
	}
	
	
	public void question5_moveQueueToStack() {
		ArrayQueue<Integer> aq=QueueUtil.generateQueue(10);
		aq.printQueue();
		ArrayStack<Integer> as=new  ArrayStack<Integer>(Integer.class);
		while(!aq.isEmpty()) {
			as.push(aq.dequeue());
		}
		while(!as.isEmpty()) {
			aq.enqueue(as.pop());
		}
		while(!aq.isEmpty()) {
			as.push(aq.dequeue());
		}
		as.printStack();
	}
	
	public void question9_crossFirstHalfAndLastHalf() {
		ArrayQueue<Integer> aq=QueueUtil.generateQueue(10);
		aq.printQueue();
		ArrayStack<Integer> temp=new  ArrayStack<Integer>(Integer.class);
		ArrayStack<Integer> temp2=new  ArrayStack<Integer>(Integer.class);
		int size=aq.size()/2;
		int i=0;
		while(i<size) {
			temp.push(aq.dequeue());
			i++;
		}
		while(!temp.isEmpty()) {
			temp2.push(temp.pop());
		}
		while(!temp2.isEmpty()) {
			aq.enqueue(temp2.pop());
			aq.enqueue(aq.dequeue());
		}
		aq.printQueue();
		
	}
	
	public void question10_reverseFirstKNode() {
		ArrayQueue<Integer> aq=QueueUtil.generateQueue(10);
		aq.printQueue();
		ArrayStack<Integer> temp=new  ArrayStack<Integer>(Integer.class);
		int reversePos=4;
		int i=0;
		while(i<reversePos) {
			temp.push(aq.dequeue());
			i++;
		}
		while(!temp.isEmpty()) {
			aq.enqueue(temp.pop());
		}
		while(i<aq.size()) {
			aq.enqueue(aq.dequeue());
			i++;
		}
		aq.printQueue();
		
	}
	
	public static void main(String[] args) {
		Exam1 ex=new Exam1();
		ex.question10_reverseFirstKNode();
	}

}
