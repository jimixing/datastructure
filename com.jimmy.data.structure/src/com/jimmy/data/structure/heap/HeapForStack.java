package com.jimmy.data.structure.heap;

public class HeapForStack {
	private Heap heap;
	
	public HeapForStack(int capacity) {
		heap=new Heap(capacity, 2);
	}
	
	
	public void push(int data) {
		heap.insert(data);
	}
	
	public void top() {
		heap.getMax();
	}
	public int pop() {
		return heap.deleteMax();
	}
	
	public int size() {
		return heap.size();
	}

}
