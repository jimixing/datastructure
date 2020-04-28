package com.jimmy.data.structure.string.exam;

public class Exam1 {
	
	public void isHuiWen() {
		String str="abaabXbaaba";
		int i=0,j=str.length()-1;
		boolean isHuiWen=true;
		while(i!=j&&str.charAt(i)!='X'&&str.charAt(j)!='X') {
			if(str.charAt(i)!=str.charAt(j)) {
				isHuiWen=false;
				break;
			}
			i++;
			j--;
		}
		System.out.print(isHuiWen);
		
		
	}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Exam1 ex=new Exam1();
		ex.isHuiWen();
	}

}
