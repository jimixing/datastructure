package com.jimmy.data.structure.stack.exam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.jimmy.data.structure.stack.ArrayStack;
import com.jimmy.data.structure.stack.ArrayThreeStack;
import com.jimmy.data.structure.stack.ArrayTwoStack;
import com.jimmy.data.structure.stack.ListStack;
import com.jimmy.data.structure.stack.QueueByStack;
import com.jimmy.data.structure.stack.QueueStack;

public class Exam1 {
	
	public void isMatchforExpress() {
		Map<Character,Character> map=new HashMap<Character,Character>();
		map.put('(', ')');
		map.put('{', '}');
		map.put('[',']');
		map.put(')', '(');
		map.put('}', '{');
		map.put(']', '[');
		
		ArrayStack ls=new ArrayStack(Character.class);
		String expr="[(A+B)]+{(C+D)}";
		char[] array=expr.toCharArray();
		boolean result=true;
		for(int i=0;i<array.length;i++) {
			if(map.get(array[i])!=null) {
				if(ls.isEmpty()) {
					Character value=new Character(array[i]);
					if(value.equals(')')||value.equals('}')||value.equals(']')) {
						result=false;
						break;
					}
					ls.push(array[i]);
					continue;
				}
				Character c=(Character)ls.top();
				if(c.equals(map.get(array[i]))) {
					ls.pop();
				}else {
					Character value=new Character(array[i]);
					if(value.equals(')')||value.equals('}')||value.equals(']')) {
						result=false;
						break;
					}
					ls.push(array[i]);
				}
			}
		}
		
		System.out.println(result&&ls.isEmpty());
	}
	
	public void transformToQianzui() {
		String expr="1+((2+3)*4)-5";
		//String expr="(a+b)*(c+d)";
		ArrayStack<Character> ops=new ArrayStack<Character>(Character.class);
		ArrayStack<Character> data=new ArrayStack<Character>(Character.class);

		char[] array=expr.toCharArray();
		for(int i=array.length-1;i>=0;i--) {
			Character value=new Character(array[i]);
			if(value.equals('+')||value.equals('-')||value.equals('*')||value.equals('/')||value.equals(')')) {
				ops.push(value);
			}else if(value.equals('(')) {
				while(true) {
					Character top=ops.pop();
					if(top.equals(')')) {
						break;
					}
					data.push(top);
				}
			}else {
				data.push(value);
			}	
			
		}
		while(!ops.isEmpty()) {
			data.push(ops.pop());
		}		
		ArrayStack<Character> temp=new ArrayStack<Character>(Character.class);
		
		while(!data.isEmpty()) {
			temp.push(data.pop());
		//	System.out.print(data.pop().charValue());
		}
		ArrayStack<Integer> result=new ArrayStack<Integer>(Integer.class);
		result.push(2);
		result.push(1);

		while(!temp.isEmpty()) {
			Character value=temp.pop();
			if(value.equals('+')||value.equals('-')||value.equals('*')||value.equals('/')) {
				int da1=result.pop();
				int da2=result.pop();
				int res=0;
				if(value.equals('+')) {
					res=da1+da2;
				}else if(value.equals('-')) {
					res=da1-da2;
				}else if(value.equals('*')) {
					res=da1*da2;
				}else if(value.equals('/')) {
					res=da1/da2;
				}
				result.push(res);
				
			}else {
				result.push(Integer.parseInt((value+"").toString()));
			}
		}
		
	}
	
	public void transfrmToHouZhui() {
		String expr="1+((2+3)*4)-5";
		ArrayStack<Character> ops=new ArrayStack<Character>(Character.class);
		ArrayStack<Character> data=new ArrayStack<Character>(Character.class);

		char[] array=expr.toCharArray();
		for(int i=0;i<array.length;i++) {
			Character value=new Character(array[i]);
			if(value.equals('+')||value.equals('-')||value.equals('*')||value.equals('/')||value.equals('(')) {
				ops.push(value);
			}else if(value.equals(')')) {
				while(true) {
					Character top=ops.pop();
					if(top.equals('(')) {
						break;
					}
					data.push(top);
				}
			}else {
				data.push(value);
			}	
			
		}
		while(!ops.isEmpty()) {
			data.push(ops.pop());
		}
		while(!data.isEmpty()) {
			System.out.print(data.pop().charValue());
		}
		
	}
	
