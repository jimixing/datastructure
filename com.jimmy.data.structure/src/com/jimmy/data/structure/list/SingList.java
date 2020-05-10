package com.jimmy.data.structure.list;

import lombok.Data;

public class SingList {

	
	public SingListNode findLastNode(SingListNode head){
		SingListNode cur=head;
		SingListNode next=head.getNext();
		while(next!=null) {
			cur=cur.getNext();
			next=next.getNext();
		}
		return cur;
		
	}
	
	public int findNode(SingListNode head, SingListNode findNode) {
		SingListNode cur=head;
		int pos=0;
		if(head==null) return 0;
		
		while(cur!=null) {
			if(cur.getData()==findNode.getData()) {
				return pos;
			}
			pos++;
			cur=cur.getNext();
		}
		return 0;
	}
	
	public void deleteAllNode(SingListNode head) {
		SingListNode cur=head;
		while(cur!=null) {
			SingListNode next=cur.getNext();
			cur=null;
			cur=next;
		}	
	}
	
	public SingListNode deleteNodeByNode(SingListNode head,SingListNode delNode) {
		SingListNode cur=head;
		SingListNode next=head.getNext();
		
		if(cur.getData()==delNode.getData()) {
			head=next;
			return head;
		}
		
		while(next!=null) {
			if(next.getData()==delNode.getData()) {
				cur.setNext(next.getNext());
			}else {
				next=next.getNext();
				cur=next.getNext();
			}
		}
		return head;
	}
	
	
	public SingListNode deleteNodeByPosition(SingListNode head, int position) {
		int length=listLength(head);
		assert position>=0&&position<length;
		SingListNode cur=head;
		int pos=0;
		if(position==0) {
			head=cur.getNext();
			return head;
		}
		while(cur!=null&&cur.getNext()!=null) {
			if(pos<=position) {
				pos++;
				cur=cur.getNext();
			}else {
				break;
			}
		}
		if(cur.getNext()==null) {
			cur.setNext(null);
			return head;
		}
		cur.setNext(cur.getNext().getNext());
		return head;
	}
	
	
	public SingListNode insertNode(SingListNode head, SingListNode insertNode , int position) {
		if(head==null) return insertNode;
		int length=listLength(head);
		assert position>=0&&position<length;
		if(position==0) {
			insertNode.setNext(head);
			head=insertNode;
			return head;
		}
		
		SingListNode cur=head;
		int pos=0;
		while(cur!=null&&cur.getNext()!=null) {
			if(pos<=position) {
				pos++;
				cur=cur.getNext();
			}else {
				break;
			}
		}
		if(cur.getNext()==null) {
			insertNode.setNext(null);
		}else {
			insertNode.setNext(cur.getNext());
		}
		cur.setNext(insertNode);
		return head;
	}
	
	public SingListNode insertInHead(SingListNode head, int data) {
		SingListNode insertData=new SingListNode();
		insertData.setData(data);
		return insertNode(head,insertData,0);
	}
	
	
	public SingListNode insertInEnd(SingListNode head, int data) {
		SingListNode insertData=new SingListNode();
		insertData.setData(data);
		int length=listLength(head);
		return insertNode(head,insertData,length);
	}
	
	
	public void printList(SingListNode head) {
		SingListNode cur=head;
		while(cur!=null) {
			if(cur.getNext()==null) {
				System.out.print(cur.getData());
			}else {
				System.out.print(cur.getData()+"--->");
			}
			cur=cur.getNext();
		}
		System.out.println();
	}
	
	
	public int listLength(SingListNode head) {
		int length=0;
		SingListNode cur=head;
		while(cur!=null){
			cur=cur.getNext();
			length++;
		}
		return length;
	}
	
	
	
	
	

}
