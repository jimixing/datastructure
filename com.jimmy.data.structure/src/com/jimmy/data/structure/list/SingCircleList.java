package com.jimmy.data.structure.list;

public class SingCircleList {

	
	
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
	
	public SingListNode findLastNode(SingListNode head) {
		if(head.getNext()==head) {
			return head;
		}
		SingListNode cur=head;
		while(cur.getNext()!=head) {
			cur=cur.getNext();
		}
		return cur;
	}
	
	
	public SingListNode deleteNodeByNode(SingListNode head,SingListNode delNode) {
		SingListNode cur=head;
		if(cur.getData()==delNode.getData()) {
			SingListNode lastOne=findLastNode(head);
			lastOne.setNext(head.getNext());
			head=head.getNext();
			return head;
		}
		SingListNode next=head.getNext();
		while(next!=head) {
			if(next.getData()==delNode.getData()) {
				cur.setNext(next.getNext());
			}else {
				cur=cur.getNext();
				next=next.getNext();
			}
		}
		return head;
		
		
	}

	
	
	public SingListNode insertNode(SingListNode head, SingListNode insertNode, int position) {
			if(head==null) {
				insertNode.setNext(insertNode);
				head=insertNode;
				return head;
			}
			int length=listLength(head);
			assert position>=0&&position<=length;
			if(position==0) {
				insertNode.setNext(head);
				head=insertNode;
				return head;
			}
			SingListNode cur=head;
			int pos=0;
			while(cur.getNext()!=head) {
				if(pos<position) {
					pos++;
					cur=cur.getNext();
				}else {
					break;
				}
			}
			insertNode.setNext(cur.getNext());
			cur.setNext(insertNode);
			return head;
			
	}
	
	
	public int listLength(SingListNode head) {
		SingListNode cur=head;
		int length=0;
		while(cur!=null&&cur.getNext()!=head) {
			length++;
			cur=cur.getNext();
		}
		return length;
	}

	
	public void printList(SingListNode head) {
		SingListNode cur=head;
		while(cur.getNext()!=head) {
			System.out.print(cur.getData()+"--->");
			cur=cur.getNext();
		}
		System.out.print(cur.getData());
		System.out.println();
	}


}