	public void getMinByStack2() {
		int count=10;
		int[] data=new int[count];
		while(count>=1) {
			data[count-1]=(int)(30*Math.random());
			count--;
		}
		ArrayStack<Integer> ls=new ArrayStack<Integer>(Integer.class);
		ArrayStack<Integer> temp=new ArrayStack<Integer>(Integer.class);
		ls.push(data[0]);
		temp.push(data[0]);
		for(int i=1;i<data.length;i++) {
			int tem=temp.top();
			if(tem>data[i]) {
				temp.pop();
				temp.push(data[i]);
			}
			ls.push(data[i]);
		}
		System.out.print(temp.top());
		
	}
	
	
	public void isHuiWen2() {
		String str="abaabXbaba";
		ArrayStack<Character> ops1=new ArrayStack<Character>(Character.class);
		ArrayStack<Character> ops2=new ArrayStack<Character>(Character.class);
		char[] array=str.toCharArray();
		for(int i=0,j=array.length-1;i<array.length;i++,j--) {
			if(array[i]!='X') {
				ops1.push(array[i]);
			}
			if(array[j]!='X') {
				ops2.push(array[j]);
			}
		}
		boolean isNum=true;
		while(!ops1.isEmpty()&&!ops2.isEmpty()) {
			if(!ops1.pop().equals(ops2.pop())) {
				isNum=false;
			}
		}
		System.out.println(isNum);
		
	}
	
	
	public void getMinByStack() {
		int count=10;
		int[] data=new int[count];
		while(count>=1) {
			data[count-1]=(int)(30*Math.random());
			count--;
		}
		ArrayStack<Integer> ls=new ArrayStack<Integer>(Integer.class);
		ArrayStack<Integer> temp=new ArrayStack<Integer>(Integer.class);
		ls.push(data[0]);
		for(int i=1;i<data.length;i++) {
			int top=ls.top();
			if(top>=data[i]) {
				ls.push(data[i]);
			}else {
				//int tem=ls.pop();
				while(top<data[i]) {
					temp.push(ls.pop());
					if(ls.isEmpty()) {
						break;
					}
					top=ls.top();
				}
				ls.push(data[i]);
				while(!temp.isEmpty()) {
					ls.push(temp.pop());
				}
			}
			
		}
		System.out.println(ls.top());

	}
	
	public void revStack(ArrayStack<Integer> stack) {
		if(stack.isEmpty()) {
			return;
		}
		int value=stack.pop();
		revStack(stack);
		stack.push(value);
		
	}
	
	public void reverseStack() {
		int count=10;
		ArrayStack<Integer> ls=new ArrayStack<Integer>(Integer.class);
		while(count>=1) {
			count--;
			int value=(int)(30*Math.random());
			System.out.print(value+"---->");
			ls.push(value);
		}
		revStack(ls);
		ls.printStack();
//		while(!ls.isEmpty()) {
//			System.out.print(ls.pop()+"---->");
//		}
	}
	
	
	public void queueByStack() {
		QueueByStack queue=new QueueByStack();
		int count=10;
		while(count>=1) {
			count--;
			int value=(int)(30*Math.random());
			System.out.print(value+"---->");
			queue.push(value);
		}
		while(!queue.isEmpty()) {
			System.out.print(queue.peek()+"---->");
		}
	}
	public void arrayTwoStack() {
		ArrayTwoStack<Integer> ats=new ArrayTwoStack<Integer>(Integer.class);
		List<Integer> list=Arrays.asList(new Integer[]{3,4,5,6});
		for(Integer data: list){
			ats.pushS1(data);
		}
		List<Integer> list2=Arrays.asList(new Integer[]{3,4,5,6});
		for(Integer data: list2){
			ats.pushS2(data);
		}
		int data=ats.popS1();
		int data2=ats.popS2();
		System.out.print(data);
		System.out.print(data2);
		List<Integer> list3=Arrays.asList(new Integer[]{3,4,5,6,4,1,2,3,4,4,5,5,5,5,5,2,2,6,});
		for(Integer data5: list3){
			ats.pushS2(data5);
		}
		
	}
	
	public void arrayThreeStack() {
		ArrayThreeStack<Integer> ats =new ArrayThreeStack<Integer>(Integer.class);
		List<Integer> list1=Arrays.asList(new Integer[]{3,4,5,6,4,1,2,3,4,4,5,5,5,5,5,2,2,6});
		for(Integer data5: list1){
			ats.pushS3(data5);
		}
		while(!ats.isS3Empty()) {
			System.out.print(ats.popS3()+",");
		}
		
		
	}
	
