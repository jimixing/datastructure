package com.jimmy.data.structure.queue;

public class QueueUtil {
	
	
	
	public static ArrayQueue<Integer> generateQueue(int length) {
		ArrayQueue<Integer> aq=new ArrayQueue<Integer>(Integer.class);
		for(int i=0;i<length;i++) {
			int data=(int)(50*Math.random());
			aq.enqueue(data);
			
		}
		return aq;
	}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
