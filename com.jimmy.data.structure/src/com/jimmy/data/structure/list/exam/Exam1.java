package com.jimmy.data.structure.list.exam;

import java.util.ArrayList;
import java.util.List;

import com.jimmy.data.structure.list.ListUtil;
import com.jimmy.data.structure.list.SingCircleList;
import com.jimmy.data.structure.list.SingList;
import com.jimmy.data.structure.list.SingListNode;

public class Exam1 {

	
	public void question41_JosephRing() {
		SingListNode head=ListUtil.generateSingCircleList(100,true);
		SingCircleList circleList=new SingCircleList();
		circleList.printList(head);
		int interval=2;
		SingListNode cur=head;
		while(circleList.listLength(cur)>interval) {
			int pos=0;
			while(pos<interval) {
				pos++;
				cur=cur.getNext();
			}
			cur.setNext(cur.getNext().getNext());
			cur=cur.getNext();
			
		}
		circleList.printList(cur);
		
	}
	
	
	public void crossLineofTwoList() {
		SingList singlist=new SingList();
	
		SingListNode head1=ListUtil.generateSingList(20);
		singlist.printList(head1);
		SingListNode lastH1=singlist.findLastNode(head1);
		SingListNode head2=ListUtil.generateSingList(10);
		singlist.printList(head2);
		SingListNode lastH2=singlist.findLastNode(head2);
		SingListNode head3=ListUtil.generateSingList(10);
		singlist.printList(head3);
		lastH1.setNext(head3);
		lastH2.setNext(head3);
		
		int lenth1=singlist.listLength(head1);
		int lenth2=singlist.listLength(head2);
		int interval=lenth1-lenth2;
		int pos=0;
		if(interval>0) {
			SingListNode cur1=head1;
			while(pos<interval) {
				pos++;
				cur1=cur1.getNext();
			}
			while(cur1!=head2) {
				cur1=cur1.getNext();
				head2=head2.getNext();
			}
			System.out.println(cur1.getData());
		}else {
			SingListNode cur2=head2;
			while(pos<interval) {
				pos++;
				cur2=cur2.getNext();
			}
			while(cur2!=head1) {
				cur2=cur2.getNext();
				head1=head1.getNext();
			}
			System.out.println(cur2.getData());
		}
	}
	
	public void listCircle() {
		SingListNode head=ListUtil.generateSingListWithCircle(20);
		SingListNode slow=head,fast=head.getNext();
		//is circle
		while(slow!=null&fast!=null&&fast!=slow) {
			slow=slow.getNext();
			if(fast.getNext()==null) {
				System.out.println("Single list!");
				return ;
			}
			fast=fast.getNext().getNext();
		}
		// circle length
		int pos=1;
		fast=fast.getNext();
		while(slow!=fast) {
			pos++;
			fast=fast.getNext();
		}
		System.out.println("list is circle!");
		System.out.print("length is: "+pos);
		
	}
	
	public void question34_sortedSingList() {
		SingList singList=new SingList();
		SingListNode head1=ListUtil.generateOrderSingList(20);
		singList.printList(head1);
		SingListNode head2=ListUtil.generateOrderSingList(20);
		singList.printList(head2);
		SingListNode newHead=head1.getData()>head2.getData()?head2:head1;
		SingListNode cur3=newHead;
		SingListNode cur1=head1,cur2=head2;
		if(newHead==head1) {
			cur1=head1.getNext();
		}
		if(newHead==head2) {
			cur2=head2.getNext();
		}
		
		while(cur1!=null&&cur2!=null) {
			if(cur1.getData()>=cur2.getData()) {
				cur3.setNext(cur2);
				cur2=cur2.getNext();
			}else {
				cur3.setNext(cur1);
				cur1=cur1.getNext();
			}
			cur3=cur3.getNext();
			
		}
		while(cur1!=null) {
			cur3.setNext(cur1);
			cur1=cur1.getNext();
		}
		while(cur2!=null) {
			cur3.setNext(cur2);
			cur2=cur2.getNext();
		}
	
		
		singList.printList(newHead);
	}
	
	public void checkIsPalindromic() {
		int[] array=new int[] {1,2,3,4,3,4,1};
		SingListNode head=null;
		SingList singlist=new SingList();
		for(int i=0;i<array.length;i++) {
			SingListNode insertNode=new SingListNode();
			insertNode.setData(array[i]);
			head=singlist.insertNode(head, insertNode, i);
		}
		
	//	SingListNode head=ListUtil.generateSingList(20);
		SingListNode slow=head,fast=head;
		while(fast!=null) {
			if(fast.getNext()!=null) {
				fast=fast.getNext().getNext();
				slow=slow.getNext();
			}else{
				fast=fast.getNext();
			}
			
		}
		
		SingListNode tail=question16_reverseNode(slow);
		boolean isPalindromic=true;
		while(head!=tail) {
			if(head.getData()!=tail.getData()) {
				isPalindromic=false;
				break;		
			}else {
				head=head.getNext();
				tail=tail.getNext();
			}
		}
		System.out.println(isPalindromic);	
	}
	