	public void printInOutStack() {
		List<Integer> target=Arrays.asList(new Integer[]{1,5,4,6,2,3});
		List<Integer> init=Arrays.asList(new Integer[]{1,2,3,4,5,6});
		ArrayStack<Integer> tar=new ArrayStack<Integer>(Integer.class);
		ArrayStack<Integer> ini=new ArrayStack<Integer>(Integer.class);

		for(Integer data:target) {
			tar.push(data);
		}
		for(Integer data:init) {
			Integer value=tar.top();
			if(data.intValue()!=value.intValue()) {
				System.out.print("S");
				ini.push(data);
			}else {
				System.out.print("SX");
				ini.push(data);
				ini.pop();
				tar.pop();
				while(!tar.isEmpty()&&!ini.isEmpty()&&tar.top()==ini.top()) {
					System.out.print("X");
					tar.pop();
					ini.pop();
				}
			}
		}
		while(!ini.isEmpty()&&!tar.isEmpty()) {
			if(tar.top()==ini.top()) {
				System.out.print("X");
				tar.pop();
				ini.pop();
			}
			break;
		}
		if(!ini.isEmpty()||!tar.isEmpty()) {
			System.out.println(" could not find!");
		}else {
			System.out.println(" woo successful!");
		}
		
	}
	
	public void calSpan() {
		int[] data=new int[10];
		int[] span=new int[10];
		for(int i=0;i<10;i++) {
			data[i]=(int)(50*Math.random());
		}
		ArrayStack<Integer> as=new ArrayStack<Integer>(Integer.class);
		span[0]=1;
		as.push(1);
		for(int i=1;i<data.length;i++) {
			if(data[i]>data[i-1]) {
				span[i]=1+as.top();
				as.push(span[i]);
			}else {
				while(as.top()!=1) {
					as.pop();
				}
				span[i]=1;
			}
			
			
		}
		System.out.print(Arrays.toString(data));
		System.out.println();
		System.out.print(Arrays.toString(span));
		
	}
	
	public void calMaxZhiFangTu() {
//		int[] data=new int[10];
//		for(int i=0;i<10;i++) {
//			data[i]=(int)(50*Math.random());
//		}
		int[] data=new int[]{3,2,5,6,1,4,4};
		ArrayStack<Integer> as=new ArrayStack<Integer>(Integer.class);
		int maxArea=0;
		for(int i=0;i<data.length;i++) {
			while(!as.isEmpty()&&data[i]<=data[as.top()]) {
				int index=as.pop();
				int left=as.isEmpty()?-1:as.top();
				maxArea=Math.max(maxArea, (i-left-1)*data[index]);
			}
			as.push(i);
		}
		while(!as.isEmpty()) {
			int index=as.pop();
			int left=as.isEmpty()?-1:as.top();
			maxArea=Math.max(maxArea, (data.length-left-1)*data[index]);
			
		}
		System.out.print(maxArea);
		
		
	}
	public void sortedStack() {
		Integer[] data=new Integer[10];
		for(int i=0;i<data.length;i++) {
			data[i]=(int)(50*Math.random());
		}
		System.out.print(Arrays.toString(data));

		ArrayStack<Integer> as=new ArrayStack<Integer>(Integer.class);
		as.pushAll(data);
		
		ArrayStack<Integer> result=new ArrayStack<Integer>(Integer.class);
		int value=as.pop();
		result.push(value);
		while(!as.isEmpty()) {
			while(!result.isEmpty()&&as.top()>result.top()) {
				as.push(result.pop());
			}
			result.push(as.pop());
		}
		result.printStack();
		
	}
	
	public void isMatchNearby() {
		Integer[] data={4,8,-2,-3,11,10,5,6};
		System.out.print(Arrays.toString(data));

		ArrayStack<Integer> as=new ArrayStack<Integer>(Integer.class);
		as.pushAll(data);
		boolean isMatch=true;
		while(!as.isEmpty()) {
			int v1=as.pop();
			if(!as.isEmpty()) {
				int v2=as.pop();
				if(Math.abs(v1-v2)!=1) {
					isMatch=false;
					break;
				}
			}else {
				break;
			}
		}
		System.out.print(isMatch);	
		
	}
	
	public void removeRepeat() {
		Integer[] data={1,9,6,8,8,8,0,1,1,0,6,5};
		System.out.print(Arrays.toString(data));

		ArrayStack<Integer> tem=new ArrayStack<Integer>(Integer.class);
		int count=0;
		tem.push(data[0]);
		for(int i=1;i<data.length;) {
			int val1=tem.top();
			count=0;
			while(i<data.length&&val1==data[i]) {
				i++;
				count++;
			}
			if(count>0) {
				tem.pop();
			}else {
				tem.push(data[i++]);
			}
		}
		tem.printStack();
//		System.out.println(tem.top());
		
		
	}
	public void queueStack() {
		QueueStack qs=new QueueStack();
		qs.push(3);
		qs.push(4);
		int value=qs.pop();
		System.out.print(value);
	}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Exam1 ex=new Exam1();
		ex.queueStack();
	}

}
