package com.jimmy.data.structure.heap.exam;

import java.util.Arrays;

import com.jimmy.data.structure.heap.Heap;

public class Exam1 {

	public Heap generateHeap(int length) {
		Heap heap=new Heap(length,2);
		for(int i=0;i<length;i++) {
			int data=(int)(50*Math.random());
			heap.insert(data);
		}
		System.out.println(heap);
		return heap;
	}
	
	
	public void question7_getMinofHeap() {
		Heap heap=generateHeap(10);

		int[] leaves= heap.getLeave();
		int min=leaves[0];
		for(int i=1;i<leaves.length;i++) {
			if(min>leaves[i]) min=leaves[i];
		}
		System.out.print(min);
		
		
	}
	
	public void question8_deleteNode() {
		Heap heap=generateHeap(10);
		int i=6;
		int[] array=heap.getArray();
		
		array[i]=array[heap.size()-1];
		heap.setSize(heap.size()-1);
		heap.percolateDown(i);
		
		System.out.println(heap);

	}
	
	public void question11_deleteKNode() {
		Heap heap=generateHeap(10);
		int min=26;
		while(heap.getMax()>min) {
			int value=heap.deleteMax();
			System.out.print(value+",");
		}
	}
	
	public void question12_merge2Heap() {
		Heap heap1=new Heap(20,2);
		for(int i=0;i<10;i++) {
			int data=(int)(50*Math.random());
			heap1.insert(data);
		}
		System.out.println(heap1);
		
		Heap heap2=new Heap(10,2);
		for(int i=0;i<10;i++) {
			int data=(int)(50*Math.random());
			heap2.insert(data);
		}
		System.out.println(heap2);
		
		for(int i=0;i<10;i++) {
			int data=heap2.deleteMax();
			heap1.insert(data);
		}
		System.out.println(heap1);

		
		
	}
	
	
	public void question15_KNode() {
		Heap heap=generateHeap(10);
		int k=5;
		int i=0;
		while(i<k) {
			heap.deleteMax();
			i++;
		}
		System.out.print(heap.getMax());
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Exam1 ex=new Exam1();
		ex.question15_KNode();
	}

}
