package com.jimmy.data.structure.list;

import java.util.Random;

public class ListUtil {
	
	private final static int LIST_LENGTH=10;
	private static Random random=new Random(100);
	private static SingList singlist=new SingList();
	private static BioCircleList bilcirclelist=new BioCircleList();
	private static BioList billist=new BioList();
	private static SingCircleList singcirclelist=new SingCircleList();
	
	
	public static SingListNode generateSingListWithCircle(int length) {
		
		SingListNode head=ListUtil.generateSingList(length);
		SingListNode circleHead=ListUtil.generateSingCircleList(length, false);
		SingList singlist=new SingList();
		SingListNode lastNode=singlist.findLastNode(head);
		lastNode.setNext(circleHead);
		return head;
		
		
		
	}
	
	
	public static SingListNode generateSingCircleList(int length, boolean isOrder) {
		SingListNode head=null;
		for(int i=0;i<length;i++) {
			SingListNode insertNode=new SingListNode();
			
			int data=isOrder?i:random.nextInt(100);
			insertNode.setData(data);
			head=singcirclelist.insertNode(head, insertNode, i);
		}
		return head;
		
	}
	
	public static SingListNode generateSingList(int length) {
		SingListNode head=null;
		for(int i=0;i<length;i++) {
			SingListNode insertNode=new SingListNode();
			int data=random.nextInt(100);
			insertNode.setData(data);
			head=singlist.insertNode(head, insertNode, i);
		}
		return head;
		
	}
	
	public static SingListNode generateOrderSingList(int length) {
		SingListNode head=null;
		int data=(int)(10*Math.random());
		for(int i=0;i<length;i++) {
			SingListNode insertNode=new SingListNode();
			int temp=data +(int)(10*Math.random());
			insertNode.setData(data);
			head=singlist.insertNode(head, insertNode, i);
			data=temp;
//			SingListNode insertNode=new SingListNode();
//			int temp=random.nextInt(500);
//			boolean big=true;
//			while(big) {
//				if(data<temp) {
//					insertNode.setData(data);
//					data=temp;
//					break;
//				}else {
//					temp=random.nextInt(500);
//				}
//			}
			
			
		}
		return head;
		
		
	}
	
	
	
	public static BioListNode generateBioCircleList(int length) {
		BioListNode head=null;
		for(int i=0;i<length;i++) {
			BioListNode insertNode=new BioListNode();
			int data=random.nextInt(100);
			insertNode.setData(data);
			head=bilcirclelist.insertNode(head, insertNode, i);
		}
		return head;
	}
	
	
	public static BioListNode generateBioList(int length) {
		BioListNode head=null;
		for(int i=0;i<length;i++) {
			BioListNode insertNode=new BioListNode();
			int data=random.nextInt(100);
			insertNode.setData(data);
			head=billist.insertNode(head, insertNode, i);
		}
		return head;
	}
	
	
	
	public static void main(String[] args) {
//		single list
//		SingListNode head=ListUtil.generateSingList(10);
//		singlist.printList(head);
//		head=singlist.reverseNode(head);
//		singlist.printList(head);
//		for(int i=0;i<10;i++) {
//			head=singlist.deleteNodeByPosition(head, 0);
//		}
		
//		biocircle list
//		BioListNode head =ListUtil.generateBioCircleList(10);
//		bilcirclelist.printList(head);
		
//		bio list
		BioListNode head =ListUtil.generateBioList(10);
		billist.printList(head);
		
	}

}
