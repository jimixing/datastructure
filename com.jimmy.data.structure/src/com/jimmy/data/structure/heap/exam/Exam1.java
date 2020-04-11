package com.jimmy.data.structure.heap.exam;

import java.util.Arrays;

import com.jimmy.data.structure.heap.Heap;
import com.jimmy.data.structure.queue.ArrayQueue;
import com.jimmy.data.structure.queue.DouQueue;

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
	
	public void question21_getLargest10Node() {
		int allData=1000000;
		int single=990;
		int capacity=1000;
		int interval=allData/single;
		Heap[] heaps=new Heap[interval];
		for(int i=0;i<interval-1;i++) {
			if(heaps[i]==null) {
				heaps[i]=new Heap(capacity,2);
			}
			for(int j=0;j<single;j++) {
				int data=(int)(Math.random()*1000000);
				heaps[i].insert(data);
			}
			heaps[i+1]=new Heap(capacity,2);
			int k=0;
			while(k<10) {
				heaps[i+1].insert(heaps[i].deleteMax());
				k++;
			}
			
		}
		
		for(int i=single*interval;i<allData;i++) {
			int data=(int)(Math.random()*10000);
			heaps[interval-1].insert(data);
		}
		int k=0;
		while(k<10) {
		   int value=heaps[interval-1].deleteMax();
		   k++;
		   System.out.print(value+",");
		}
		
		
	}
	
	public void question22_mergeHeap() {
		int k=10;
		int sum=1000;
		int capacity=sum/k;
		Heap totalHeap=new Heap(sum,2);
		Heap[] heaps=new Heap[k];
		for(int i=0;i<k;i++) {
			heaps[i]=new Heap(capacity,2);
			for(int j=0;j<capacity;j++) {
				int data=(int)(Math.random()*10000);
				heaps[i].insert(data);
			}
		}
		for(int j=0;j<heaps.length;j++) {
			while(heaps[j].size()>0) {
				totalHeap.insert(heaps[j].deleteMax());
			}
			
		}
		System.out.print(totalHeap);
		
	}
	
	
	public void question25_MapTwoLargest() {
		Heap heapa=generateHeap(20);
		Heap heapb=generateHeap(20);
		
		int k=5;
		while(k>0) {
			int va=heapa.deleteMax();
			int vb=heapb.deleteMax();
			System.out.println(va+","+vb);
			k--;
		}

	}
	public void question26_TwoHeapOp() {
		Heap heapMax=new Heap(10,2);
		Heap heapMin=new Heap(10,1);
 		for(int i=0;i<10;i++) {
			int data=(int)(50*Math.random());
			heapMax.insert(data);
			heapMin.insert(data);
		}
		System.out.println(heapMax);
		System.out.println(heapMin);
		int max=heapMax.getMax();
		int min=heapMin.getMin();
		System.out.println(max+","+min);
		
	}
	
	
	public void question27_MiddleData() {
		Heap heapMax=new Heap(10,2);
		Heap heapMin=new Heap(10,1);
		int[] arrays=new int[15];
		for(int i=0;i<15;i++) {
			arrays[i]=(int)(Math.random()*50);
		}
		System.out.println(Arrays.toString(arrays));
		for(int j=0;j<15;j++) {
			int data =arrays[j];
			if(heapMax.size()==0) {
				heapMax.insert(data);
			}
			if(heapMin.size()==0) {
				heapMin.insert(data);
			}
			
			if(data>heapMin.getMin()) {
				if(heapMin.size()<=heapMax.size()) {
					heapMin.insert(data);
				}else {
					int tem=heapMin.deleteMin();
					heapMax.insert(tem);
					heapMin.insert(data);
				}
			}else if(data<heapMax.getMax()) {
				if(heapMax.size()<=heapMin.size()) {
					heapMax.insert(data);
				}else{
					int tem=heapMax.deleteMax();
					heapMin.insert(tem);
					heapMax.insert(data);
				}
			}else {
				if(heapMax.size()<heapMin.size()) {
					heapMax.insert(data);
				}else {
					heapMin.insert(data);
				}
			}
		}
		if(heapMax.size()==heapMin.size()) {
			System.out.println((heapMax.getMax()+heapMin.getMin())/2);
		}else {
			System.out.println(heapMin.getMin());
		}	
		
	}
	
	public void question28_windowMax() {
		int[] data=new int[]{2,3,4,2,6,2,5,1};
		int window=3;
		DouQueue<Integer> dq=new DouQueue<Integer>(Integer.class);
		ArrayQueue<Integer> aq=new ArrayQueue<Integer>(Integer.class);
		
		for(int i=0;i<data.length;i++) {
			while(!dq.isEmpty()&&data[dq.tail()]<data[i]) {
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
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Exam1 ex=new Exam1();
		ex.question28_windowMax();
	}

}
