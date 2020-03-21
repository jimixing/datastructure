package com.jimmy.data.structure.list;

public class BioList {

	
	
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
			head=head.getNext();
			head.setPre(null);
			return head;
		}
		while(cur.getNext()!=null) {
			if(cur.getData()==delNode.getData()) {
				cur.getNext().setPre(cur.getPre());
				cur.getPre().setNext(cur.getNext());
			}else {
				cur=cur.getNext();
			}
		}
		if(cur.getNext()==null&&cur.getData()==delNode.getData()) {
			cur.getPre().setNext(null);
		}
		
		return head;
		
		
	}
	
	
	public BioListNode insertNode(BioListNode head, BioListNode insertNode, int position) {
			if(head==null) {
				head=insertNode;
				return head;
			}
			int length=listLength(head);
			assert position>=0&&position<=length;
			if(position==0) {
				insertNode.setNext(head);
				head.setPre(insertNode);
				head=insertNode;
				return head;
			}
			BioListNode cur=head;
			int pos=0;
			while(cur.getNext()!=null) {
				if(pos<position) {
					pos++;
					cur=cur.getNext();
				}else {
					break;
				}
			}
			if(cur.getNext()==null) {
				insertNode.setPre(cur);
				cur.setNext(insertNode);
			}else {
				insertNode.setNext(cur.getNext());
				insertNode.setPre(cur);
				cur.getNext().setPre(insertNode);
				cur.setNext(insertNode);
			}
			
			return head;
			
	}
	
	
	public int listLength(BioListNode head) {
		BioListNode cur=head;
		int length=0;
		while(cur!=null) {
			length++;
			cur=cur.getNext();
		}
		return length;
	}
	public void deleteAllNode(BioListNode head) {
		BioListNode cur=head;
		while(cur!=null) {
			BioListNode next=cur.getNext();
			cur=null;
			cur=next;
		}	
	}
	
	public void printList(BioListNode head) {
		BioListNode cur=head;
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


}