	public void question38_exchangeNearbyNode() {
		SingListNode head=ListUtil.generateSingList(20);
		SingList singlist=new SingList();
		singlist.printList(head);

		SingListNode cur=head,next=head.getNext();
		//exchange value
//		while(next!=null) {
//			int tem=cur.getData();
//			cur.setData(next.getData());
//			next.setData(tem);
//			cur=next.getNext();
//			if(cur!=null) {
//				next=cur.getNext();
//			}else {
//				break;
//			}
//			
//		}
//		singlist.printList(head);
//		
		//exchange node
		head=next;
		SingListNode head2=next;
		SingListNode tem=null;
		while(next!=null&&cur!=null) {
			if(next.getNext()!=null) {
				tem=next.getNext();
				next.setNext(cur);
				cur.setNext(tem);
				head2=next.getNext();
				cur=tem;
				next=cur.getNext();	
				if(next==null) {
					head2.setNext(cur);
				}else {
					head2.setNext(next);	
				}
				
			}else {
				next.setNext(cur);
				cur.setNext(null);
				head2.setNext(next);
				next=null;
			}
			
		}
		singlist.printList(head);
	}
	
	public SingListNode question16_reverseNode(SingListNode head) {
		SingListNode temp=null,cur=head,next=null;
		while(cur!=null&&cur.getNext()!=null) {
			next=cur.getNext();
			cur.setNext(temp);
			temp=cur;
			cur=next;
		}
		cur.setNext(temp);
		return cur;
		
	}
	
	
	public void question39_reverseNodeByK2() {
		
		SingListNode head=ListUtil.generateSingList(12);
		int K=4;
		
		SingListNode next=head;
		SingListNode start=head;
		List<SingListNode> list=new ArrayList<SingListNode>();
		while(next!=null) {
			start=next;
			int pos=0;
			while(pos<=K-1) {
				next=next.getNext();
				if(next==null) {
					break;
				}
				pos++;	
			}
			list.add(reverse(start,next));
			if(next==null) {
				break;
			}
		}
		head=list.get(0);
		SingListNode pre=head;
		next=head.getNext();
		while(next!=null) {
			pre=next;
			next=next.getNext();	
		}
		for(int i=1;i<list.size();i++) {
			pre.setNext(list.get(i));
			next=pre.getNext();
			while(next!=null) {
				pre=next;
				next=next.getNext();	
			}
    	}
		SingList singlist=new SingList();
    	singlist.printList(head);
		
		
		
	}
	
	public SingListNode reverse(SingListNode start, SingListNode end) {
		
		SingListNode temp=null,cur=start,next=null;
		while(cur!=null&&cur.getNext()!=end) {
			next=cur.getNext();
			cur.setNext(temp);
			temp=cur;
			cur=next;
		}
		cur.setNext(temp);
		return cur;
				 
		
	}
	
	
	
    public void question39_reverseNodeByk() {
    	
    	SingListNode head=ListUtil.generateSingList(12);
    	int k=3;	
    	SingList singlist=new SingList();
    	singlist.printList(head);

    	int length=singlist.listLength(head);
    	assert k>0&&k<length;
    	int pos=0;
    	
    	SingListNode cur=head,next=null;
    	List<SingListNode> list=new ArrayList<SingListNode>();
    	while(cur!=null&&cur.getNext()!=null) {
    		SingListNode temp=null;
    		while(pos<k&&cur!=null) {
    			next=cur.getNext();
    			cur.setNext(temp);
    			temp=cur;
    			cur=next;
    			pos++;
    		}
    		list.add(temp);
    		pos=0;
    	}
    	head=list.get(0);
    	SingListNode tail=head;
    	while(tail.getNext()!=null) {
    		tail=tail.getNext();
    	}
    	
    	for(int i=1;i<list.size();i++) {
    		tail.setNext(list.get(i));
    		while(tail.getNext()!=null) {
        		tail=tail.getNext();
        	}
    	}
    	singlist.printList(head);

	}
	
	public void findMiddle() {
		SingListNode head=ListUtil.generateSingList(50);
		SingListNode slow=head;
		SingListNode fast=head;
		while(fast!=null) {
			slow=slow.getNext();
			if(fast.getNext()!=null) {
				fast=fast.getNext().getNext();
			}else {
				break;
			}
			
		}
		System.out.print(slow.getData());
	}
	
	
	public void findLastN() {
		SingListNode head=ListUtil.generateSingList(50);
		SingList singList=new SingList();
		SingListNode reverseHead=question16_reverseNode(head);
		singList.printList(reverseHead);
		int lastK=10;
		int pos=1;
		SingListNode cur=reverseHead;
		while(pos<lastK) {
			pos++;
			cur=cur.getNext();
		}
		System.out.print(cur.getData());
		SingListNode reverseBackHead=question16_reverseNode(reverseHead);
		singList.printList(reverseBackHead);
		
	}
	
	public void findLastMod() {
		
		SingListNode head=ListUtil.generateSingList(19);
		SingList singlist=new SingList();
		singlist.printList(head);

		int mod=4;
		SingListNode cur=head;
		SingListNode res=null;
		int pos=0;
		while(cur!=null) {
			pos++;
			while(pos%mod==0) {
				res=cur;
				break;
			}
			cur=cur.getNext();
		}
		System.out.println(res.getData());
		
	}
	
	private SingListNode reverseByNext(SingListNode head) {
		if(head==null||head.getNext()==null) {
			return head;
		}
		SingListNode tem=head.getNext();
		head.setNext(tem.getNext());
		tem.setNext(head);
		head=tem;
		head.getNext().setNext(reverseByNext(head.getNext().getNext()));	
		return head;
	}
	
	public void question32_reverseByNext() {
		
		SingListNode head=ListUtil.generateSingList(10);
		SingList singlist=new SingList();
		singlist.printList(head);
		
		SingListNode res=reverseByNext(head);
		singlist.printList(res);
		
		
	}
	
	
	
	public static void main(String[] arg) {
		Exam1 ex=new Exam1();
		ex.question39_reverseNodeByK2();

	}
	
	

}
