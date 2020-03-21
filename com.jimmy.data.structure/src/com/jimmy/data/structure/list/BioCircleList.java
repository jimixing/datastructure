package com.jimmy.data.structure.list;

public class BioCircleList {
	
	
	public int findNode(BioListNode head, BioListNode findNode) {
		
		BioListNode cur=head;
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
	
	public BioListNode deleteNodeByNode(BioListNode head,BioListNode delNode) {
		BioListNode cur=head;
		if(cur.getData()==delNode.getData()) {
			head.getNext().setPre(head.getPre());
			head.getPre().setNext(head.getNext());
		}
		while(cur.getNext()!=head) {
			if(cur.getData()==delNode.getData()) {
				cur.getNext().setPre(cur.getPre());
				cur.getPre().setNext(cur.getNext());
			}else {
				cur=cur.getNext();
			}
		}
		return head;
		
		
	}
	
	
	public BioListNode insertNode(BioListNode head, BioListNode insertNode, int position) {
			if(head==null) {
				insertNode.setNext(insertNode);
				insertNode.setPre(insertNode);
				head=insertNode;
				return head;
			}
			int length=listLength(head);
			assert position>=0&&position<=length;
			if(position==0) {
				insertNode.setNext(head);
				insertNode.setPre(head.getPre());
				head.getPre().setNext(insertNode);
				head.setPre(insertNode);
				return head;
			}
			BioListNode cur=head;
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
			insertNode.setPre(cur);
			cur.getNext().setPre(insertNode);
			cur.setNext(insertNode);
			return head;
			
	}
	
	
	public int listLength(BioListNode head) {
		BioListNode cur=head;
		int length=0;
		while(cur!=null&&cur.getNext()!=head) {
			length++;
			cur=cur.getNext();
		}
		return length;
	}

	
	public void printList(BioListNode head) {
		BioListNode cur=head;
		while(cur.getNext()!=head) {
			System.out.print(cur.getData()+"--->");
			cur=cur.getNext();
		}
		System.out.print(cur.getData());
		System.out.println();
	}
}
