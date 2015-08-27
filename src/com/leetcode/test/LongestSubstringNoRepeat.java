package com.leetcode.test;

import java.util.HashMap;


public class LongestSubstringNoRepeat {
	public static int lengthOfLongestSubstring(String s) {
		if (s == null || s == "")
			return 0;
		HashMap<Character, Integer> hashMap=new HashMap<>();
		int last=0;
		int max=0;
		int len=s.length();
		int i;
		for(i=0;i<len;i++){
			Integer cur=hashMap.get(s.charAt(i));
			if(cur==null){
				hashMap.put(s.charAt(i), i);
			}
			else if(cur>=last) {
				int n=i-last;
				if(n>max)
					max=n;
				last=cur+1;
				hashMap.put(s.charAt(i), i);
			}
			else {
				hashMap.put(s.charAt(i), i);
			}
		}
		max=(i-last)>max?(i-last):max;
		return max;
	}

	public static void main(String[] args) {
		String string1 = "qwnfenpglqdq";
		String string2 = "-";
		System.out.println(lengthOfLongestSubstring(string1));
		System.out.println(lengthOfLongestSubstring(string2));

	}
}
