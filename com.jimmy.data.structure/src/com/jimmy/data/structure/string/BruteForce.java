package com.jimmy.data.structure.string;

public class BruteForce {
	
	public int bruteForce(char[] ch, char[]re) {
		
		for(int i=0;i<ch.length-re.length;i++) {
			int count=0;
			for(int j=0;j<re.length;j++) {
				if(ch[i+count]==re[j]) {
					count++;
				}
			}
			if(count==re.length) {
				return i;
			}
			
		}
		return -1;
		
	}
	
	

	public static void main(String[] args) {
		String str="fsdfadsfadsfsadfsaf";
		String find="fad";
		char[] ch=str.toCharArray();
		char[] re=find.toCharArray();
		
		BruteForce bf=new BruteForce();
		int index=bf.bruteForce(ch, re);
		System.out.print(index);
	}

}
