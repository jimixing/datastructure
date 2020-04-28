package com.jimmy.data.structure.string;

public class HashForce {

	
	private int hash(Object key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }
	
	public int robinKarp(String str, String find) {

		int pat=hash(find);
		for(int i=0;i<str.length()-find.length();i++) {
			String tem=str.substring(i, i+find.length());
			if(hash(tem)==pat) {
				return i;
			}
			
		}
		return  -1;
		
	}
	
	
	
	public static void main(String[] args) {
		String str="fsdfadsfadsfsadfsaf";
		String find="fad";
		HashForce hf=new HashForce();
		int index=hf.robinKarp(str, find);
		System.out.print(index);

	}

}
