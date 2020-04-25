package com.jimmy.data.structure.hash;

import java.util.Arrays;

import lombok.Data;

public class HashTableOp {

	public static final float FACTOR=0.75f;
	public HashTable hashTable;
	
	public HashTableOp(int size) {
		hashTable =new HashTable(size);
	}
	
	private final int hash(int data) {
		Integer key=new Integer(data);
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }
	
	public boolean search(int data) {
		int key=hash(data);
		int pos=key%hashTable.getSize();
		ListNode tem=hashTable.getHashTable()[pos].getStartNode();
		while(tem!=null) {
			if(tem.getData()==data) {
				return true;
			}
			tem=tem.getNext();
		}
		return false;
	}
	
	
	public void insert(int data) {
		if(search(data)) {
			return ;
		}
		
		int key=hash(data);
		int pos=key%hashTable.getSize();
		
		ListNode node=new ListNode();
		node.setData(data);
		node.setKey(key);
		
		ListNode tem=hashTable.getHashTable()[pos].getStartNode();
		if(tem==null) {
			hashTable.getHashTable()[pos].setStartNode(node);
			hashTable.getHashTable()[pos].setBlockcount(1);
			hashTable.setCount(hashTable.getCount()+1);
		}else {
			while(tem.getNext()!=null) {
				tem=tem.getNext();
			}
			tem.setNext(node);
			hashTable.getHashTable()[pos].setBlockcount(hashTable.getHashTable()[pos].getBlockcount()+1);
		}
		if(hashTable.getCount()>hashTable.getSize()*FACTOR) {
			reHash();
		}
		
	}
	
	
	public void delete(int data) {
		if(!search(data)) {
			return ;
		}
		int key=hash(data);
		int pos=key%hashTable.getSize();
		ListNode start=hashTable.getHashTable()[pos].getStartNode();
		if(start.getData()==data) {
			hashTable.getHashTable()[pos].setStartNode(start.getNext());
		}
		
		ListNode tem2=start;
		while(tem2.getNext()!=null) {
			ListNode tem=tem2.getNext();
			if(tem.getData()==data) {
				tem2.setNext(tem.getNext());
				break;
			}
			tem2=tem;	
		}
		
		hashTable.getHashTable()[pos].setBlockcount(hashTable.getHashTable()[pos].getBlockcount()-1);
		
	}
	
	public void reHash() {
		int oldSize=hashTable.getSize();
		int newSize=oldSize*2;
		HashTable newhashTable =new HashTable(newSize);
		newhashTable.setCount(hashTable.getCount());
	
		for(int i=0;i<hashTable.getCount();i++) {
			ListNode startNode=	hashTable.getHashTable()[i].getStartNode();
			ListNode tem=startNode;
			while(tem!=null) {
				int data=tem.getData();
				int newKey=hash(data);
				int newPos=newKey%newSize;
				ListNode newNode=newhashTable.getHashTable()[newPos].getStartNode();
				ListNode node=new ListNode();
				node.setData(data);
				node.setKey(newKey);
				
				if(newNode==null) {
					newhashTable.getHashTable()[newPos].setStartNode(node);
					newhashTable.getHashTable()[newPos].setBlockcount(1);
				}else {
					while(newNode.getNext()!=null) {
						newNode=newNode.getNext();
					}
					newNode.setNext(node);
					newhashTable.getHashTable()[newPos].setBlockcount(newhashTable.getHashTable()[newPos].getBlockcount()+1);
				}
				tem=tem.getNext();
			}
		}
		hashTable=newhashTable;
		
	}
	public void print() {
		for(int i=0;i<hashTable.size;i++) {
			ListNode node=hashTable.getHashTable()[i].getStartNode();
			if(node==null) {
				System.out.println();
				continue;
			}
			while(node!=null) {
				System.out.print(node.getData()+",");
				node=node.getNext();
			}
			System.out.println();
			
		}
		
		
	}
	
	public static int[]  generateArray() {
		int len=20;
		int [] array=new int[len];
		for(int i=0;i<len;i++) {
			int data=(int)(Math.random()*50);
			array[i]=data;
		}
		System.out.println(Arrays.toString(array));
		return array;
	}
	
	
	public static void main(String[] args) {
		HashTableOp hashtable=new HashTableOp(10);
		int[] array=generateArray();
		for(int i=0;i<array.length;i++) {			
			hashtable.insert(array[i]);
		}
		hashtable.print();
		
		hashtable.delete(array[0]);
		
		hashtable.print();
		
		
	}
	
	
	
	
	
	@Data
	public class ListNode{
		private int key;
		private int data;
		private ListNode next;
		
	}
	
	@Data
	public class HashTableNode{
		
		private int blockcount;	
		private ListNode startNode;

	}
	@Data
	public class HashTable{
		private int size;
		private int count;
		private HashTableNode[] hashTable;
		public HashTable(int size) {
			this.size=size;
			hashTable=new HashTableNode[size];
			for(int i=0;i<size;i++) {
				hashTable[i]=new HashTableNode();
				hashTable[i].setStartNode(null);
			}
		}
		
		
	}

}
