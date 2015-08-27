package com.leetcode.test;

public class Combinations {
	public static void combintion(StringBuilder s){
		if(s==null||s.length()==0)
			return;
		int len=s.length();
		int n=1<<len;
		for(int i=1;i<n;i++){
			for(int j=0;j<len;j++){
				int tmp=i;
				if((tmp&(1<<j))!=0)
					System.out.print(s.charAt(j));
			}
			System.out.println();
		}
	}
	public static void main(String[] args){
		StringBuilder s=new StringBuilder();
		s.append("abc");
		combintion(s);
	}

}
