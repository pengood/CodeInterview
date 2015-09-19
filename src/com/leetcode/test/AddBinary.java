package com.leetcode.test;

import com.nowcoder.interview.BuildMinimalBST;

/*
 * Given two binary strings, return their sum (also a binary string).

	For example,
	a = "11"
	b = "1"
	Return "100".
 */
public class AddBinary {
	 public String addBinary(String a, String b) {
	        if(a==null||b==null)
	        	throw new IllegalArgumentException();
	        int a1=toInt(a);
	        int b1=toInt(b);
	        System.out.println(a1+" "+b1);
			return b;
	        
	        
	    }
	private int toInt(String string){
		int num=0;
		for(int i=0;i<string.length();i++){
			char c=string.charAt(i);
			if(c=='1'){
				num=(num<<1)+1;
			}else {
				num<<=1;
			}
		}
		return num;
	}
	
	public static void main(String[] args) {
		AddBinary binary=new AddBinary();
		binary.addBinary("11", "00111111111111111111111111111111111111111111111");
	}
}
