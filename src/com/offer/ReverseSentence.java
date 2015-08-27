package com.offer;


public class ReverseSentence {
	public static String reserve(String string){
		if(string==null)
			throw new IllegalArgumentException();
		String[] strs=string.split(" ");
		int len=strs.length;
		for(int i=0;i<len/2;i++){
			String tmp=strs[i];
			strs[i]=strs[len-1-i];
			strs[len-1-i]=tmp;
		}
		StringBuilder sbBuilder=new StringBuilder();
		for(int i=0;i<len;i++){
			sbBuilder.append(strs[i]+" ");
		}
		sbBuilder.deleteCharAt(len);
		return sbBuilder.toString();
	}
	public static void main(String[] args) {
		String string="I am a student.";
		System.out.println(reserve(string));
	}
}
