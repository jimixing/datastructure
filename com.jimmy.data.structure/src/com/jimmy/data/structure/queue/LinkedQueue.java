package com.jimmy.data.structure.queue;

public class LinkedQueue {
	private LinkedQueueNode head;
	private LinkedQueueNode tail;
	
	private boolean isEmpty() {
		return head==null;
	}
	
	public void enqueue(int data) {
		if(head==null) {
			head=new LinkedQueueNode();
			head.setData(data);
			tail=head;
		}
		LinkedQueueNode tem=new LinkedQueueNode();
		tem.setData(data);
		tail.setNext(tem);
		tail=tail.getNext();
		
	}
	
	
	
	public int size() {
		LinkedQueueNode tem=head;
		int count=1;
		while(tem!=tail) {
			count++;
			tem=tem.getNext();
		}
		return count; 
	}
	public LinkedQueueNode dequeue() {
		if(!isEmpty()) {
			LinkedQueueNode tem =head;
			head=head.getNext();
			return tem;
		}
		throw new ArrayIndexOutOfBoundsException();
		
	}
	
	public void printQueue() {
		LinkedQueueNode tem=head;
		while(tem!=tail) {
			System.out.print(tem.getData()+",");
			tem=tem.getNext();
		}
		System.out.print(tem.getData()+",");
	}
	
	
	
	

}
