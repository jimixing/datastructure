package com.jimmy.data.structure.string;

public class RobinKarp {

   public int robin_karp(String source, String pat, int d,int p) {
	   int len_src=source.length();
	   int len_pat=pat.length();
	   if(len_pat>len_src) return -1;
	   
	   int hash_pat=pat.charAt(0);
	   int hash_src=source.charAt(0);
	   int h=1;
	  
	   for(int i=1;i<len_pat;i++) {
		   hash_pat=(hash_pat*d+pat.charAt(i))%p;
		   hash_src=(hash_src*d+source.charAt(i))%p;  
		   h=(h*d)%p;
	   }
	   
	   for(int s=0;s<len_src-len_pat+1;s++) {
		   if(hash_pat==hash_src) {
			   int count=0;
			   for(int j=0;j<len_pat;j++) {
				   if(source.charAt(s+j)==pat.charAt(j)) {
					   count++;
				   }else {
					   break;
				   }
			   }
			   if(count==pat.length()) return s;
			  
		   }else {
			   hash_src=((hash_src-source.charAt(s)*h%p)*d+source.charAt(s+len_pat))%p;
			   if (hash_src<0)hash_src+=p;
		   }
   
	   } 
	  return -1; 
	   
   }
   
   public static void main(String[] args) {
		String str="fsdfadsfadsfsadfsaf";
		String find="fsad";		
		RobinKarp bf=new RobinKarp();
		int index=bf.robin_karp(str, find, 10, 101);
		System.out.print(index);
	}
}
