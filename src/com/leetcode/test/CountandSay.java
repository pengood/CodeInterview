package com.leetcode.test;

import java.util.ArrayList;
import java.util.List;

/*
 *The count-and-say sequence is the sequence of integers beginning as follows:
 1, 11, 21, 1211, 111221, ...

 1 is read off as "one 1" or 11.
 11 is read off as "two 1s" or 21.
 21 is read off as "one 2, then one 1" or 1211.
 Given an integer n, generate the nth sequence.

 Note: The sequence of integers will be represented as a string. 
 */
public class CountandSay {
	public String countAndSay(int n) {
		List<String> list=new ArrayList<String>();
		list.add("1");
		for(int i=1;i<n;i++){
			list.add(helpCount(list.get(i-1)));
		}
		return list.get(n-1);
	}
	private String helpCount(String string){
		StringBuilder builder=new StringBuilder();
		for(int i=0;i<string.length();i++){
			char c=string.charAt(i);
			int num=1;
			while((++i)<string.length()&&string.charAt(i)==c){
				num++;
			}
			builder.append(num).append(c);
			i--;
		}
		return builder.toString();
	}
	public static void main(String[] args) {
		CountandSay say=new CountandSay();
		System.out.println(say.countAndSay(5));
	}
}
