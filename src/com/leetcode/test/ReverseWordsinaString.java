package com.leetcode.test;
/*
 * Given an input string, reverse the string word by word.

	For example,
	Given s = "the sky is blue",
	return "blue is sky the".
 */
public class ReverseWordsinaString {
	public String reverseWords(String s) {
		if(s==null||s.length()<1)
			return s;
		s=s.trim();
		String[] strings=s.split(" ");
		reverse(strings, 0, strings.length-1);
		StringBuilder builder=new StringBuilder();
		for(int i=0;i<strings.length;i++){
			builder.append(strings[i]+" ");
		}
		System.out.println(builder.length());
		if(builder.charAt(builder.length()-1)==' ')
			builder.deleteCharAt(builder.length()-1);
		return builder.toString().trim();
	}
	private void reverse(String[] strings,int begin,int end){
		while(begin<end){
			String string=strings[begin];
			strings[begin]=strings[end];
			strings[end]=string;
			begin++;
			end--;
		}
	}
	public static void main(String[] args) {
		String s=" ";
		ReverseWordsinaString reverseWordsinaString=new ReverseWordsinaString();
		System.out.println(reverseWordsinaString.reverseWords(s).length());
	}
}
